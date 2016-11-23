package com.example.cecilialagerwall.labb1;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout myLayout = new RelativeLayout(this);

        TextView textName = new TextView(this);
        textName.setText("Namn");
        textName.setEms(5);
        textName.setId(1);
        TextView textPassword = new TextView(this);
        textPassword.setText("Lösenord");
        textPassword.setEms(5);
        textPassword.setId(2);
        TextView textEpost = new TextView(this);
        textEpost.setText("Epost");
        textEpost.setEms(5);
        textEpost.setId(3);
        TextView textAge = new TextView(this);
        textAge.setText("Ålder");
        textAge.setEms(5);
        textAge.setId(4);

        EditText name = new EditText(this);
        name.setId(6);
        name.setEms(13);
        EditText password = new EditText(this);
        password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        password.setId(7);
        password.setEms(13);
        EditText epost = new EditText(this);
        epost.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        epost.setId(8);
        epost.setEms(13);
        SeekBar age = new SeekBar(this);

        RelativeLayout.LayoutParams nameP = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams passP = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams epostP = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams ageP = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        nameP.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        nameP.addRule(RelativeLayout.ALIGN_PARENT_START);
        nameP.setMargins(0,50,0,0);

        passP.addRule(RelativeLayout.BELOW, textName.getId());
        passP.setMargins(0,80,0,0);

        epostP.addRule(RelativeLayout.BELOW, textPassword.getId());
        epostP.setMargins(0,100,0,0);

        ageP.addRule(RelativeLayout.BELOW, textEpost.getId());
        ageP.setMargins(0,120,0,0);

        myLayout.addView(textName, nameP);
        myLayout.addView(textPassword, passP);
        myLayout.addView(textEpost, epostP);
        myLayout.addView(textAge, ageP);

        RelativeLayout.LayoutParams np = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams pp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams ep = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams ap = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        np.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        np.addRule(RelativeLayout.ALIGN_PARENT_END);

        pp.addRule(RelativeLayout.BELOW, name.getId());
        pp.addRule(RelativeLayout.ALIGN_PARENT_END);

        ep.addRule(RelativeLayout.BELOW, password.getId());
        ep.addRule(RelativeLayout.ALIGN_PARENT_END);

        ap.addRule(RelativeLayout.ALIGN_BOTTOM, textAge.getId());
        ap.addRule(RelativeLayout.ALIGN_PARENT_END);
        ap.addRule(RelativeLayout.RIGHT_OF, textAge.getId());

        myLayout.addView(name, np);
        myLayout.addView(password, pp);
        myLayout.addView(epost, ep);
        myLayout.addView(age, ap);

        setContentView(myLayout);
    }
}