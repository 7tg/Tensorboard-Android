package com.tayyipgoren.mltoolbox;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ConnectFragment extends Fragment {
    EditText ip, port;
    Button connect;

    public static boolean haveInternet(Context ctx) {

        NetworkInfo info = (NetworkInfo) ((ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();

        if (info == null || !info.isConnected()) {
            return false;
        }
        if (info.isRoaming()) {
            // here is the roaming option you can change it if you want to
            // disable internet while roaming, just return false
            return false;
        }
        return true;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments

        return inflater.inflate(R.layout.fragment_connect, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        ip = (EditText) getView().findViewById(R.id.ip_address);
        port = (EditText) getView().findViewById(R.id.port);

        connect = (Button) getView().findViewById(R.id.connect_button);

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String adress = ip.getText().toString();
                String port_num = port.getText().toString();

                if (haveInternet(getContext()) == false) {
                    Toast.makeText(getContext(), getString(R.string.error_no_connection_avaible), Toast.LENGTH_LONG).show();
                    return;
                } else if (adress.equals("") || port_num.equals("")) {
                    Toast.makeText(getContext(), getString(R.string.error_ip_or_port_isnotvalid), Toast.LENGTH_LONG).show();
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("url", "http://" + adress + ":" + port_num + "/");
                bundle.putString("title", getString(R.string.tensorboard));
                WebPageFragment webPageFragment = new WebPageFragment();
                webPageFragment.setArguments(bundle);

                // Hide keyboard
                InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, webPageFragment);
                ft.commit();
            }
        });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle(getString(R.string.connect));
    }

}