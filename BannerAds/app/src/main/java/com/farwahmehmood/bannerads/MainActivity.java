package com.farwahmehmood.bannerads;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.farwahmehmood.bannerads.Models.Adds;
import com.farwahmehmood.bannerads.Models.SmaatoNativeAdView;
import com.smaato.sdk.banner.ad.BannerAdSize;
import com.smaato.sdk.banner.widget.BannerError;
import com.smaato.sdk.banner.widget.BannerView;
import com.smaato.sdk.core.Config;
import com.smaato.sdk.core.SmaatoSdk;
import com.smaato.sdk.core.ad.AdRequest;
import com.smaato.sdk.core.log.LogLevel;
import com.smaato.sdk.interstitial.EventListener;
import com.smaato.sdk.interstitial.Interstitial;
import com.smaato.sdk.interstitial.InterstitialAd;
import com.smaato.sdk.interstitial.InterstitialError;
import com.smaato.sdk.interstitial.InterstitialRequestError;
import com.smaato.sdk.nativead.NativeAd;
import com.smaato.sdk.nativead.NativeAdAssets;
import com.smaato.sdk.nativead.NativeAdError;
import com.smaato.sdk.nativead.NativeAdRenderer;
import com.smaato.sdk.nativead.NativeAdRequest;
import com.smaato.sdk.nativead.NativeAdView;


public class MainActivity extends AppCompatActivity {

    FrameLayout Banners;
    BannerView bannerView;

    Lifecycle owner;
    FrameLayout frameLayout;
    Button Show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // // initialize SDK first!
        Config config = Config.builder()
                // log errors only
                .setLogLevel(LogLevel.ERROR)
                // allow HTTPS traffic only
                .setHttpsOnly(true)
                .build();
        // initialize the Smaato SDK
        SmaatoSdk.init(getApplication(), config, "0");
        SmaatoSdk.setGPSEnabled(true);
        setContentView(R.layout.activity_main);
        Banners = (FrameLayout) findViewById(R.id.bannerad);
        bannerView = (BannerView) findViewById(R.id.bannerView);
        frameLayout=(FrameLayout) findViewById(R.id.nativeads);
        Show= findViewById(R.id.interstitial);


        Adds adds = new Adds(MainActivity.this,frameLayout);
        adds.showBanners(bannerView, getApplication());


        Show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adds.showInterstitials();
            }
        });

       adds.ShowNativeAds();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bannerView.destroy();
    }

}