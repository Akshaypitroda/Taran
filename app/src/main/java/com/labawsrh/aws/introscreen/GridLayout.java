package com.labawsrh.aws.introscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class GridLayout extends AppCompatActivity {

    android.widget.GridLayout gridLayout;
    TextView i1,i2,i3,i4,i5;
    ImageView I1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // make the activity on full screen

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        // hide the action bar

        getSupportActionBar().hide();

        setContentView(R.layout.activity_gridlayout);
        gridLayout=(android.widget.GridLayout)findViewById(R.id.grid);
        i1=findViewById(R.id.t1);
        i2=findViewById(R.id.t2);
        i3=findViewById(R.id.t3);
        i4=findViewById(R.id.t4);
        i5=findViewById(R.id.t5);
        I1=findViewById(R.id.I1);
        
      //  singleEvent(gridLayout);
       // setToggleEvent(gridLayout);
    }
    public void education(View view)
    {

        Intent intent=new Intent(GridLayout.this,educationViewImageActivity.class);
        startActivity(intent);
    }
    public void volunteers(View view)
    {
        Intent intent=new Intent(GridLayout.this,volunteer.class);
        startActivity(intent);
    }public void animal(View view)
    {
        Intent intent=new Intent(GridLayout.this,animalViewImageActivity.class);
        startActivity(intent);
    }public void enivor(View view)
    {
        Intent intent=new Intent(GridLayout.this,enivorViewImageActivity.class);
        startActivity(intent);
    }public void women(View view)
    {
        Intent intent=new Intent(GridLayout.this,womanViewImageActivity.class);
        startActivity(intent);
    }
public void health(View view)
    {
        Intent intent=new Intent(GridLayout.this,healthViewImageActivity.class);
        startActivity(intent);
    }


/*
    private void setToggleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Toast.makeText(GridLayout.this, "State : True", Toast.LENGTH_SHORT).show();

                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(GridLayout.this, "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
*/

  /*  private void singleEvent(GridLayout gridLayout) {
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) gridLayout.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(GridLayout.this,"click at index "+finalI,Toast.LENGTH_LONG).show();


                }
            });
        }
    }*/

}
