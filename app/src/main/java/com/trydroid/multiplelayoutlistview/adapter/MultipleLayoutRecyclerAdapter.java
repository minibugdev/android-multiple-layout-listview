package com.trydroid.multiplelayoutlistview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.trydroid.multiplelayoutlistview.R;
import com.trydroid.multiplelayoutlistview.model.Item;

import java.util.ArrayList;
import java.util.List;

public class MultipleLayoutRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Item> items;

    public MultipleLayoutRecyclerAdapter(List<Item> items) {
        this.items = new ArrayList<>(items);

    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {

            case Item.TYPE_EDITTEXT:
                View vEditText = inflater.inflate(R.layout.edittext_list_row, parent, false);
                return new EditTextViewHolder(vEditText);

            case Item.TYPE_TEXTVIEW:
                View vTextView = inflater.inflate(R.layout.textview_list_row, parent, false);
                return new TextViewHolder(vTextView);

            case Item.TYPE_IMAGEVIEW:
            default:
                View vImageView = inflater.inflate(R.layout.imageview_list_row, parent, false);
                return new ImageViewHolder(vImageView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        Item item = items.get(position);
        switch (viewHolder.getItemViewType()) {

            case Item.TYPE_EDITTEXT:
                EditTextViewHolder editTextViewHolder = (EditTextViewHolder) viewHolder;
                editTextViewHolder.editText.setText(item.getData());
                break;

            case Item.TYPE_TEXTVIEW:
                TextViewHolder textViewHolder = (TextViewHolder) viewHolder;
                textViewHolder.textView.setText(item.getData());
                break;

            case Item.TYPE_IMAGEVIEW:
            default:
                ImageViewHolder imageViewHolder = (ImageViewHolder) viewHolder;
                imageViewHolder.textView.setText(item.getData());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class EditTextViewHolder extends RecyclerView.ViewHolder {
        private EditText editText;


        public EditTextViewHolder(View itemView) {
            super(itemView);
            this.editText = (EditText) itemView.findViewById(R.id.edittext);
        }
    }

    static class TextViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public TextViewHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.textview);
        }
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView  textView;

        public ImageViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageview);
            this.textView = (TextView) itemView.findViewById(R.id.textview);
        }
    }
}
