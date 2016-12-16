package com.example.cecilialagerwall.labb3;

import android.content.Context;
import android.os.AsyncTask;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListPopupWindow;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by cecilialagerwall on 2016-11-29.
 */

public class InteractiveSearcher extends EditText {

    private static final String DEBUG_TAG = "DEBUG";
    Context context;
    ListPopupWindow listPopupWindow;
    ArrayList<String> theList;
    HashMap<Integer, ArrayList<String>> searchList = new HashMap<Integer, ArrayList<String>>();
    int countID = 0;
    MyListAdapter myListAdapter;
    int nrOfItems;

    public InteractiveSearcher(Context context, int nrOfItems){
        super(context);
        this.context = context;
        this.nrOfItems = nrOfItems;
        init();
    }
    private void init(){
        setEms(10);
        setHint("Search...");

        this.addTextChangedListener((TextWatcher) changedText);

        listPopupWindow = new ListPopupWindow(context);
        listPopupWindow.setAnchorView(this);
        listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id){
                setText(adapterView.getItemAtPosition(pos).toString());
            }
        });
    }

    private TextWatcher changedText = new TextWatcher() {

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        public void afterTextChanged(Editable s) {

            if(s.length() > 0){
                String urlString = "http://flask-afteach.rhcloud.com/getnames/" + countID++ + "/"  + s;

                new TestAsync().execute(urlString);

            }
        }
    };

    public class TestAsync extends AsyncTask<String,Void,String> {
        @Override
        protected void onPostExecute(String result) {

            int rightID = parseJSON(result);

            Log.d("ids", rightID + "  " + countID);

            //if(rightID == countID){
                myListAdapter = new MyListAdapter(context, searchList.get(countID));
                listPopupWindow.setAdapter(myListAdapter);
                listPopupWindow.show();
            //}

        }

        @Override
        protected String doInBackground(String... urls) {

            StringBuilder content = new StringBuilder();

            try {
                URL url = new URL(urls[0]);

                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                try{
                    urlConnection.setReadTimeout(10000);
                    urlConnection.setConnectTimeout(15000);
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setDoInput(true);

                    urlConnection.connect();

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

                    String theString = "";

                    while((theString = bufferedReader.readLine()) != null){
                        content.append(theString);
                    }

                    bufferedReader.close();
                   // Log.d("content", content.toString());



                } finally {
                        urlConnection.disconnect();
                }
            } catch (IOException e) {
                Log.e("ERROR ", e.getMessage());

            }
            return content.toString();
        }
    }

    private int parseJSON(String string){

        if (string != null) {
            theList = new ArrayList<String>();
            try {
                JSONObject jsonObject = new JSONObject(string);

                JSONArray names = jsonObject.getJSONArray("result");

                if(names.length() > nrOfItems){
                    for (int i = 0; i < nrOfItems; i++) {
                        theList.add(names.get(i).toString());
                    }
                } else {
                    for (int i = 0; i < names.length(); i++) {
                        theList.add(names.get(i).toString());
                    }
                }


                searchList.put(countID, theList);

                return countID;

            } catch (final JSONException e) {
                Log.e(DEBUG_TAG, e.getMessage());
            }
        }

        return 0;
    }
}
