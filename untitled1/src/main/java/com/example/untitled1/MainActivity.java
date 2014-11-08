package com.example.untitled1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


public class MainActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button pButton = (Button) findViewById(R.id.people);
        pButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, People.class);
                startActivity(intent);
            }
        });
        final Button aButton = (Button) findViewById(R.id.animal);
        aButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, Animal.class);
                startActivity(intent);
            }
        });
        final Button uButton = (Button) findViewById(R.id.ufo);
        uButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, UFO.class);
                startActivity(intent);
            }
        });


    }
}
