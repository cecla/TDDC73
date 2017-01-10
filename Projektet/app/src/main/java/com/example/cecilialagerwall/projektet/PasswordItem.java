package com.example.cecilialagerwall.projektet;

import android.content.Context;
import android.text.InputType;
import android.widget.EditText;

/**
 * Create a password item. Default or pass a value for the hint.
 * Created by cecilialagerwall on 2016-12-16.
 */

public class PasswordItem extends EditText {
    Context context;
    String hint;

    public PasswordItem(Context context){
        super(context);
        this.context = context;
        this.hint = "Password...";
        init();
    }

    public PasswordItem(Context context, String hint){
        super(context);
        this.context = context;
        this.hint = hint;
        init();
    }

    private void init(){
        setEms(15);
        setHint(hint);
        setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }
}
