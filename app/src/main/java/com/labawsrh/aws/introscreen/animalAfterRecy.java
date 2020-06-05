package com.labawsrh.aws.introscreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class animalAfterRecy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_activity_after_recy);

        getIncomingIntent();


    }

    private void getIncomingIntent(){


        if(getIntent().hasExtra("imageName")&& getIntent().hasExtra("imageUri")&& getIntent().hasExtra("imageSeconddesc")
        && getIntent().hasExtra("imageThirddesc")&& getIntent().hasExtra("imageFourdesc")){
            String imagename = getIntent().getStringExtra("imageName");
            String imageuri = getIntent().getStringExtra("imageUri");
            String imagesecondDesc = getIntent().getStringExtra("imageSeconddesc");
            String imagethidDesc = getIntent().getStringExtra("imageThirddesc");
            String imagefourDesc = getIntent().getStringExtra("imageFourdesc");
            setImage(imageuri,imagename,imagesecondDesc,imagethidDesc,imagefourDesc);


        }

    }

    private void setImage(String imageuri,String imagename,String imagesecondDesc,String imagethidDesc,String imagefourDesc){
        TextView imgname=findViewById(R.id.imagename);
      //  TextView imguri =findViewById(R.id.imageuri);
        TextView imageseconddesc =findViewById(R.id.imagesecond);
        TextView imagethiddesc =findViewById(R.id.thirdth);
        TextView imagefourddesc =findViewById(R.id.fourth);
        ImageView image=findViewById(R.id.imageView);
        imgname.setText(imagename);
     //   imguri.setText(imageuri);
        imageseconddesc.setText(imagesecondDesc);
        imagethiddesc.setText(imagethidDesc);
        imagefourddesc.setText(imagefourDesc);

        //image.setImageURI(Uri.parse(imageuri));
        try {

            //Glide.with(ctx).load(url).load(R.drawable.logo).into(img);


            Picasso.get().load(imageuri).into(image);


        } catch (Exception e) {
            Log.e("Utilities : Tools", "displayImageOriginalString: "+e.getMessage() );
        }

    }

}
