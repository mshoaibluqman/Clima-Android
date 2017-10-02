package com.londonappbrewery.climapm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import static android.R.id.edit;

public class ChangeCityController extends AppCompatActivity {

    EditText mChangeCity;
    ImageButton mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_city_layout);

        mChangeCity = (EditText) findViewById(R.id.queryET);
        mBackButton = (ImageButton) findViewById(R.id.backButton);

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        mChangeCity.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                String cityName = mChangeCity.getText().toString();

                Intent intent = new Intent(ChangeCityController.this, WeatherController.class);
                intent.putExtra("City", cityName);
                startActivity(intent);

                return false;
            }
        });

    }

}
