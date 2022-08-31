package com.kosgei.counterapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.kosgei.counterapp.databinding.FragmentFirstBinding;
import com.kosgei.counterapp.services.WelcomeService;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        Log.println(Log.INFO,"onCreate view","On Create View called");
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.println(Log.INFO,"onView Created ","On view created called");
        binding.buttonFirst.setOnClickListener(v->{
            Integer count = Integer.valueOf(binding.textviewFirst.getText().toString());
            Integer results = count +1;
            binding.textviewFirst.setText(results.toString());
            startWelcomeService(v);
        });

        binding.buttonFirst2.setOnClickListener(v -> {
            Integer count = Integer.valueOf(binding.textviewFirst.getText().toString());
            Integer results = count -1;
            binding.textviewFirst.setText(results.toString());
            stopWelcomeService(v);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void startWelcomeService(View  view){
        Log.d("SERVICE","Start service launched");
        getActivity().startService(new Intent(getActivity(), WelcomeService.class));
    }

    public void stopWelcomeService(View view){
        Log.d("SERVICE","stop service");
        getActivity().stopService(new Intent(getActivity(),WelcomeService.class));
    }

}