package com.example.helloworld;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private EditText inputEt;
    private Button displayBtn;
    private TextView displayTv;
    private Button printBtn;
    private static final String TAG = "MainActivity";

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

        this.inputEt = findViewById(R.id.inputEt);
        this.displayBtn = findViewById(R.id.displayBtn);
        this.displayTv = findViewById(R.id.displayTv);
        this.printBtn = findViewById(R.id.printBtn);

        this.displayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayTv.setText("Hello, " + inputEt.getText().toString());
                Log.d(TAG, "Display button clicked!");
            }
        });


        this.printBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hello, " + inputEt.getText().toString(), Toast.LENGTH_LONG).show();
                Log.d(TAG, "Print button clicked!");
            }
        });
    }
}