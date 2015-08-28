package com.trydroid.multiplelayoutlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MultipleLayoutAdapter extends BaseAdapter {

    private Context    context;
    private List<Item> items;

    public MultipleLayoutAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Item getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getType();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Item item = getItem(position);
        int viewType = getItemViewType(position);
        switch (viewType) {
            case Item.TYPE_EDITTEXT:
                convertView = inflateEditTextView(convertView, parent, item);
                break;

            case Item.TYPE_TEXTVIEW:
                convertView = inflateTextView(convertView, parent, item);
                break;

            case Item.TYPE_IMAGEVIEW:
                convertView = inflateImageView(convertView, parent, item);
                break;
        }
        return convertView;
    }

    private View inflateEditTextView(View convertView, ViewGroup parent, Item item) {
        EditTextViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.edittext_list_row, parent, false);
            viewHolder = new EditTextViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (EditTextViewHolder) convertView.getTag();
        }

        viewHolder.editText.setText(item.getData());

        return convertView;
    }

    private View inflateTextView(View convertView, ViewGroup parent, Item item) {
        TextViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.textview_list_row, parent, false);
            viewHolder = new TextViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (TextViewHolder) convertView.getTag();
        }

        viewHolder.textView.setText(item.getData());

        return convertView;
    }

    private View inflateImageView(View convertView, ViewGroup parent, Item item) {
        ImageViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.imageview_list_row, parent, false);
            viewHolder = new ImageViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ImageViewHolder) convertView.getTag();
        }

        viewHolder.textView.setText(item.getData());

        return convertView;
    }


    static class EditTextViewHolder {
        private EditText editText;

        public EditTextViewHolder(View convertView) {
            this.editText = (EditText) convertView.findViewById(R.id.edittext);
        }
    }

    static class TextViewHolder {
        private TextView textView;

        public TextViewHolder(View convertView) {
            this.textView = (TextView) convertView.findViewById(R.id.textview);
        }
    }

    static class ImageViewHolder {
        private ImageView imageView;
        private TextView  textView;

        public ImageViewHolder(View convertView) {
            this.imageView = (ImageView) convertView.findViewById(R.id.imageview);
            this.textView = (TextView) convertView.findViewById(R.id.textview);
        }
    }

}
