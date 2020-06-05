package com.labawsrh.aws.introscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class category extends AppCompatActivity {

  TextView i1,i2,i3,i4,i5,i6;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);



        setContentView(R.layout.category);
        // hide the action bar

        getSupportActionBar().hide();
        init3();

    }
    public void init3()
    {
        i1=findViewById(R.id.im1);
        i2=findViewById(R.id.im2);
        i3=findViewById(R.id.im3);
        i4=findViewById(R.id.im4);
        i5=findViewById(R.id.im5);
        i6=findViewById(R.id.im6);

    }

    public void education(View view)
    {
        Intent intent=new Intent(category.this,educationMainActivity.class);
        startActivity(intent);
    }
    public void animal(View view)
    {
        Intent intent=new Intent(category.this,animalMainActivity.class);
        startActivity(intent);
    }
    public void dieses(View view)
    {
        Intent intent=new Intent(category.this,enivorMainActivity.class);
        startActivity(intent);
    }
    public void women(View view)
    {
        Intent intent=new Intent(category.this,womanMainActivity.class);
        startActivity(intent);
    }
    public void health(View view)
    {
        Intent intent=new Intent(category.this,healthMainActivity.class);
        startActivity(intent);
    } public void event(View view)
    {
        Intent intent=new Intent(category.this,eventMainActivity.class);
        startActivity(intent);
    }

}
