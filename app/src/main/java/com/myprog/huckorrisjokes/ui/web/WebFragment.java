package com.myprog.huckorrisjokes.ui.web;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.myprog.huckorrisjokes.R;
import com.myprog.huckorrisjokes.util.CustomWebView;

public class WebFragment extends Fragment {

    private WebView webView;
    private static final String URL = "http://www.icndb.com/api/";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_web, container, false);

        webView = root.findViewById(R.id.web_view);
        webView.setWebViewClient(new CustomWebView());
        if(savedInstanceState == null)
            webView.loadUrl(URL);
        else
            webView.restoreState(savedInstanceState);

        return root;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        webView.saveState(outState);
        super.onSaveInstanceState(outState);
    }

}