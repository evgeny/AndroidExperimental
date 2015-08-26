package com.evgeny.daggersample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.evgeny.daggersample.data.Event;

import javax.inject.Inject;

public class EventListAdapter extends BaseAdapter {

    private final LayoutInflater layoutInflater;
    private Event[] data = new Event[0];

    @Inject
    public EventListAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    public void setData(Event[] data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Event getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return data[position].id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(android.R.layout.simple_list_item_2, parent, false);
        }

        Event event = getItem(position);
        TextView textView1 = (TextView) convertView.findViewById(android.R.id.text1);
        TextView textView2 = (TextView) convertView.findViewById(android.R.id.text2);
        textView1.setText(event.title);
        textView2.setText(event.description);

        return convertView;
    }
}
