package com.example.aunraza_comp304_sec005_finalterm_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView tvOutput;
    RadioGroup rgStocks;
    RadioButton rbTemp;
    StockInfoViewModel mViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewModel = new ViewModelProvider(this).get(StockInfoViewModel.class);

        tvOutput = findViewById(R.id.tvOutput);
        rgStocks = findViewById(R.id.rgStocks);

        mViewModel.getAllStockInfo().observe(this, new Observer<List<StockInfo>>() {
            @Override
            public void onChanged(List<StockInfo> stockInfos) {
                rgStocks.removeAllViews();
                for (StockInfo stockInfo : stockInfos) {
                    String symbol = stockInfo.getStockSymbol();
                    rbTemp = new RadioButton(MainActivity.this);
                    rbTemp.setText(symbol);
                    rgStocks.addView(rbTemp);
                }
            }
        });
    }

    public void insertStockInfo(View view) {
//        if (mViewModel.getAllStockInfo().getValue().size() == 0)
//            return;

        mViewModel.insertStockInfo(new StockInfo("APPL", "Apple Inc", 199.99));
        mViewModel.insertStockInfo(new StockInfo("GOOG", "Google Inc", 399.99));
    }

    public void displayStockInfo(View view) {
        int radioButtonId = rgStocks.getCheckedRadioButtonId();
        if (radioButtonId == -1) return;

        String symbol = ((RadioButton) findViewById(radioButtonId)).getText().toString();
        StockInfo stockInfo = mViewModel.getStockInfo(symbol);
        String companyName = stockInfo.getCompanyName();
        String price = String.valueOf(stockInfo.getStockQuote());
        tvOutput.setText(symbol + " " + companyName + " " + price);

        Intent intent = new Intent(this, ToastService.class);
        intent.putExtra("COMPANY_NAME", companyName);
        intent.putExtra("PRICE", price);
        startService(intent);

    }
}