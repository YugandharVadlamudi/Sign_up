package com.example.kiran.sign_up;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Kiran on 04-11-2015.
 */
public class Second_activity extends Activity
{
    Intent intent_receive_from_firtActivity;
    EditText User_name;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String message = intent.getStringExtra("secound_activity_message");
        Log.d("message passing", message);
        EditText username=(EditText)findViewById(R.id.Ed_User_name2);
         username.setText(message);

    }

}

