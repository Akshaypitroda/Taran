package com.labawsrh.aws.introscreen;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class volunteer extends AppCompatActivity {
EditText name,add,mob,email;
Button send;
Firebase firebase;
    final int SEND_SMS_PERMISSION_REQUEST_CODE =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);




        // hide the action bar

        getSupportActionBar().hide();
        setContentView(R.layout.volunteer);
name=(EditText)findViewById(R.id.nameedt);
        add=(EditText)findViewById(R.id.addedt);
        mob=findViewById(R.id.mobileedt);
        email=(EditText)findViewById(R.id.emailedt);
send=(Button)findViewById(R.id.sendbut);
send.setEnabled(false);
        Firebase.setAndroidContext(getApplicationContext());


        if(checkPermission(Manifest.permission.SEND_SMS)){
            send.setEnabled(true);

        }
        else {
            ActivityCompat.requestPermissions(volunteer.this,
                    new String[]{Manifest.permission.SEND_SMS}, SEND_SMS_PERMISSION_REQUEST_CODE);

        }
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=name.getText().toString();
                String useradd=add.getText().toString();
                String usermob=mob.getText().toString();
                String useremail=email.getText().toString();
                User user = new User();
                user.setName(username);
                user.setAdd(useradd);
                user.setMobile(usermob);
                user.setEmail(useremail);
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference reference=firebaseDatabase.getReference().child("person");
                reference.push().setValue(user);
              //    firebase=new Firebase(Config.url);
               // firebase.child("persons").setValue(user);



                String mombile=mob.getText().toString();
                String NAME=name.getText().toString();
                if(!TextUtils.isEmpty(mombile)&&!TextUtils.isEmpty(NAME))
                {
                    if(checkPermission(Manifest.permission.SEND_SMS)){
                        SmsManager smsManager=SmsManager.getDefault();
                        smsManager.sendTextMessage(mombile,null,NAME + "Thank you for Registration",null,null);
                        Toast.makeText(volunteer.this, "Register successfully", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(volunteer.this, "permission denied", Toast.LENGTH_SHORT).show();
                    }

                }
                else
                {
                    Toast.makeText(volunteer.this, "Permission Denied", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private boolean checkPermission(String sendSms) {
        int checkpermission= ContextCompat.checkSelfPermission(this,sendSms);
        return checkpermission==PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case SEND_SMS_PERMISSION_REQUEST_CODE:
                if(grantResults.length>0&&(grantResults[0]==PackageManager.PERMISSION_GRANTED)){
                    send.setEnabled(true);
                }
                break;
        }
    }


}
