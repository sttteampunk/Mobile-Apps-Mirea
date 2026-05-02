package com.mirea.trubnikovdo.mireaproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class WebViewFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_webview, container, false);

        WebView webView = view.findViewById(R.id.my_webview);

        // Ensure links open inside the app, not in Chrome
        webView.setWebViewClient(new WebViewClient());

        // Enable JavaScript for modern websites
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // The default page to load (Let's use a cool ricing/customization site like GitHub)
        webView.loadUrl("https://github.com/sttteampunk/win11-rice");

        return view;
    }
}