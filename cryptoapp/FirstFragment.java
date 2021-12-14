package com.example.cryptoapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.cryptoapp.databinding.FragmentFirstBinding;
import com.example.cryptoapp.logic.MyViewModel;

import java.text.ParseException;

public class FirstFragment extends Fragment {

    private static final String DEBUG_TAG = "FirstFragment";
    private FragmentFirstBinding binding;
    private MyViewModel model;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        model = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String start = binding.startDate.getText().toString();
                String end = binding.endDate.getText().toString();

                try {
                    model.setStartDate(start);
                    model.setEndDate(end);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                ((MainActivity)getActivity()).updateCall();

                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}