
package com.example.welcome.jobpost;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class
JobSeeker extends AppCompatActivity {//yasko layoutvaneko jobseeker_profilepage
    TextView jpfirstname,jplastname,jpdob,jpgender,jpnationality,jpphoneNum,jpaddress,jpfunctionalArea,
    jpeducationalDetail,jpexpectedSalary,jppreviousExp,jpskillLable,jpsummary;
     private ArrayList<JobseekerProductionModule> list2 =new ArrayList<>();
        JobseekerDatabaseHelper dbhelper;
        JobseekerProductionModule pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jobseeker_profilepage);
        jpfirstname = (TextView) findViewById(R.id.txt_jpFirstName);
        jplastname = (TextView) findViewById(R.id.txt_jplastName);
        jpdob = (TextView) findViewById(R.id.txt_jpDOB);
        jpgender = (TextView) findViewById(R.id.txt_jpGender);
        jpnationality = (TextView) findViewById(R.id.txt_jpNationnality);
        jpphoneNum = (TextView) findViewById(R.id.txt_jpPhonN);
        jpaddress = (TextView) findViewById(R.id.txt_jpAdress);
        jpfunctionalArea = (TextView) findViewById(R.id.txt_jpFuctionalA);
        jpeducationalDetail = (TextView) findViewById(R.id.txt_jpEducationD);
        jpexpectedSalary = (TextView) findViewById(R.id.txt_jpExpectedS);
        jppreviousExp = (TextView) findViewById(R.id.txt_jpPreviousE);
        jpskillLable = (TextView) findViewById(R.id.txt_jpSkillL);
        jpsummary = (TextView) findViewById(R.id.txt_jpSummary);


        dbhelper = new JobseekerDatabaseHelper(getApplicationContext());
        dbhelper.getWritableDatabase();
        pd = new JobseekerProductionModule();
        ArrayList<JobseekerProductionModule> mylist = dbhelper.getProductsphp();
        list2.clear();
        for (int i = 0; i < mylist.size(); i++) {

            String n1 = mylist.get(i).getpFirstName();
            pd.setpFirstName(n1);

            String n2 = mylist.get(i).getpLastName();
           // pd.setpFirstName(n1);  first name last nameko same huncha id=f setfirstname ma ni pathayo vane
            pd.setpLastName(n2);


            String n3= mylist.get(i).getpDOB();
            pd.setpDOB(n3);


            String n4 = mylist.get(i).getpMobilenumber();
            pd.setpMobilenumber(n4);

            String n5 = mylist.get(i).getpCurrentAddress();
            pd.setpCurrentAddress(n5);

            String n6 = mylist.get(i).getpNationalitySpinner();
            pd.setpNationalitySpinner(n6);
            String n7 = mylist.get(i).getpFunctonalAreaSpinner();
            pd.setpFunctonalAreaSpinner(n7);
            String n8 = mylist.get(i).getpSalarySpinner();
            pd.setpSalarySpinner(n8);
            String n9 = mylist.get(i).getpGenderRadioB();
            pd.setpGenderRadioB(n9);





            list2.add(pd);

            jpfirstname.setText(list2.get(i).getpFirstName());
            jplastname.setText(list2.get(i).getpLastName());
            jpdob.setText(list2.get(i).getpDOB());
            jpphoneNum.setText(list2.get(i).getpMobilenumber());
            jpaddress.setText(list2.get(i).getpCurrentAddress());
            jpnationality.setText(list2.get(i).getpNationalitySpinner());
            jpfunctionalArea.setText(list2.get(i).getpFunctonalAreaSpinner());
            jpexpectedSalary.setText(list2.get(i).getpSalarySpinner());
            jpgender.setText(list2.get(i).getpGenderRadioB());
            //spinner halyo vane setprompt



        }

        dbhelper.close();
    }
}