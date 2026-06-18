package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements Fragment2.OnFragmentInteractionListener, Fragment3.OnFragmentInteractionListener {

    private ActivityMainBinding binding;

    private int currentFragment = 1;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, Fragment1.newInstance(null, null))
                    .commit();
        }

        binding.buttonContinue.setOnClickListener(view -> {
            if (currentFragment == 1) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, Fragment2.newInstance())
                        .addToBackStack(null)
                        .commit();

                currentFragment = 2;
                binding.buttonContinue.setVisibility(View.GONE);
            }

        });

    }
    @Override
        public void onButtonClicked(String title) {

            Fragment3 fragment3 = Fragment3.newInstance(title);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment3)
                    .addToBackStack(null)
                    .commit();
        }

   @Override
    public void onCheckboxStateChanged(boolean isChecked) {
        if(isChecked) {
           // Toast.makeText(this, "Now Finish", Toast.LENGTH_SHORT).show();
        }
    }
}