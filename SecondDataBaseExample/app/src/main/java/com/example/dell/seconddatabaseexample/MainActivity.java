package com.example.dell.seconddatabaseexample;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    TextView java1, php1, android1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        java1 = (TextView) findViewById(R.id.java);
        android1 = (TextView) findViewById(R.id.android);
        php1 = (TextView) findViewById(R.id.php);
        java1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent aaaa = new Intent(MainActivity.this, Java.class);
                startActivity(aaaa);
            }
        });
        android1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent bbbb = new Intent(MainActivity.this, Android.class);
                startActivity(bbbb);
                // TODO Auto-generated method stub

            }
        });
        php1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent cccc = new Intent(MainActivity.this, Php.class);
                startActivity(cccc);


            }
        });

    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

}
