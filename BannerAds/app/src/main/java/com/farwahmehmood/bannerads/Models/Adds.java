package com.farwahmehmood.bannerads.Models;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.farwahmehmood.bannerads.MainActivity;
import com.farwahmehmood.bannerads.R;
import com.smaato.sdk.banner.ad.BannerAdSize;
import com.smaato.sdk.banner.widget.BannerError;
import com.smaato.sdk.banner.widget.BannerView;
import com.smaato.sdk.interstitial.EventListener;
import com.smaato.sdk.interstitial.Interstitial;
import com.smaato.sdk.interstitial.InterstitialAd;
import com.smaato.sdk.interstitial.InterstitialError;
import com.smaato.sdk.interstitial.InterstitialRequestError;
import com.smaato.sdk.nativead.NativeAd;
import com.smaato.sdk.nativead.NativeAdError;
import com.smaato.sdk.nativead.NativeAdRenderer;
import com.smaato.sdk.nativead.NativeAdRequest;
import com.smaato.sdk.nativead.NativeAdView;

public class Adds {
    Context context;
    FrameLayout frameLayout;

    public Adds(Context context, FrameLayout frameLayout) {
        this.context = context;
        this.frameLayout = frameLayout;

    }
//////////////////*****************************Interstitials event listner*********************************//////////////////////////////

    EventListener eventListener = new EventListener() {
        @Override
        //show interstitial ad when it loaded successfully
        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
            interstitialAd.setBackgroundColor(0xff123456);
            interstitialAd.showAd((Activity) context);
        }

        @Override
        // interstitial ad failed to load
        public void onAdFailedToLoad(@NonNull InterstitialRequestError interstitialRequestError) {
            Toast.makeText(context, "Failed" + interstitialRequestError.getInterstitialError(), Toast.LENGTH_LONG).show();

        }

        @Override
        // interstitial ad had an unexpected error
        public void onAdError(@NonNull InterstitialAd interstitialAd, @NonNull InterstitialError interstitialError) {
            Toast.makeText(context, "Failed error" + interstitialError, Toast.LENGTH_LONG).show();
        }

        @Override
        // interstitial ad opened and was shown successfully
        public void onAdOpened(@NonNull InterstitialAd interstitialAd) {
        }

        @Override
        // interstitial ad was closed by the user
        public void onAdClosed(@NonNull InterstitialAd interstitialAd) {
            Interstitial.loadAd("130626426", eventListener);
        }

        @Override
        // interstitial ad was clicked by the user
        public void onAdClicked(@NonNull InterstitialAd interstitialAd) {
        }

        @Override
        // interstitial ad was viewed by the user
        public void onAdImpression(@NonNull InterstitialAd interstitialAd) {
        }

        @Override
        // interstitial ad Time to Live expired
        public void onAdTTLExpired(@NonNull InterstitialAd interstitialAd) {
        }
    };

//////////////////*****************************Banner Show*********************************//////////////////////////////


    public void showBanners(BannerView bannerView, Context context) {
        bannerView.loadAd("0", BannerAdSize.XX_LARGE_320x50);

// You can also set BannerView.EventListener to listen to events describing the advertisement lifecycle:
        bannerView.setEventListener(new BannerView.EventListener() {
            @Override
            // banner ad successfully loaded
            public void onAdLoaded(@NonNull BannerView bannerView) {
                Toast.makeText(context, "Hello", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAdFailedToLoad(@NonNull BannerView bannerView, @NonNull BannerError bannerError) {
                Toast.makeText(context, "Failed" + bannerError, Toast.LENGTH_LONG).show();
            }

            @Override
            // banner ad was seen by the user
            public void onAdImpression(@NonNull BannerView bannerView) {
            }

            @Override
            // banner ad was clicked by the user
            public void onAdClicked(@NonNull BannerView bannerView) {
            }

            @Override
            // banner ad Time to Live expired
            public void onAdTTLExpired(@NonNull BannerView bannerView) {
            }

        });
    }

//////////////////*****************************Show Interstitials *********************************//////////////////////////////

    public void showInterstitials() {

        Interstitial.loadAd("130626426", eventListener);
    }

//////////////////*****************************NativeAds event listner*********************************//////////////////////////////

    NativeAd.Listener listener = new NativeAd.Listener() {


        @Override
        public void onAdLoaded(@NonNull NativeAd nativeAd, @NonNull NativeAdRenderer nativeAdRenderer) {

            View rowView = View.inflate(context, R.layout.nativeads, null);
            // View.inflate(context,R.layout.nativeads,null);

            NativeAdView nativeAdView = new SmaatoNativeAdView(rowView); // Create NativeAdView
            nativeAdRenderer.renderInView(nativeAdView); // Render your view using SmaatoSDK
            // SmaatoSDK will care about loading all creatives and display them in certain views.

            // Register ad view for impression tracking and user clicks handling
            nativeAdRenderer.registerForImpression(rowView);
            nativeAdRenderer.registerForClicks(nativeAdView.ctaView());
            frameLayout.addView(rowView); // Add adView into your view hierarchy
        }

        @Override
        public void onAdFailedToLoad(@NonNull NativeAd nativeAd, @NonNull NativeAdError nativeAdError) {

            Toast.makeText(context, "Error: " + nativeAdError, Toast.LENGTH_LONG).show();

        }

        @Override
        public void onAdImpressed(@NonNull NativeAd nativeAd) {

        }

        @Override
        public void onAdClicked(@NonNull NativeAd nativeAd) {

        }

        @Override
        public void onTtlExpired(@NonNull NativeAd nativeAd) {


        }
    };

//////////////////*****************************Show NativeADs*********************************//////////////////////////////

    public void ShowNativeAds() {
        NativeAdRequest request;
        request = new NativeAdRequest() {
            @NonNull
            @Override
            public String adSpaceId() {
                return "130783664";
            }

            @Override
            public boolean shouldReturnUrlsForImageAssets() {
                return false;
            }
        };
        NativeAd.loadAd(com.smaato.sdk.sys.Lifecycling.of((Activity) context), request, listener);

    }
}
