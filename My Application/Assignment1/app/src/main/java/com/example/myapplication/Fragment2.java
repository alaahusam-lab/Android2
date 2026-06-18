package com.example.myapplication;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.myapplication.databinding.Fragment2Binding;
public class Fragment2 extends Fragment {
    interface OnFragmentInteractionListener {
        void onButtonClicked(String title);
    }
    private OnFragmentInteractionListener listener;
    public static Fragment2Binding fragment2Binding;

    public Fragment2() {
        // Required empty public constructor
    }
    public static Fragment2 newInstance() {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragment2Binding = Fragment2Binding.inflate(inflater, container, false);
        return fragment2Binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragment2Binding.buttonCont.setOnClickListener(view1 -> {
            String name = fragment2Binding.editText.getText().toString();
            if (!name.isEmpty() && listener != null) {
                listener.onButtonClicked(name);
            } else if (name.isEmpty()) {
                fragment2Binding.editText.setError("Enter Name First!");
            }
        });
    }
}