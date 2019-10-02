package com.example.homemortgageinterestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Interest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);
        TextView interest = (TextView)findViewById(R.id.txtInterest);
        ImageView image = (ImageView)findViewById(R.id.imgYears);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        float decMonthlyPayment = sharedPref.getFloat("key1", 0);
        int intYears = sharedPref.getInt("key2", 0);
        int intLoan = sharedPref.getInt("key3", 0);
        float decInterestPaid;
        int intMonths = intYears * 12;

        decInterestPaid = (decMonthlyPayment * intMonths) - intLoan;
        DecimalFormat currency = new DecimalFormat("$###,###.##");
        interest.setText("Total interest paid " + currency.format(decInterestPaid));
        if (intYears <= 10) {
            image.setImageResource(R.drawable.ten);
        }
        else if (intYears <= 20) {
            image.setImageResource(R.drawable.twenty);
        }
        else if (intYears <= 30) {
            image.setImageResource(R.drawable.thirty);
        }
        else {
            interest.setText("Enter 10, 20, or 30 years");
        }
    }
}
