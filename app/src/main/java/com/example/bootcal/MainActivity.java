package com.example.bootcal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

/**
 * <h1>BootCal Menu</h1>
 * This is the menu activity that we use to
 * navigate the Calender and ViewData activities.
 * <p>
 * Within this class we implement the OnClickListener interface.
 *
 * @author Ishan Mark
 * @version 1.0
 * Since 2022-08-23
 */

public class MainActivity extends AppCompatActivity {

    /**
     * Declaration of the variable
     */
    private CardView cvAddEvent, cvViewEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Set Full Screen mode
         */
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();


        /**
         * Call Interface Id in Declarations variable
         */
        cvAddEvent = (CardView) findViewById(R.id.cvAddEvent);
        cvViewEvent = (CardView) findViewById(R.id.cvViewEvent);

        /**
         * Set on click listener to Menu view to Calender Activity
         */
        cvAddEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CalenderActivity.class);
                startActivity(intent);
                finish();
            }
        });
        /**
         * Set on click listener to Menu view to View Activity
         */
        cvViewEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewData.class);
                startActivity(intent);
                finish();
            }
        });
    }


}