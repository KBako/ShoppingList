package com.example.shoppinglist;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class listTest extends AppCompatActivity {

    EditText et;
    Button bt;
    ListView lv;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.edittext);
        bt = (Button) findViewById(R.id.button_addData);
        lv = (ListView) findViewById(R.id.listView_lv);

        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        lv.setAdapter(adapter);

        onBtnClick();
    }

    public void onBtnClick(){
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = et.getText().toString();
                arrayList.add(result);
                adapter.notifyDataSetChanged();
            }
        });
    }
}