package ua.com.webacademy.beginnerslection9;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        ListView listView = findViewById(R.id.listView);

        DataBaseHelper DBHelper = new DataBaseHelper(this);
        SQLiteDatabase db = DBHelper.getWritableDatabase();

        Cursor studentsCursor = db.query(Student.TABLE_NAME, null, null, null, null, null, null);

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_2,
                studentsCursor,
                new String[]{Student.COLUMN_FIRST_NAME, Student.COLUMN_LAST_NAME},
                new int[]{android.R.id.text1, android.R.id.text2});

        listView.setAdapter(adapter);
    }
}
