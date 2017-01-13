package com.example.cecilialagerwall.labb3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.RelativeLayout;

/**
 * Main activity, creates text edit field for input of max nr of names to display and
 * a text field for writing names which pops up after nr has been set
 * */
public class MainActivity extends AppCompatActivity {
    RelativeLayout layout;
    EditText editText;
    InteractiveSearcher interactiveSearcher;
    boolean alreadySet = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        layout = new RelativeLayout(this);
        setContentView(layout);

        editText = new EditText(this);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        editText.setHint("Nr of items to show");
        editText.setId(1);

        layout.addView(editText);

        editText.addTextChangedListener((TextWatcher) changedText);

    }

    //max number of names to display
    private  void changeNR(int nrOfItems){
        if(alreadySet){
            layout.removeView(interactiveSearcher);
        }

        //create the field for input of names
        interactiveSearcher = new InteractiveSearcher(this, nrOfItems);

        RelativeLayout.LayoutParams searchParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        searchParams.addRule(RelativeLayout.BELOW, editText.getId());
        layout.addView(interactiveSearcher, searchParams);
    }

    private TextWatcher changedText = new TextWatcher() {

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        public void afterTextChanged(Editable s) {
            if(s.length() > 0){
                int nr = Integer.valueOf(s.toString());
                //Log.d("här", "här är jag" + nr);
                changeNR(nr);
                alreadySet = true;
            }

        }
    };
}