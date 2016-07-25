package ua.com.webacademy.beginnerslection9;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        ExpandableListView listView = (ExpandableListView) findViewById(R.id.expListView);

        ArrayList<Map<String, String>> groups = new ArrayList<>();

        HashMap<String, String> group = new HashMap<>();
        group.put("Number", "1");
        groups.add(group);

        group = new HashMap<>();
        group.put("Number", "2");
        groups.add(group);

        ArrayList<ArrayList<Map<String, String>>> childs = new ArrayList<>();

        ArrayList<Map<String, String>> child = new ArrayList<>();

        HashMap<String, String> childItem = new HashMap<>();
        childItem.put("Name", "Ivan");
        child.add(childItem);

        childItem = new HashMap<>();
        childItem.put("Name", "Petro");
        child.add(childItem);

        childs.add(child);

        child = new ArrayList<>();

        childItem = new HashMap<>();
        childItem.put("Name", "Alex");
        child.add(childItem);

        childItem = new HashMap<>();
        childItem.put("Name", "Ann");
        child.add(childItem);

        childs.add(child);

        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this,
                groups,
                android.R.layout.simple_expandable_list_item_1,
                new String[]{"Number"},
                new int[]{android.R.id.text1},
                childs,
                android.R.layout.simple_list_item_1,
                new String[]{"Name"},
                new int[]{android.R.id.text1});

        listView.setAdapter(adapter);
    }
}
