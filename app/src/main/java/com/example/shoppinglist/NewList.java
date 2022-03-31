package com.example.shoppinglist;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import com.example.shoppinglist.databinding.FragmentMainMenuBinding;
import com.example.shoppinglist.databinding.FragmentNewListBinding;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainMenu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewList extends Fragment {

    private FragmentNewListBinding binding;

    public NewList() {
        // Required empty public constructor
    }


    public static NewList newInstance(String param1, String param2) {
        NewList fragment = new NewList();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_main_menu, container, false);
        binding = FragmentNewListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        binding.buttonAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}