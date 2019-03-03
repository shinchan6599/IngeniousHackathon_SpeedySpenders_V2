package com.example.auditor;

import android.content.res.AssetManager;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private TextView[][] arr = new TextView[3][6];
    private String [] temp = null;
    private int j,i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arr[0][0] = (TextView) findViewById(R.id.TH1_1);
        arr[0][1] = (TextView) findViewById(R.id.TH1_2);
        arr[0][2] = (TextView) findViewById(R.id.TH1_3);
        arr[0][3] = (TextView) findViewById(R.id.TH1_4);
        arr[0][4] = (TextView) findViewById(R.id.TH1_5);
        arr[0][5] = (TextView) findViewById(R.id.TH1_6);
        arr[1][0] = (TextView) findViewById(R.id.TH2_1);
        arr[1][1] = (TextView) findViewById(R.id.TH2_2);
        arr[1][2] = (TextView) findViewById(R.id.TH2_3);
        arr[1][3] = (TextView) findViewById(R.id.TH2_4);
        arr[1][4] = (TextView) findViewById(R.id.TH2_5);
        arr[1][5] = (TextView) findViewById(R.id.TH2_6);
        arr[2][0] = (TextView) findViewById(R.id.TH3_1);
        arr[2][1] = (TextView) findViewById(R.id.TH3_2);
        arr[2][2] = (TextView) findViewById(R.id.TH3_3);
        arr[2][3] = (TextView) findViewById(R.id.TH3_4);
        arr[2][4] = (TextView) findViewById(R.id.TH3_5);
        arr[2][5] = (TextView) findViewById(R.id.TH3_6);


        AssetManager assetManager = getAssets();
        InputStream inputStream =  null;
        try {
            inputStream = assetManager.open("data.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        try {
            i = 0;
            while((line = in.readLine()) != null) {
                String word = line.trim();
                temp = word.split("&&");
                if(temp[2].equals("0")) {
                    for (j = 0; j < 6; j++) {
                        arr[i][j].setTextColor(Color.RED);
                        arr[i][j].setText(temp[j]);
                        Log.d("heyy", temp[j]);
                    }
                }
                else
                {
                    for (j = 0; j < 6; j++) {
                        arr[i][j].setTextColor(Color.GREEN);
                        arr[i][j].setText(temp[j]);
                        Log.d("heyy", temp[j]);
                    }
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
