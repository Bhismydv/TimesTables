package com.example.dell.geolocation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    ListView listView;

    int timesTablesNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar=findViewById(R.id.seekBar);
        listView=findViewById(R.id.listView);

        int max=100;
        int startingPosition=1;

        seekBar.setMax(max);
        seekBar.setProgress(startingPosition);

        generateTimesTable(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int minimum=1;

                if (progress<minimum){
                    timesTablesNumber=minimum;
                    seekBar.setProgress(minimum);
                }else{
                    timesTablesNumber=progress;
                }

                generateTimesTable(timesTablesNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void generateTimesTable(int timesTableNumber){
        ArrayList<String> timesTablesContent=new ArrayList<String>();

        //for table
        for (int j=1;j<=100;j++){
            timesTablesContent.add(Integer.toString(j * timesTableNumber));
        }

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timesTablesContent);

        listView.setAdapter(arrayAdapter);
    }
}
