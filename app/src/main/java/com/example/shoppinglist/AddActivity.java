package com.example.shoppingapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.shoppinglist.MainActivity;
import com.example.shoppinglist.MyDatabaseHelper;
import com.example.shoppinglist.NewList;
import com.example.shoppinglist.R;
import com.example.shoppinglist.databinding.ActivityAddBinding;
import com.example.shoppinglist.databinding.FragmentNewListBinding;

import java.util.ArrayList;

public class AddActivity extends Fragment {

    EditText item_input, item_price, item_quantity;
    Button add_button;

    private ActivityAddBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_main_menu, container, false);
        binding = ActivityAddBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setContentView(R.layout.activity_add);

        item_input = view.findViewById(R.id.item_input);
        item_price = view.findViewById(R.id.item_price);
        item_quantity = view.findViewById(R.id.item_quantity);
        add_button = view.findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addItem(item_input.getText().toString().trim(),
                        item_price.getText().toString().trim(),
                        Integer.valueOf(item_quantity.getText().toString().trim()));
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}