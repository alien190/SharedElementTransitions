package com.example.alien.sharedelementtransitions;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.SharedElementCallback;
import android.support.v4.view.ViewCompat;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class FirstFragment extends Fragment {

    private ImageView mImageView;
    //private TextView mTextView;

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
        //mTextView = view.findViewById(R.id.tvText);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .setReorderingAllowed(true)
                        .addSharedElement(mImageView,
                                ViewCompat.getTransitionName(mImageView))
                        .replace(R.id.container, SecondFragment.newInstance())
                        .addToBackStack("TAG")

                        .commit();
            }
        });

        setExitTransition(TransitionInflater.from(getContext()).inflateTransition(R.transition.launch_list_exit_transition));
        setExitSharedElementCallback(new SharedElementCallback() {
            @Override
            public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
                sharedElements.put(names.get(0), mImageView);
            }
        });

        // postponeEnterTransition();


        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        // startPostponedEnterTransition();
    }


}
