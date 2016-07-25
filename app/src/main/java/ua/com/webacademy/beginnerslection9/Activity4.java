package ua.com.webacademy.beginnerslection9;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;

public class Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        final ExpandableListView listView = (ExpandableListView) findViewById(R.id.expListView);

        Group[] groups = new Group[2];

        Group group = new Group("1");
        group.Students = new Student[]{
                new Student("Ivan", "Ivanov", 22),
                new Student("Ivan1", "Ivanov1", 23)
        };

        groups[0] = group;

        group = new Group("2");
        group.Students = new Student[]{
                new Student("Ivan2", "Ivanov2", 22),
                new Student("Ivan3", "Ivanov3", 23)
        };

        groups[1] = group;

        ExpandableAdapter adapter = new ExpandableAdapter(this, groups);
        listView.setAdapter(adapter);

        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return false;
            }
        });

        listView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {

            }
        });

        listView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {

            }
        });

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                return false;
            }
        });
    }
}
