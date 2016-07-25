package ua.com.webacademy.beginnerslection9;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ExpandableAdapter extends BaseExpandableListAdapter {

    private Group[] mGroups;
    private LayoutInflater mInflater;

    public ExpandableAdapter(Context context, Group[] groups) {
        this.mGroups = groups;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return mGroups.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mGroups[groupPosition].Students.length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mGroups[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mGroups[groupPosition].Students[childPosition];
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.group_item, null);

        Group group = mGroups[groupPosition];

        TextView number = (TextView) convertView.findViewById(R.id.groupNumber);
        number.setText(group.Number);

        View indicator = convertView.findViewById(R.id.viewIndicator);

        if(isExpanded){
            indicator.setBackgroundColor(Color.RED);
        }else{
            indicator.setBackgroundColor(Color.GREEN);
        }

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.child_item, null);

        Student student = mGroups[groupPosition].Students[childPosition];

        TextView firstName = (TextView) convertView.findViewById(R.id.firstName);
        TextView lastName = (TextView) convertView.findViewById(R.id.lastName);
        TextView age = (TextView) convertView.findViewById(R.id.age);

        firstName.setText(student.FirstName);
        lastName.setText(student.LastName);
        age.setText(String.valueOf(student.Age));

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
