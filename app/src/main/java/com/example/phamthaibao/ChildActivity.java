package com.example.phamthaibao;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class ChildActivity extends AppCompatActivity {
    EditText edtUsd;
    TextView tvVnd;
    Button btnConvert2;
    DecimalFormat decimalFormat = new DecimalFormat("###.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_child);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtUsd = findViewById(R.id.edtUsd);
        tvVnd = findViewById(R.id.tvVnd);
        btnConvert2 = findViewById(R.id.btnConvert2);
        Intent intent = getIntent();
        double vnd = intent.getDoubleExtra("vnd",0);
        double usd = vnd/26300;
        String usdFormat= decimalFormat.format(usd);
        tvVnd.setText("Chuyển "+ vnd +" VND thành "+usdFormat +" USD");
        edtUsd.setText(usdFormat);

        btnConvert2.setOnClickListener(v -> {
            double textUsd= Double.parseDouble(edtUsd.getText().toString().replace(",",""));
            double vndtext = textUsd*26300;
            String vndFormat = decimalFormat.format(vndtext);
            intent.putExtra("kq",vndFormat);
            setResult(34,intent);
            finish();
        });
    }
}