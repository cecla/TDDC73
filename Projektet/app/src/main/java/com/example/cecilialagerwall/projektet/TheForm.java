package com.example.cecilialagerwall.projektet;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Creates a form containing name, username, email, gender, optional password field and submit button.
 * Created by cecilialagerwall on 2016-12-08.
 * @author Cecilia Lagerwall
 */

public class TheForm extends LinearLayout {
    Context context;
    ArrayList<FormItem> itemList = new ArrayList<>();

    PasswordItem passwordItem;
    CreatePasswordBar bar;
    PasswordEvaluator passwordEvaluator;
    boolean passwordForm;
    private String password = "";

    Button submit;

    SaveFormValues saveValues;
    HashMap<Integer, String> formValues = new HashMap<Integer, String>();

    RadioGroup radioGroup;
    RadioButton male, female, other;

    int id = 0;

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

    /**Insert an new form item*/
    public void addItem(FormItem formItem){
        itemList.add(formItem); //insert new FormItem to the list
        this.addView(formItem);
    }

    /**Initialize the form*/
    private void init(){
        setOrientation(LinearLayout.VERTICAL);
        //name
        final FormItem nameItem = new FormItem(context, InputType.TYPE_CLASS_TEXT, "Name", false);
        nameItem.setId(id++);
        itemList.add(nameItem);
        this.addView(nameItem);

        //username
        final FormItem uNameItem = new FormItem(context, InputType.TYPE_CLASS_TEXT, "User name", false);
        uNameItem.setId(id++);
        itemList.add(uNameItem);
        this.addView(uNameItem);

        //email
        final FormItem mailItem = new FormItem(context, InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS, "Email", true);
        mailItem.setId(id++);
        itemList.add(mailItem);
        this.addView(mailItem);

        //gender, radiobuttons
        radioGroup = new RadioGroup(context);
        radioGroup.setOrientation(LinearLayout.HORIZONTAL);

        male = new RadioButton(context);
        male.setText("Male");
        male.setId(id++);
        female = new RadioButton(context);
        female.setText("Female");
        female.setId(id++);
        other = new RadioButton(context);
        other.setText("Other");
        other.setId(id++);

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
    }

    /**Create password field and bar.*/
    private void createPasswordItem(){
        //password, special
        passwordItem = new PasswordItem(context, "Password");
        passwordItem.setId(id++);
        this.addView(passwordItem);

        passwordItem.addTextChangedListener((TextWatcher) changeText);

        //password bar
        bar = new CreatePasswordBar(context);
        this.addView(bar);
    }

    /**Submit form. Check for non-optional fields to be field in. Update values to MainActivity*/
    public void setOnSubmitClick(SaveFormValues save){
        this.saveValues = save;

        submit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean formCheck = true;

                for(int i = 0; i < itemList.size(); i++){
                    if(!itemList.get(i).optional && itemList.get(i).getInput().length() == 0){
                        itemList.get(i).setBackgroundColor(Color.RED);
                        formCheck = false; //Don't update form
                    }
                }

                updateValue();

                if(formCheck){
                    saveValues.onSubmitClick(formValues);
                }
            }
        });
    }

    /**Update form values to be returned*/
    public void updateValue(){
        formValues.clear();
        for(int i = 0; i < itemList.size(); i++){
            formValues.put(itemList.get(i).getId(), itemList.get(i).getInput());
        }

        if(radioGroup.getCheckedRadioButtonId() == male.getId()) formValues.put(male.getId(), "male");
        if(radioGroup.getCheckedRadioButtonId() == female.getId()) formValues.put(female.getId(), "female");
        if(radioGroup.getCheckedRadioButtonId() == other.getId()) formValues.put(other.getId(), "other");

        if(passwordForm){
            formValues.put(passwordItem.getId(), password);
        }
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
            password = s.toString();

            bar.setColor(passwordEvaluator.getStrength());
        }
    };
}