package ru.netology.lists;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivity extends AppCompatActivity {
    private static final String KEY_TEXT = "key_text";
    private static final String KEY_COUNT = "key_count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView list = findViewById(R.id.list);

        BaseAdapter listContentAdapter = createAdapter(prepareContent());

        list.setAdapter(listContentAdapter);
    }

    @NonNull
    private BaseAdapter createAdapter(List<Map<String, String>> values) {
        return new SimpleAdapter(this, values, R.layout.item_layout, new String[]{KEY_TEXT, KEY_COUNT}, new int[]{R.id.textView, R.id.countView});
    }


    @NonNull
    private List<Map<String, String>> prepareContent() {
        String[] strarr = getString(R.string.large_text).split("\n\n");
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        for (String text : strarr) {
            Map<String, String> map = new HashMap<String, String>();
            map.put(KEY_TEXT, text);
            map.put(KEY_COUNT, "" + text.length());
            list.add(map);
        }
        return list;
    }
}
