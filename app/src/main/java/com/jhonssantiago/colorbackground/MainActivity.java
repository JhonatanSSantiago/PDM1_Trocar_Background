package com.jhonssantiago.colorbackground;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.view);

        Intent it = getIntent();
        if (it != null){
            int cor = it.getIntExtra("cor", 2);
            mudarColor(cor);
        }


        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openAlertDialog();
            }
        });

    }

    public void openAlertDialog(){
        MyDialogFragment mdf = new MyDialogFragment();
        mdf.show(getSupportFragmentManager(), "cor");
    }

    public void mudarColor(int cor){
        switch (cor) {
            case 0:
                view.setBackgroundColor(Color.BLUE);
                break;
            case 1:
                view.setBackgroundColor(Color.BLACK);
                break;
            case 2:
                view.setBackgroundColor(Color.WHITE);
                break;
            case 3:
                view.setBackgroundColor(Color.YELLOW);
                break;
        }

    }
}