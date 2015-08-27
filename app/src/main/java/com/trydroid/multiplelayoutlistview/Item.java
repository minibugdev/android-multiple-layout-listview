package com.trydroid.multiplelayoutlistview;

public class Item {
    public static final int TYPE_EDITTEXT  = 0;
    public static final int TYPE_TEXTVIEW  = 1;
    public static final int TYPE_IMAGEVIEW = 2;

    private String data;
    private int    type;

    public Item(String data, int type) {
        this.data = data;
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public int getType() {
        return type;
    }
}
