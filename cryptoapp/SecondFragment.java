package com.example.cryptoapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.cryptoapp.databinding.FragmentSecondBinding;
import com.example.cryptoapp.logic.MyViewModel;

public class SecondFragment extends Fragment{

    private static final String DEBUG_TAG = "Second Fragment";
    private FragmentSecondBinding binding;
    private MyViewModel model;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        model = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        binding = FragmentSecondBinding.inflate(inflater, container, false);

        binding.resultView.setText("Waiting for result...");

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.resultView.setText(model.getResult());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}