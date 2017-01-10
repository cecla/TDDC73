package com.example.cecilialagerwall.projektet;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Creates an form item, either a default or one with arguments.
 * Arguments, insertType, hint and if the field is optinal or not.
 * Created by cecilialagerwall on 2016-12-08.
 * @author Cecilia Lagerwall
 */

public class FormItem extends EditText {
    Context context;
    int insertType;
    String hint;
    boolean optional;
    String input = "";

    // default
    public FormItem(Context context){
        super(context);
        this.context = context;
        this.insertType = InputType.TYPE_CLASS_TEXT;
        this.optional = false;
        this.hint = "Write here";
        init();
    }

    // with arguments
    public FormItem(Context context, int insertType, String hint, boolean optional){
        super(context);
        this.context = context;
        this.insertType = insertType;
        this.hint = hint;
        this.optional = optional;
        init();
    }

    // initialize the form item
    private void init(){
        setHint(hint);
        setEms(15);
        setInputType(insertType);

        addTextChangedListener((TextWatcher) changeText);
    }

    public String getInput(){
        return input;
    }

    private TextWatcher changeText = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            setBackgroundColor(Color.TRANSPARENT);
            input = s.toString();
        }
    };
}