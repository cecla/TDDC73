package com.example.cecilialagerwall.labb1;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button myButton = new Button(this);
        myButton.setText("KNAPP");

        RelativeLayout myLayout = new RelativeLayout(this);

        EditText myEditText = new EditText(this);
        myEditText.setInputType(InputType.TYPE_CLASS_TEXT);
        myEditText.setEms(10);
        RatingBar myRatingBar = new RatingBar(this);
        EditText myEditText2 = new EditText(this);
        myEditText2.setEms(10);

        myButton.setId(1);
        myEditText.setId(2);
        myRatingBar.setId(3);
        myEditText2.setId(4);

        RelativeLayout.LayoutParams buttonParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        RelativeLayout.LayoutParams textParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        RelativeLayout.LayoutParams textParams2 =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.FILL_PARENT);

        RelativeLayout.LayoutParams ratingParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        buttonParams.addRule(RelativeLayout.ALIGN_PARENT_START);
        buttonParams.addRule(RelativeLayout.ALIGN_PARENT_END);
        buttonParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);

        textParams.addRule(RelativeLayout.BELOW, myButton.getId());
        textParams.addRule(RelativeLayout.ALIGN_PARENT_START);
        textParams.addRule(RelativeLayout.ALIGN_PARENT_END);

        ratingParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        ratingParams.addRule(RelativeLayout.BELOW, myEditText.getId());

        textParams2.addRule(RelativeLayout.ALIGN_PARENT_START);
        textParams2.addRule(RelativeLayout.ALIGN_PARENT_END);
        textParams2.addRule(RelativeLayout.BELOW, myRatingBar.getId());

        myLayout.addView(myButton, buttonParams);
        myLayout.addView(myEditText, textParams);
        myLayout.addView(myRatingBar, ratingParams);
        myLayout.addView(myEditText2, textParams2);

        setContentView(myLayout);
    }
}