package com.example.nishat.burkeleygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int num1;
    private int num2;
    private int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pickNumbers();
    }
    public void pickNumbers(){
        Button lButton = (Button) findViewById(R.id.leftButton);
        Button rButton = (Button) findViewById(R.id.rightButton);

        Random randy = new Random();
        num1 = 0 ;
        num2 = 0;
        while (num1 == num2) {
            num1 = randy.nextInt(10);
            num2 = randy.nextInt(10);
        }
        lButton.setText(String.valueOf(num1));
        rButton.setText(String.valueOf(num2));
    }

    public void leftButton_click(View view) {
        if(num1>num2) {
            Toast.makeText(this, "Correcr!", Toast.LENGTH_SHORT).show();
            points++;
        } else {
            Toast.makeText(this, "You're stupid!", Toast.LENGTH_SHORT).show();
            points--;
        }
        TextView pointsView = (TextView) findViewById(R.id.pointsView);
        pointsView.setText("Points: "+points);
        pickNumbers();
    }

    public void rightButton_click(View view) {
        if(num2>num1) {
            Toast.makeText(this, "Correcr!", Toast.LENGTH_SHORT).show();
            points++;
        } else {
            Toast.makeText(this, "You're stupid!", Toast.LENGTH_SHORT).show();
            points--;
        }
        TextView pointsView = (TextView) findViewById(R.id.pointsView);
        pointsView.setText("Points: "+points);
        pickNumbers();
    }

}
