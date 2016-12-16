package com.example.cecilialagerwall.labb2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cecilialagerwall on 2016-11-23.
 */

public class MyAdapter extends BaseExpandableListAdapter {
    private Context context;
    private ArrayList<Parent> theList;

    public MyAdapter(Context context, ArrayList<Parent> theList){
        this.context = context;
        this.theList = theList;
    }

    @Override
    public int getGroupCount() {
        return theList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return theList.get(groupPosition).getChildList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return theList.get(groupPosition).getName();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return theList.get(groupPosition).getChildList().get(childPosition).getName();
    }

    @Override
    public long getGroupId(int groupPosition) {

        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    //Get the View that displays the given group.
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        if(convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.parent_layout, null); //get the right parentview
        }

        TextView parentText = (TextView)convertView.findViewById(R.id.textView2);
        parentText.setText(theList.get(groupPosition).getName());

        return convertView;
    }
    //Get the View that displays the data for the given child within the given group.
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        if(convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.child_layout, null); //get the right childview
        }

        TextView childText = (TextView)convertView.findViewById(R.id.textView);
        childText.setText(theList.get(groupPosition).getChildList().get(childPosition).getName());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {

        return true;
    }
}
