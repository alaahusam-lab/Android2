package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.myapplication.databinding.Fragment3Binding;

public class Fragment3 extends Fragment {
    interface OnFragmentInteractionListener {
        void onCheckboxStateChanged (boolean isChecked);

    }
    public static Fragment3Binding fragment3Binding;
    private Fragment3.OnFragmentInteractionListener listener1;
    public Fragment3() {
        // Required empty public constructor
    }
    public static Fragment3 newInstance(String title) {
        Fragment3 fragment = new Fragment3();
        Bundle args = new Bundle();
        args.putString("user_name", title);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Fragment2.OnFragmentInteractionListener) {
            listener1 = (Fragment3.OnFragmentInteractionListener) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragment3Binding = Fragment3Binding.inflate(inflater, container, false);
        return fragment3Binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            String userName = getArguments().getString("user_name");
            fragment3Binding.hello.setText("Hello " + userName + " !");
        }
        fragment3Binding.buttonFinish.setEnabled(false);

        fragment3Binding.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (listener1 != null) {
                listener1.onCheckboxStateChanged(isChecked);
            }
            if (isChecked) {
                fragment3Binding.buttonFinish.setEnabled(true);
                fragment3Binding.buttonFinish.setText("Finish");
            } else {
                fragment3Binding.buttonFinish.setEnabled(false);
                fragment3Binding.buttonFinish.setText("Continue");
            }
        });
        fragment3Binding.buttonFinish.setOnClickListener(v -> {
            if (getActivity() != null) getActivity().finish();
        });
    }
}




