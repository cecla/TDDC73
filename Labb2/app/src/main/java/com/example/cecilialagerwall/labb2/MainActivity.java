package com.example.cecilialagerwall.labb2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnChildClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Parent> theList = new ArrayList<Parent>();
    private EditText editText;
    private MyAdapter theAdapter;
    private ExpandableListView myExpListView;
    private int lastExpanded = -1;
    boolean found, clicked = false;
    int pos, index = -1, posCheck = -1;
    String saveWord = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        editText.setText("");
        editText.setBackgroundColor(Color.WHITE);

        myExpListView = (ExpandableListView)findViewById(R.id.ExtandableListView);

        createList();

        theAdapter = new MyAdapter(MainActivity.this, theList);

        myExpListView.setAdapter(theAdapter);

        myExpListView.setOnGroupClickListener(clickedOnGroup);
        myExpListView.setOnChildClickListener(clickedOnChild);

        editText.addTextChangedListener((TextWatcher) changedText);

        myExpListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                if(lastExpanded != -1 && groupPosition != lastExpanded){
                    myExpListView.collapseGroup(lastExpanded);
                }
                lastExpanded = groupPosition;
            }

        });

    }

    private TextWatcher changedText = new TextWatcher() {

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }


        public void onTextChanged(CharSequence s, int start, int before, int count) {
            editText.setVisibility(View.VISIBLE);
        }

        public void afterTextChanged(Editable s) {

            if(clicked){
                clicked = false;
                return;
            }

            Log.d("test", saveWord);


            editText.setBackgroundColor(Color.WHITE);

            found = false;

            String changedText = s.toString();
            String [] sText = changedText.split("/");

            changedText = "";
            for(String word : sText) {

                if (!word.equals("/")) {
                    changedText += word;
                }
            }

            if(s.length() == 0){

                saveWord = "";
                index = -1;
                myExpListView.setItemChecked(index, true);
                return;
            }

            if(s.length() == 1 && s.toString().equals("/")){
                return;
            }

            if(sText.length > 1){
                for(int i = 0; i < theAdapter.getGroupCount(); i++) {

                    if(changedText.length() == theAdapter.getGroup(i).toString().length() && changedText.equals(theAdapter.getGroup(i).toString())){

                        found = true;
                        saveWord = theAdapter.getGroup(i).toString();
                        index = myExpListView.getFlatListPosition(ExpandableListView.getPackedPositionForGroup(i));
                        pos = i;
                        posCheck = i;
                        break;

                    }

                    if(sText.length == 2 && changedText.length() <= theAdapter.getGroup(i).toString().length() && changedText.equals(theAdapter.getGroup(i).toString().substring(0, changedText.length()))) {
                        found = true;
                        break;
                    }

                    for(int j = 0; j < theAdapter.getChildrenCount(i); j++) {

                        if(sText.length == 3) {
                            String word = theAdapter.getGroup(i).toString() + theAdapter.getChild(i,j).toString();

                            if(changedText.length() == word.length() && changedText.equals(word)) {

                                found = true;
                                saveWord = word;
                                posCheck = i + j + 1;
                                index = myExpListView.getFlatListPosition(ExpandableListView.getPackedPositionForChild(i,j));
                                break;

                            }

                            if((changedText.length() < saveWord.length() && changedText.equals(saveWord.substring(0,changedText.length())))
                                    || (changedText.length() > saveWord.length() && changedText.length() < word.length() && changedText.equals(word.substring(0,changedText.length())))) {

                                found = true;
                                break;

                            }
                        }
                    }
                }
            }

            if(found){
                Log.d("debug", "jag gick in i found");
                editText.setBackgroundColor(Color.WHITE);

                myExpListView.setItemChecked(index, true);
                myExpListView.expandGroup(pos);

                index = posCheck;

                lastExpanded = pos;

            } else {

                editText.setBackgroundColor(Color.RED);
                myExpListView.setItemChecked(index, false);
            }
        }
    };

    private OnGroupClickListener clickedOnGroup = new ExpandableListView.OnGroupClickListener(){
        public boolean onGroupClick(ExpandableListView parent, View view, int groupPosition, long id){

            clicked = true;
            editText.setBackgroundColor(Color.WHITE);
            //saveWord = "";

            editText.setText("/" + parent.getExpandableListAdapter().getGroup(groupPosition).toString());

            index = parent.getFlatListPosition(ExpandableListView.getPackedPositionForGroup(groupPosition));
            parent.setItemChecked(index, true);

            saveWord = parent.getExpandableListAdapter().getGroup(groupPosition).toString();
            index = groupPosition;
            pos = groupPosition;
            posCheck = index;

            return false;
        }
    };

    private OnChildClickListener clickedOnChild = new ExpandableListView.OnChildClickListener(){
        public boolean onChildClick(ExpandableListView parent, View view, int groupPosition, int childPosition, long id){

            clicked = true;
            editText.setBackgroundColor(Color.WHITE);
            //saveWord = "";

            editText.setText("/" + parent.getExpandableListAdapter().getGroup(groupPosition).toString() + "/" + parent.getExpandableListAdapter().getChild(groupPosition, childPosition));

            index = parent.getFlatListPosition(ExpandableListView.getPackedPositionForChild(groupPosition, childPosition));
            parent.setItemChecked(index, true);

            saveWord = parent.getExpandableListAdapter().getGroup(groupPosition).toString() + parent.getExpandableListAdapter().getChild(groupPosition, childPosition);
            index = groupPosition + childPosition + 1;
            posCheck = index;
            pos = groupPosition;

            return false;
        }
    };

    public void createList(){
        ArrayList<Child> mediumList = new ArrayList<Child>();
        Child child = new Child("green");
        mediumList.add(child);
        child = new Child("yellow");
        mediumList.add(child);
        child = new Child("blue");
        mediumList.add(child);

        Parent parent = new Parent("medium", mediumList);
        theList.add(parent);

        ArrayList<Child> lightList = new ArrayList<Child>();
        child = new Child("green");
        lightList.add(child);
        child = new Child("yellow");
        lightList.add(child);
        child = new Child("blue");
        lightList.add(child);

        parent = new Parent("light", lightList);
        theList.add(parent);

        ArrayList<Child> darkList = new ArrayList<Child>();
        child = new Child("red");
        darkList.add(child);
        child = new Child("pink");
        darkList.add(child);
        child = new Child("blue");
        darkList.add(child);

        parent = new Parent("dark", darkList);
        theList.add(parent);

        ArrayList<Child> bugList = new ArrayList<Child>();
        child = new Child("green");
        bugList.add(child);
        child = new Child("pink");
        bugList.add(child);
        child = new Child("annat");
        bugList.add(child);

        parent = new Parent("bugList", bugList);
        theList.add(parent);

        ArrayList<Child> bugList2 = new ArrayList<Child>();
        child = new Child("green");
        bugList2.add(child);
        child = new Child("pink");
        bugList2.add(child);
        child = new Child("annat");
        bugList2.add(child);

        parent = new Parent("bugList2", bugList2);
        theList.add(parent);
    }

}
