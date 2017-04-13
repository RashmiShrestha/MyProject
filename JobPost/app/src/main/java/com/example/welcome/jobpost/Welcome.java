package com.example.welcome.jobpost;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Welcome extends AppCompatActivity implements View.OnClickListener {
    Button btn_jobseeker,btn_employer,btn_jobseekerSignup,btn_employerSignup;
    EditText username,passWord;

    //DAtabase Reference
    JobseekerDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //Splash screen pachi ko activities...Main Activity
         btn_jobseeker =  (Button)findViewById(R.id.btn_jobseeker);
         btn_employer =  (Button)findViewById(R.id.btn_employer);
        btn_jobseekerSignup =  (Button)findViewById(R.id.btn_jobseekerSignup);
        btn_employerSignup =  (Button)findViewById(R.id.btn_employerSignup);
        username=(EditText)findViewById(R.id.ed_us);
        passWord=(EditText)findViewById(R.id.ed_pw);
        //Initialzing the button on click
        btn_jobseekerSignup.setOnClickListener(this);
        btn_employerSignup.setOnClickListener(this);
        btn_jobseeker.setOnClickListener(this);
        btn_employer.setOnClickListener(this);

        db=new JobseekerDatabaseHelper(this);
        db.getWritableDatabase();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_jobseekerSignup:
                Intent i1 =new Intent(Welcome.this,SignUpJobSeeker.class);
                startActivity(i1);
                break;
            case R.id.btn_employerSignup:
                Intent i2 =new Intent(Welcome.this,SignUpCompany.class);
                startActivity(i2);
                break;
            case R.id.btn_employer:
            Intent i3 =new Intent(Welcome.this,CompanyLogedInPage.class);
            startActivity(i3);
            break;
            case R.id.btn_jobseeker:
                // get The User name and Password
                String userName=username.getText().toString();
                String password=passWord.getText().toString();

                // fetch the Password form database for respective user name
                String storedPassword=db.getSinlgeEntry(userName);

                // check if the Stored password matches with  Password entered by user
                if(password.equals(storedPassword))
                {
                    Toast.makeText(getApplicationContext(), "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
                    Intent in=new Intent(getApplicationContext(),JobSeeker.class);
                    startActivity(in);

                }
                else
                {
                    Toast.makeText(getApplicationContext(), "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }
                break;

    }

    }
}

