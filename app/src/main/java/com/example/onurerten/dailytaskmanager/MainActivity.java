package com.example.onurerten.dailytaskmanager;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView list_task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_task = (ListView) findViewById(R.id.list_task);
        items = new ArrayList<String>();
        itemsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);
        list_task.setAdapter(itemsAdapter);


        ListViewDelete();

    }

    private void ListViewDelete(){
        list_task.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View item, int pos, long id){
                items.remove(pos);
                itemsAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    public void add_task(View v) {
        EditText new_task = (EditText) findViewById(R.id.new_task);
        String itemText = new_task.getText().toString();
        itemsAdapter.add(itemText);
        new_task.setText("");
    }


}
