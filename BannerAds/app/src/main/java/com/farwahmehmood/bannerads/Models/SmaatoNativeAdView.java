package com.farwahmehmood.bannerads.Models;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.farwahmehmood.bannerads.R;
import com.smaato.sdk.nativead.NativeAdView;

public class SmaatoNativeAdView implements NativeAdView {
    private final View binding;
   public SmaatoNativeAdView(View binding) {

       this.binding = binding;
    }

    @Nullable
    @Override
    public TextView titleView()
    {
        return binding.findViewById(R.id.t1);
    }

    @Nullable
    @Override
    public TextView textView() {
        return binding.findViewById(R.id.t2);
    }

    @Nullable
    @Override
    public TextView sponsoredView() {
        return null;
    }

    @Nullable
    @Override
    public TextView ctaView() {
        return binding.findViewById(R.id.t3);
    }

    @Nullable
    @Override
    public View iconView() {
        return binding.findViewById(R.id.img);
    }

    @Nullable
    @Override
    public View mediaView() {
        return null;
    }

    @Nullable
    @Override
    public View ratingView() {
        return null;
    }

    @Nullable
    @Override
    public View privacyView() {
        return null;
    }
}
