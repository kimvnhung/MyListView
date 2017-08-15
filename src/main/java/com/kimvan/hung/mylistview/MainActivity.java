package com.kimvan.hung.mylistview;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Map<String,Integer> imgLinkId = new HashMap<>();
    String[] nameImag = {"add","clear all","clear","divide","eight","equals","five","four","multilition","nine","one"};
    EditText inputName;
    EditText inputStatus;
    Button insertButton;
    Spinner spinner_pic;
    Spinner spinner_sex;
    ListView listView;
    ArrayAdapter<String> adapter;
    CustomApdater customAdapter ;
    ArrayList<RowItem> rowItems = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //link the image name
        imgLinkId.put(nameImag[0],R.drawable.add_symbols_clicked);
        imgLinkId.put(nameImag[1],R.drawable.clear_all_clicked);
        imgLinkId.put(nameImag[2],R.drawable.clear_symbols_clicked);
        imgLinkId.put(nameImag[3],R.drawable.divide_symbol_clicked);
        imgLinkId.put(nameImag[4],R.drawable.eight_symbol_clicked);
        imgLinkId.put(nameImag[5],R.drawable.equals_symbol_clicked);
        imgLinkId.put(nameImag[6],R.drawable.five_symbol_clicked);
        imgLinkId.put(nameImag[7],R.drawable.four_symbol_clicked);
        imgLinkId.put(nameImag[8],R.drawable.multilition_symbol_clicked);
        imgLinkId.put(nameImag[9],R.drawable.nine_symbol_clicked);
        imgLinkId.put(nameImag[10],R.drawable.one_symbol_clicked);


        spinner_pic = (Spinner) findViewById(R.id.spinner_pic);
        spinner_sex = (Spinner) findViewById(R.id.spinner_sex);

        inputName = (EditText) findViewById(R.id.input_name);
        inputStatus = (EditText) findViewById(R.id.input_status);

        insertButton = (Button) findViewById(R.id.insert_button);
        listView = (ListView) findViewById(R.id.list_view);


        adapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,R.id.spinner_item,nameImag
        );
        spinner_pic.setAdapter(adapter);


        String[] sex = {"Male","Female"};
        adapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,R.id.spinner_item,sex
        );
        spinner_sex.setAdapter(adapter);

        insertButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        insertClick();
                    }
                }
        );
    }

    public void insertClick(){

        rowItems.add(new RowItem(getResourcesId(String.valueOf(spinner_pic.getSelectedItem())),inputName.getText().toString(),
                String.valueOf(spinner_sex.getSelectedItem()),inputStatus.getText().toString()));
        customAdapter = new CustomApdater(this,rowItems);

        listView.setAdapter(customAdapter);
        inputName.setText("");
        inputStatus.setText("");

    }

    private int getResourcesId(String name){
        int img = imgLinkId.get(name);
        return img;
    }
}
