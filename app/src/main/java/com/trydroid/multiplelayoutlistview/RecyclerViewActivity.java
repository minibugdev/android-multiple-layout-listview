package com.trydroid.multiplelayoutlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.trydroid.multiplelayoutlistview.adapter.MultipleLayoutRecyclerAdapter;
import com.trydroid.multiplelayoutlistview.model.Item;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        List<Item> items = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            items.add(new Item("I am EditText layout #" + i, Item.TYPE_EDITTEXT));
            items.add(new Item("I am TextView layout #" + i, Item.TYPE_TEXTVIEW));
            items.add(new Item("I am ImageView layout #" + i, Item.TYPE_IMAGEVIEW));
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MultipleLayoutRecyclerAdapter(items));
    }
}
