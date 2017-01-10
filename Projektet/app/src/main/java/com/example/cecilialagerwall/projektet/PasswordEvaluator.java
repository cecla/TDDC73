package com.example.cecilialagerwall.projektet;

import android.util.Log;

/**
 * Evaluate how strong the password is. Return the strength in percentage of max value.
 * Created by cecilialagerwall on 2016-12-17.
 * @author cecilialagerwall
 */

public class PasswordEvaluator {
    double strength;
    int max;

    /**Constructor checks a given password and set the strength with 4 steps of strength*/
    public PasswordEvaluator(){
        this.max = 4;
    }

    /**Default constructor, no password stength check*/
    public PasswordEvaluator(int max){
        this.max = max;
    }

    /**Check if the string contains special char, lenght > 5, numbers and uppercase. Set strength based on max value.
     * Max count value = 4
     * */
    public void checkStrength(String password){
        int count = 0;

        if(password.length() == 0){
            setStrength(count);
            return;
        }

        if(password.length() >= 6){
            count++;
        }

        boolean upperC = false, number = false;
        //uppercase and number check
        for(int i = 0; i < password.length(); i++){
            if(Character.isUpperCase(password.charAt(i))){
                upperC = true;
            }
            if(Character.isDigit(password.charAt(i))){
                Log.d("number", password);
                number = true;
            }
        }

        if(number){
            count++;
        }
        if(upperC){
            count++;
        }

        //special character
        if(!password.matches("[a-zA-Z0-9.?]*")){
            Log.d("special char", password);
            count++;
        }

        setStrength(count);
    }

    /**Sets the strength to an interval between zero and one*/
    public void setStrength(int strength){
        this.strength = (strength > 0) ? (double)strength/max : 0;
    }

    /**Return strength*/
    public double getStrength(){
        return strength;
    }
}
