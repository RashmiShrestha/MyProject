package com.example.welcome.jobpost;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class CompanyLogedInPage extends AppCompatActivity {

    ImageView imgV;
    GridView gV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_loged_in_page);
        //initalzing the component
        imgV=(ImageView)findViewById(R.id.imgcl);
        gV=(GridView)findViewById(R.id.gvCL);

        //populating the gridview with data
        gV.setAdapter(new MyCompanyGridAdapter(this));

        //Setting item click if GridView
        gV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(), "Item Clicked", Toast.LENGTH_SHORT).show();

                if (position==0){
                    Intent in=new Intent(getApplicationContext(),CompanyProfilePage.class);
                    startActivity(in);
                }
                else if(position==1){
                    Intent in=new Intent(getApplicationContext(),CompanyJobs.class);
                    startActivity(in);
                }
                else {
                    Intent in=new Intent(getApplicationContext(),SelectedCandidates.class);
                    startActivity(in);
                }


            }
        });
    }
}

