package com.example.welcome.jobpost;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class JobLogedInPage extends AppCompatActivity {
    ImageView imgV;
    GridView gV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_loged_in_page);
        //initalzing the component
        imgV=(ImageView)findViewById(R.id.imgjl);
        gV=(GridView)findViewById(R.id.gvJL);

        //populating the gridview with data
        gV.setAdapter(new MyGridAdapter(this));

        //Setting item click if GridView
        gV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(), "Item Clicked", Toast.LENGTH_SHORT).show();

            if (position==0){
                Intent in=new Intent(getApplicationContext(),JobSeeker.class);
                startActivity(in);
            }
            else if(position==1){
                Intent in=new Intent(getApplicationContext(),Education.class);
                startActivity(in);
            }
            else if(position==2){
                Intent in=new Intent(getApplicationContext(),Experince.class);
                startActivity(in);
            }
            else if(position==3){
                Intent in=new Intent(getApplicationContext(),CV.class);
                startActivity(in);
            }
            else {
                Intent in=new Intent(getApplicationContext(),Jobs.class);
                startActivity(in);
            }
            }
        });
    }
}
