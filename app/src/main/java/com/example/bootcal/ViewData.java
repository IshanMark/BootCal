package com.example.bootcal;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.bootcal.Adapter.MyAdapter;
import com.example.bootcal.DBManager.DBManager;
import com.example.bootcal.Model.Model;

import java.util.ArrayList;


/**
 * <h2>View Data</h2>
 * This is the ViewData activity that we use to
 * Viewing in added Data
 * <p>
 *  Within this class we view data in saved.
 *
 * @author Ishan Mark
 * @version 1.0
 * Since 2022-08-23
 */

public class ViewData extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Model> dataHolder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        /**
         * Set Full Screen mode
         */
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        /**
         * Call Interface Id in Declarations variable
         */
        recyclerView = (RecyclerView) findViewById(R.id.rvView);

        /**
         * get Adapter class data and view in RecyclerView
         */
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Cursor cursor = new DBManager(this).readAllData();
        dataHolder = new ArrayList<>();

        while (cursor.moveToNext()){
            Model obj = new Model(cursor.getString(1),cursor.getString(2),cursor.getString(3));
            dataHolder.add(obj);
        }

        MyAdapter adapter = new MyAdapter(dataHolder);
        recyclerView.setAdapter(adapter);
    }

    /**
     * override and
     * set onBackPressed in Menu activity
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ViewData.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

}