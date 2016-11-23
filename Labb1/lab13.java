package com.example.cecilialagerwall.labb1;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout myLayout = new RelativeLayout(this);

        TextView textQ1 = new TextView(this);
        textQ1.setText("Hur trivs du på LiU?");
        textQ1.setId(1);
        TextView textQ2 = new TextView(this);
        textQ2.setText("Läser du på LiTH?");
        textQ2.setId(2);
        TextView textQ3 = new TextView(this);
        textQ3.setText("Är detta LiUs logga?");
        textQ3.setId(3);

        CheckBox ans11 = new CheckBox(this);
        ans11.setText("Bra");
        ans11.setId(11);
        CheckBox ans12 = new CheckBox(this);
        ans12.setText("Mycket bra");
        ans12.setId(12);
        CheckBox ans13 = new CheckBox(this);
        ans13.setText("Jättebra");
        ans13.setId(13);

        CheckBox ans21 = new CheckBox(this);
        ans21.setText("Ja");
        ans21.setId(21);
        CheckBox ans22 = new CheckBox(this);
        ans22.setText("Nej");
        ans22.setId(22);

        CheckBox ans31 = new CheckBox(this);
        ans31.setText("Ja");
        ans31.setId(31);
        CheckBox ans32 = new CheckBox(this);
        ans32.setText("Nej");
        ans32.setId(32);

        ImageView image = new ImageView(this);
        image.setId(4);
        image.setImageResource(R.drawable.liulogo);

        RelativeLayout.LayoutParams q1 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams a11 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams a12 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams a13 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        RelativeLayout.LayoutParams q2 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams a21 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams a22 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        RelativeLayout.LayoutParams q3 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams a31 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams a32 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        RelativeLayout.LayoutParams imageParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        q1.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        q1.addRule(RelativeLayout.CENTER_HORIZONTAL);
        a11.addRule(RelativeLayout.BELOW, textQ1.getId());
        a11.addRule(RelativeLayout.ALIGN_PARENT_START);
        a12.addRule(RelativeLayout.ALIGN_BASELINE, ans11.getId());
        a12.addRule(RelativeLayout.ALIGN_BOTTOM, ans11.getId());
        a12.addRule(RelativeLayout.END_OF, ans11.getId());
        a13.addRule(RelativeLayout.ALIGN_BASELINE, ans12.getId());
        a13.addRule(RelativeLayout.ALIGN_BOTTOM, ans12.getId());
        a13.addRule(RelativeLayout.END_OF, ans12.getId());

        q2.addRule(RelativeLayout.BELOW, ans11.getId());
        q2.addRule(RelativeLayout.CENTER_HORIZONTAL);
        a21.addRule(RelativeLayout.BELOW, textQ2.getId());
        a21.addRule(RelativeLayout.ALIGN_PARENT_START);
        a22.addRule(RelativeLayout.ALIGN_BASELINE, ans21.getId());
        a22.addRule(RelativeLayout.ALIGN_BOTTOM, ans21.getId());
        a22.addRule(RelativeLayout.END_OF, ans21.getId());

        q3.addRule(RelativeLayout.BELOW, image.getId());
        q3.addRule(RelativeLayout.CENTER_HORIZONTAL);
        a31.addRule(RelativeLayout.BELOW, textQ3.getId());
        a31.addRule(RelativeLayout.ALIGN_PARENT_START);
        a32.addRule(RelativeLayout.ALIGN_BASELINE, ans31.getId());
        a32.addRule(RelativeLayout.ALIGN_BOTTOM, ans31.getId());
        a32.addRule(RelativeLayout.END_OF, ans31.getId());

        imageParams.addRule(RelativeLayout.BELOW, ans21.getId());
        imageParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

        myLayout.addView(textQ1, q1);
        myLayout.addView(ans11, a11);
        myLayout.addView(ans12, a12);
        myLayout.addView(ans13, a13);

        myLayout.addView(textQ2, q2);
        myLayout.addView(ans21, a21);
        myLayout.addView(ans22, a22);

        myLayout.addView(textQ3, q3);
        myLayout.addView(ans31, a31);
        myLayout.addView(ans32, a32);

        myLayout.addView(image, imageParams);

        setContentView(myLayout);
    }
}