package com.example.cecilialagerwall.projektet;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

/**
 * Creates a form containing name, username, email, gender, optional password field and submit button.
 * Created by cecilialagerwall on 2016-12-08.
 * @author Cecilia Lagerwall
 */

public class TheForm extends LinearLayout {
    Context context;
    ArrayList<FormItem> noOptional = new ArrayList<>();
    PasswordItem passwordItem;
    CreatePasswordBar bar;
    Button submit;
    PasswordEvaluator passwordEvaluator;
    boolean passwordForm;

    /**Default constructor without password field*/
    public TheForm(Context context){
        super(context);
        this.context = context;
        this.passwordForm = false;
        init();
    }

    /**Own password evaluator*/
    public TheForm(Context context, PasswordEvaluator passwordEvaluator){
        super(context);
        this.context = context;
        this.passwordEvaluator = passwordEvaluator;
        this.passwordForm = true;
        init();
    }

    /**Create password item with default password evaluator*/
    public TheForm(Context context, boolean passwordForm){
        super(context);
        this.context = context;
        this.passwordForm = passwordForm;
        passwordEvaluator = new PasswordEvaluator();
        init();
    }

    /**Initialize the form*/
    private void init(){
        setOrientation(LinearLayout.VERTICAL);

        //name
        final FormItem nameItem = new FormItem(context, InputType.TYPE_CLASS_TEXT, "Name*", false);
        noOptional.add(nameItem);
        this.addView(nameItem);

        //username
        final FormItem uNameItem = new FormItem(context, InputType.TYPE_CLASS_TEXT, "User name*", false);
        noOptional.add(uNameItem);
        this.addView(uNameItem);

        //email
        final FormItem mailItem = new FormItem(context, InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS, "Email", true);
        this.addView(mailItem);

        //gender, radiobuttons
        RadioGroup radioGroup = new RadioGroup(context);
        radioGroup.setOrientation(LinearLayout.HORIZONTAL);

        RadioButton male = new RadioButton(context);
        male.setText("Male");
        RadioButton female = new RadioButton(context);
        female.setText("Female");
        RadioButton other = new RadioButton(context);
        other.setText("Other");

        radioGroup.addView(male);
        radioGroup.addView(female);
        radioGroup.addView(other);

        this.addView(radioGroup);

        if(passwordForm){
            createPasswordItem();
        }

        //submit button
        submit = new Button(context);
        submit.setText("SUBMIT");
        this.addView(submit);

        //check all non optional items are field
        submit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < noOptional.size(); i++){
                    if(noOptional.get(i).getInput().length() == 0){
                        Log.d("no insert", "color RED");
                        noOptional.get(i).setBackgroundColor(Color.RED);
                    }
                }
            }
        });
    }

    /**Create password field and bar.*/
    private void createPasswordItem(){
        //password, special
        passwordItem = new PasswordItem(context, "Password");
        this.addView(passwordItem);

        passwordItem.addTextChangedListener((TextWatcher) changeText);

        //password bar
        bar = new CreatePasswordBar(context);
        this.addView(bar);
    }

    /**TextWatcher on password field. Check strength and update bar.*/
    private TextWatcher changeText = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            passwordEvaluator.checkStrength(s.toString());

            bar.setColor(passwordEvaluator.getStrength());
        }
    };
}
