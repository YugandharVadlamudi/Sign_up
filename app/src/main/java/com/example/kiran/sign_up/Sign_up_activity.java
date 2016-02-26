package com.example.kiran.sign_up;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * Created by Kiran on 30-10-2015.
 */
public class Sign_up_activity extends Activity {
    EditText Email;
    EditText Re_Email;
    EditText First_name;
//    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_main);
        Spinner sp_date = (Spinner) findViewById(R.id.Sp_Day);
        Re_Email = (EditText) findViewById(R.id.Ed_Re_Email);
        ArrayAdapter<CharSequence> AAdaptor_day = ArrayAdapter.createFromResource(this,
                R.array.day, android.R.layout.simple_spinner_item);
        AAdaptor_day.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_date.setAdapter(AAdaptor_day);
        Spinner sp_Mont = (Spinner) findViewById(R.id.Sp_Mont);
        ArrayAdapter<CharSequence> AAdaptor_Mont = ArrayAdapter.createFromResource(this,
                R.array.Month, android.R.layout.simple_spinner_item);
        AAdaptor_Mont.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_Mont.setAdapter(AAdaptor_Mont);

        Spinner sp_year = (Spinner) findViewById(R.id.Sp_year);
        ArrayAdapter<CharSequence> AAdaptor_year = ArrayAdapter.createFromResource(this,
                R.array.year, android.R.layout.simple_spinner_item);
        AAdaptor_year.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_year.setAdapter(AAdaptor_year);
//        Debug.out("hello wo");
//        Log.d("ADebugTag", "Value:Hello windw ");
        Email = (EditText) findViewById(R.id.Ed_Email);
        Email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Re_Email.setText(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public void Validate_Edit_Text(View Edit_) {
        Log.d("the Edit_is", Edit_.toString());
        EditText ed_first_name = (EditText) findViewById(R.id.Ed_First_name);
        EditText ed_sur_name = (EditText) findViewById(R.id.Ed_Surname);
        EditText ed_email = (EditText) findViewById(R.id.Ed_Email);
        EditText ed_Re_email = (EditText) findViewById(R.id.Ed_Re_Email);
        EditText ed_Password = (EditText) findViewById(R.id.Ed_Password);
        TextView login = (TextView) findViewById(R.id.second_tv2);
//        email validation
        final String email = ed_email.getText().toString().trim();
//        Regular expression [a-zA-Z0-9._-]+@[a-z].+[a-z]
        final String email_pattern_REGX = "[a-zA-Z0-9._-]+@[a-z].+[a-z]";
        if (!email.matches(email_pattern_REGX) && email.length() > 0) {
            Toast.makeText(getApplicationContext(), "not valid email", Toast.LENGTH_LONG).show();
        } else if (ed_email.length() == 0 || ed_first_name.length() == 0 || ed_Password.length() == 0 || ed_sur_name.length() == 0 || ed_Re_email.length() == 0) {
//            AlertDialog.Builder builder_alert=new AlertDialog.Builder(this);
//            builder_alert.setTitle("hello alert");//alert dialog title
//            builder_alert.setMessage("you missed somethings in the fields fill all the fields");//alert message
//            builder_alert.show();//default it is not displayed
            Toast.makeText(getApplicationContext(), "Fill all the fields which are specifyed", Toast.LENGTH_LONG).show();
        }
        else {
            Intent intent = new Intent(getApplicationContext(), Second_activity.class);
            String message = ed_first_name.getText().toString();
            intent.putExtra("secound_activity_message", message);
            startActivity(intent);
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        }//else
    }
}
