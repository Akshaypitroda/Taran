package com.labawsrh.aws.introscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class firstpage extends AppCompatActivity {
    Button b1 ,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // make the activity on full screen

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);
        // hide the action bar

        getSupportActionBar().hide();

        setContentView(R.layout.activity_firstpage);

        b1 = findViewById(R.id.new1);
        b2 =findViewById(R.id.log1);
        b3 =findViewById(R.id.ad1);
    }

    public void news(View view)
    {
        Intent intent = new Intent(firstpage.this,MobileNoActitvity.class);
        startActivity(intent);
    }
    public void logins(View view)
    {
        Intent intent = new Intent(firstpage.this,LoginActivity.class);
        startActivity(intent);
    }
    public void Admins(View view)
    {
        Intent intent = new Intent(firstpage.this,AdminRegister.class);
        startActivity(intent);
    }

}
