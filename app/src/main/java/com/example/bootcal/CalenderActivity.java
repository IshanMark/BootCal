package com.example.bootcal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bootcal.DBManager.DBManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * <h2>Calender Event</h2>
 * This is the Calender activity of the this application
 * navigate the Calender and ViewData activities.
 * <p>
 * Within this class we implement the OnClickListener interface.
 * we implement Insert data to SQLite Database
 *
 * @author Ishan Mark
 * @version 1.0
 * Since 2022-08-23
 */
public class CalenderActivity extends AppCompatActivity {

    /**
     * Declaration of the variable
     */

    private CalendarView calView;
    private FloatingActionButton btnFAB;

    private EditText etDate,etEvent, etNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        /**
         * Set Full Screen mode
         */
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        /**
         * Call Interface Id in Declarations variable
         */
        calView = (CalendarView)findViewById(R.id.calView);
        btnFAB = (FloatingActionButton) findViewById(R.id.btnFab);

        etDate = (EditText) findViewById(R.id.etDate);
        etEvent = (EditText) findViewById(R.id.etEvent);
        etNote = (EditText) findViewById(R.id.etNote);

        /**
         * Get date and change data type to String
         */
        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date = i+"/"+i1+"/"+i2;
                etDate.setText(date);
                btnFAB.setVisibility(View.VISIBLE);
            }
        });

        btnFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String dateTXT = etDate.getText().toString();
                String eventTXT = etEvent.getText().toString();
                String noteTXT = etNote.getText().toString();


                /**
                 * Check to data in added
                 */

                if(dateTXT.isEmpty()){
                    etDate.setError("Please Select Date");
                    etDate.requestFocus();
                    return;
                }
                if (eventTXT.isEmpty()){
                    etEvent.setError("Field can't be empty");
                    etEvent.requestFocus();
                    return;
                }
                if (noteTXT.isEmpty()){
                    etNote.setError("Field can't be empty");
                    etNote.requestFocus();
                    return;
                }else {
                    processInsert(dateTXT,eventTXT,noteTXT);
                    btnFAB.setVisibility(View.GONE);
                }
            }
        });
    }

    /**
     * Insert data to SQLite Database
     */
    private void processInsert(String n, String c, String e){
        String res = new DBManager(this).addRecord(n,c,e);
        etDate.setText("");
        etEvent.setText("");
        etNote.setText("");
        Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();
    }

    /**
     * override and
     * set onBackPressed in Menu activity
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(CalenderActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}