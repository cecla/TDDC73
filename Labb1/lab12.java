package com.example.cecilialagerwall.labb1;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout myLayout = new RelativeLayout(this);

        //TEXTVIEW, left column
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

        //EDITTEXT, right column
        EditText name = new EditText(this);
        name.setId(6);
        name.setEms(13);
        name.setInputType(InputType.TYPE_CLASS_TEXT);
        EditText password = new EditText(this);
        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        password.setId(7);
        password.setEms(13);
        EditText epost = new EditText(this);
        epost.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        epost.setId(8);
        epost.setEms(13);
        SeekBar age = new SeekBar(this);

        //TABLE
        TableLayout table = new TableLayout(this);
        TableRow t1 = new TableRow(this);
        TableRow t2 = new TableRow(this);
        TableRow t3 = new TableRow(this);
        TableRow t4 = new TableRow(this);

        t1.addView(textName);
        t1.addView(name);

        t2.addView(textPassword);
        t2.addView(password);

        t3.addView(textEpost);
        t3.addView(epost);

        t4.addView(textAge);
        t4.addView(age);

        table.addView(t1);
        table.addView(t2);
        table.addView(t3);
        table.addView(t4);

        myLayout.addView(table);

        setContentView(myLayout);
    }
}