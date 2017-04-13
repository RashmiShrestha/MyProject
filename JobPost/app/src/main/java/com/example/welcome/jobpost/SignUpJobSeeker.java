package com.example.welcome.jobpost;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class SignUpJobSeeker extends AppCompatActivity implements View.OnClickListener{
    Button jsignup;
    JobseekerDatabaseHelper  jdatab;
    JobseekerProductionModule jpd;
  // String[] list;

    //referencing the components
    EditText firstname,lastname,address,mobile,dob,email,username,password;
    Spinner nationality,fuctionalarea,salary;
    RadioButton rbutton;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //initilazing components // chinako
        setContentView(R.layout.activity_sign_up_job_seeker);
         jsignup = (Button)findViewById(R.id.btnJsignUp);
        jsignup.setOnClickListener(this);
        firstname = (EditText)findViewById(R.id.ed_JFname);
        lastname = (EditText)findViewById(R.id.ed_JLname);
        address = (EditText)findViewById(R.id.ed_JcAddress);
        mobile = (EditText)findViewById(R.id.ed_Jmob);
        dob = (EditText)findViewById(R.id.ed_JDob);
        email = (EditText)findViewById(R.id.ed_Jemail);
        username = (EditText)findViewById(R.id.ed_Jusername);
        password= (EditText)findViewById(R.id.ed_JPassword);
        nationality = (Spinner) findViewById(R.id.nationalitySpiner);
        fuctionalarea = (Spinner) findViewById(R.id.funcationSpinner);
        salary = (Spinner) findViewById(R.id.salarySpinner);
        rg=(RadioGroup)findViewById(R.id.genderRadioB);

    }

    @Override
    public void onClick(View v) {
        //get data base reference
        jdatab = new JobseekerDatabaseHelper(getApplicationContext());
        jdatab.getWritableDatabase();
        jpd= new JobseekerProductionModule();

        jpd.pFirstName = (firstname.getText().toString());
        jpd.pLastName = (lastname.getText().toString());
        jpd.pCurrentAddress = (address.getText().toString());
        jpd.pMobilenumber = (mobile.getText().toString());
        jpd.pDOB = (dob.getText().toString());
        jpd.pEmail = (email.getText().toString());
        jpd.pUserName = (username.getText().toString());
        jpd.pPassword = (password.getText().toString());
        jpd.pNationalitySpinner=(nationality.getSelectedItem().toString());
        jpd.pFunctonalAreaSpinner=(fuctionalarea.getSelectedItem().toString());
        jpd.pSalarySpinner=(salary.getSelectedItem().toString());

        // get selected radio button from radioGroup
        // find the radiobutton by returned id
        rbutton = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
        jpd.pGenderRadioB=rbutton.getText().toString();



        jdatab.insertSignUpData(jpd);

     Intent in=new Intent(getApplicationContext(),JobLogedInPage.class);
     startActivity(in);

        Toast.makeText(this, "Data Add Sucess", Toast.LENGTH_SHORT).show();

        jdatab.close();
        finish();




    }
}
