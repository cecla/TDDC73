package com.example.cecilialagerwall.projektet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

/**
 * Activity to load different layouts
 * @author Cecilia Lagerwall
 */
public class MainActivity extends AppCompatActivity {

    RelativeLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        layout = new RelativeLayout(this);

        setContentView(layout);

        //create form with password item
        TheForm theForm = new TheForm(this, true);
        layout.addView(theForm);
    }
}
