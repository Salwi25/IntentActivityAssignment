package com.example.activityassignment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button nextBtn1, nextBtn2;
    EditText menuEditText;
    TextView jumlahView;
    public static final String MENU_EXTRA = "MENU_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextBtn1 = findViewById(R.id.makanan);
        nextBtn2 = findViewById(R.id.minuman);
        menuEditText = findViewById(R.id.menu);
        jumlahView = findViewById(R.id.jumlah);

        nextBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SecondActivity.class);
                String menu = menuEditText.getText().toString();
                intent.putExtra(MENU_EXTRA, menu);
//              startActivity(intent);

                startActivityForResult(intent, 1);
            }
        });
        nextBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SecondActivity.class);
                String menu = menuEditText.getText().toString();
                intent.putExtra(MENU_EXTRA, menu);
    //              startActivity(intent);

                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String jumlahText = data.getStringExtra(SecondActivity.JUMLAH_EXTRA);
            jumlahView.setText(jumlahText);
        }
    }
}