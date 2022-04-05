package com.example.shoppinglist;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

//import com.example.shoppinglist.databinding.FragmentMainMenuBinding;
import com.example.shoppinglist.databinding.FragmentNewListBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;


import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainMenu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewList extends Fragment {

    EditText et;
    Button bt;
    ListView lv;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;

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

        et = (EditText) view.findViewById(R.id.edittext);
        bt = (Button) view.findViewById(R.id.button_addData);
        lv = (ListView) view.findViewById(R.id.listView_lv);

        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arrayList);
        lv.setAdapter(adapter);

        binding.buttonX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(NewList.this)
                        .navigate(R.id.action_NewList_to_MainMenu);
            }
        });

        binding.buttonAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = et.getText().toString();
                arrayList.add(result);
                adapter.notifyDataSetChanged();
                String empty_st = "";
                et.setText(empty_st);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}