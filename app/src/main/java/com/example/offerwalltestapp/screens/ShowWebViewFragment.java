package com.example.offerwalltestapp.screens;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.offerwalltestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ShowWebViewFragment extends Fragment {
    private static final int LAYOUT_RES = R.layout.fragment_show_web;

    @BindView(R.id.web_view)
    WebView webView;

    private Unbinder unbinder;
    private String url;

    public ShowWebViewFragment(String url) {
        this.url = url;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(LAYOUT_RES, container, false);
        unbinder = ButterKnife.bind(this, v);
        webView.getSettings().setDomStorageEnabled(true);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setSupportZoom(true);
        webSettings.setDefaultTextEncodingName("utf-8");
        startView(url);
        return v;
    }

    public void startView(String url){
        webView.setVisibility(View.VISIBLE);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient() {
                                     @Override
                                     public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                                         return super.shouldOverrideUrlLoading(view, request);
                                     }
                                 }
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
