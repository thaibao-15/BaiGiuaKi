package com.example.phamthaibao;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText edtVnd;
    TextView tvUsd;
    Button btnConvert1;
    DecimalFormat decimalFormat = new DecimalFormat("###.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtVnd = findViewById(R.id.edtVnd);
        tvUsd = findViewById(R.id.tvUsd);
        btnConvert1 = findViewById(R.id.btnConcvert1);
        btnConvert1.setOnClickListener(v -> {
            double edtVndvalue= Double.parseDouble(edtVnd.getText().toString().trim());

            Intent intent = new Intent(MainActivity.this, ChildActivity.class);
            intent.putExtra("vnd",edtVndvalue);
            startActivityForResult(intent,99);
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==99 && resultCode == 34){
            String vndValue = data.getStringExtra("kq");
            tvUsd.setText(vndValue);
            edtVnd.setText(vndValue);
        }
    }
}