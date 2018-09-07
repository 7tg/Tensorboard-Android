package com.tayyipgoren.tensorboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class WebPageFragment extends Fragment {

    protected WebView webView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.fragment_web_page, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles

        if (getArguments() != null) {
            String title = getArguments().getString("title");
            getActivity().setTitle(title);

            String url = getArguments().getString("url");
            // Reset Padding
            RelativeLayout relativeLayout = (RelativeLayout) getActivity().findViewById(R.id.content_layout);
            relativeLayout.setPadding(0, 0, 0, 0);

            webView = (WebView) getView().findViewById(R.id.web_view);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.invokeZoomPicker();
            webView.setWebViewClient(new WebViewClient());
            webView.setInitialScale(1);
            webView.getSettings().setBuiltInZoomControls(true);
            webView.getSettings().setUseWideViewPort(true);
            webView.loadUrl("http://www.google.com/");

            webView.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        if (keyCode == KeyEvent.KEYCODE_BACK) {
                            webView.goBack();
                            return true;
                        }
                    }

                    return false;
                }
            });

        }



    }


}