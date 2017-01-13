package com.example.cecilialagerwall.labb3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by cecilialagerwall on 2016-12-01.
 */

public class MyListAdapter extends BaseAdapter {

    private Context context;
    private List<String> theList;

    public MyListAdapter(Context context, List<String> theList){
        this.context = context;
        this.theList = theList;
    }

    @Override
    public int getCount(){
        return theList.size();
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup){
        //create an item with the name on the specified position
        return new CreateItemView(context, theList.get(pos));
    }

    @Override
    public long getItemId(int pos){
        return pos;
    }

    @Override
    public Object getItem(int pos){
        return theList.get(pos);
    }
}
