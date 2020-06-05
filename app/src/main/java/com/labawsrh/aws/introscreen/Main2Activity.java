package com.labawsrh.aws.introscreen;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.view.MenuItem;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;

import com.labawsrh.aws.introscreen.ui.gallery.GalleryFragment;
import com.labawsrh.aws.introscreen.ui.home.HomeFragment;
import com.labawsrh.aws.introscreen.ui.slideshow.SlideshowFragment;

public class Main2Activity extends AppCompatActivity
implements NavigationView.OnNavigationItemSelectedListener{


    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        navigationView.setNavigationItemSelectedListener(this);
        View navheader=navigationView.getHeaderView(0);

        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

     navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
         @Override
         public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
             if (destination.getId() == R.id.nav_gallery) {
                 onBackPressed();
               /*  Fragment frag =new GalleryFragment();
                 getSupportFragmentManager().beginTransaction().addToBackStack(null)
                                 .replace(R.id.mainlayout,frag).commit();*/
                 Intent intentregister1 = new Intent(getApplicationContext(), GridLayout.class);
                 startActivity(intentregister1);

             } else if (destination.getId() == R.id.nav_slideshow) {
                 onBackPressed();
                 Intent intentregister = new Intent(getApplicationContext(), userMainActivity.class);
                 startActivity(intentregister);

             } else if (destination.getId() == R.id.nav_tools) {
                onBackPressed();
                 Intent intentregister = new Intent(getApplicationContext(), MapsActivity.class);
                 startActivity(intentregister);

             }
             else if(destination.getId() == R.id.nav_home) {

                 Intent intentregister = new Intent(getApplicationContext(), home.class);
                 startActivity(intentregister);

             }else if(destination.getId() == R.id.nav_share) {

                 Intent intentregister = new Intent(getApplicationContext(), eventViewImageActivity.class);
                 startActivity(intentregister);

             }


         }
     });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public boolean onOptionItemSelected(MenuItem menuItem){
        int id =menuItem.getItemId();
        if (id==R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(menuItem);

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {




        return true;
    }
}
