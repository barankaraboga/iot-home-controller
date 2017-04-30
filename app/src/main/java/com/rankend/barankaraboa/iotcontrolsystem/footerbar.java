package com.rankend.barankaraboa.iotcontrolsystem;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Baran on 24.06.2016.
 */
public class footerbar extends Fragment {

    ImageView homeImage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.footerbar,container,false);
        homeImage = (ImageView)(view.findViewById(R.id.imageView));
        homeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Home fonksiyon",Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}
