package com.example.alien.sharedelementtransitions;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FirstFragment extends Fragment {

    private ImageView mImageView;

    public static FirstFragment newInstance() {

        Bundle args = new Bundle();

        FirstFragment fragment = new FirstFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_first, container, false);
        mImageView = view.findViewById(R.id.first_image);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .addSharedElement(mImageView,
                                ViewCompat.getTransitionName(mImageView))
                        .addToBackStack("TAG")
                        .replace(R.id.container, SecondFragment.newInstance())
                        .commit();
            }
        });
        return view;
    }
}
