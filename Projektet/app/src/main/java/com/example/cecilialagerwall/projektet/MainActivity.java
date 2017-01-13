package com.example.cecilialagerwall.projektet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import java.util.HashMap;

/**
 * Activity to load different layouts
 * @author Cecilia Lagerwall
 */
public class MainActivity extends AppCompatActivity {

    RelativeLayout layout;
    HashMap<Integer, String> formValues = new HashMap<Integer, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        layout = new RelativeLayout(this);

        setContentView(layout);

        //create form with password item
        TheForm theForm = new TheForm(this, true);

        layout.addView(theForm);

        //get back a HashMap, key=id of the item and String = value
        theForm.setOnSubmitClick(new SaveFormValues() {
            @Override
            public void onSubmitClick(HashMap<Integer, String> values) {
                formValues.clear();
                formValues.putAll(values);
            }
        });
    }
}
