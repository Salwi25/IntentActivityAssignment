package com.example.activityassignment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView menuTextView1, menuTextView2;
    EditText jumlahEditText;
    Button okBtn;

    public static final String JUMLAH_EXTRA="JUMLAH_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d("SECOND ACTIVITY", "on create");
        menuTextView1 = findViewById(R.id.pilihan1);
        menuTextView2 = findViewById(R.id.pilihan2);
        okBtn = findViewById(R.id.ok);
        jumlahEditText = findViewById(R.id.jumlah2);

        Intent intent = getIntent();
        String menu1 = intent.getStringExtra(MainActivity.MENU_EXTRA);
        menuTextView1.setText(menu1);
        String menu2 = intent.getStringExtra(MainActivity.MENU_EXTRA);
        menuTextView2.setText(menu2);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String jumlahMenu = jumlahEditText.getText().toString();
                intent.putExtra(JUMLAH_EXTRA, jumlahMenu);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
