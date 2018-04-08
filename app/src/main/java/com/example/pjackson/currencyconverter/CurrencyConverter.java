package com.example.pjackson.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CurrencyConverter extends AppCompatActivity {
    double conversionRate = 1.40875;
    double amountEntered = 0.0;
    double convertedAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText amount = findViewById(R.id.txtCurrency);
        final RadioButton usdToGBP = findViewById(R.id.radUSDToGBP);
        final RadioButton gbpToUSD = findViewById(R.id.radGBPToUSD);
        final TextView result = findViewById(R.id.txtResult);
        Button convert = findViewById(R.id.btnConvert);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amountEntered = Double.parseDouble(amount.getText().toString());
                DecimalFormat hundredth = new DecimalFormat("#.##");
                if (usdToGBP.isChecked()) {
                    if (amountEntered <= 10000.00) {
                        convertedAmount = amountEntered / conversionRate;
                        String textResult = hundredth.format(convertedAmount) + " UK Pounds";
                        result.setText(textResult);
                    } else {
                        Toast.makeText(CurrencyConverter.this, "This app is designed for amounts less than 10,000 US Dollars",
                                Toast.LENGTH_LONG).show();
                    }
                }
                if (gbpToUSD.isChecked()) {
                    if (amountEntered <= 7000.00) {
                        convertedAmount = amountEntered * conversionRate;
                        String textResult = hundredth.format(convertedAmount) + " US Dollars";
                        result.setText(textResult);
                    } else {
                        Toast.makeText(CurrencyConverter.this, "This App is designed for amounts less than 7,000 UK Pounds",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
