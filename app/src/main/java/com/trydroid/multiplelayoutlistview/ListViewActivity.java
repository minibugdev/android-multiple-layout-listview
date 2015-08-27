package com.trydroid.multiplelayoutlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView listView = (ListView) findViewById(R.id.listview);

        List<Item> items = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            items.add(new Item("I am EditText layout #" + i, Item.TYPE_EDITTEXT));
            items.add(new Item("I am TextView layout #" + i, Item.TYPE_TEXTVIEW));
            items.add(new Item("I am ImageView layout #" + i, Item.TYPE_IMAGEVIEW));
        }

        MultipleLayoutAdapter adapter = new MultipleLayoutAdapter(this, items);
        listView.setAdapter(adapter);
    }
}
