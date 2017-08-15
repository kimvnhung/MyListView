package com.kimvan.hung.mylistview;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by h on 08/08/2017.
 */

public class CustomApdater extends BaseAdapter {

    public static final String tag = "wrong";
    Context context;
    ArrayList<RowItem> rowItems;

    public CustomApdater(Context context, ArrayList<RowItem> rowItems) {
        this.context = context;
        this.rowItems = rowItems;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }

    private class ViewHolder{
        ImageView profile_pic;
        TextView full_name;
        TextView sex;
        TextView status;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_view,null);

            holder = new ViewHolder();

            holder.full_name = (TextView)convertView.findViewById(R.id.full_name);
            holder.sex = (TextView) convertView.findViewById(R.id.sex);
            holder.profile_pic = (ImageView) convertView.findViewById(R.id.profile_pic);
            holder.status = (TextView) convertView.findViewById(R.id.status);


            RowItem row_pos = rowItems.get(position);

            holder.profile_pic.setImageResource(row_pos.getProfile_pic_link());
            holder.full_name.setText(row_pos.getFull_name());
            holder.sex.setText(row_pos.getSex());

            holder.status.setText(row_pos.getStatus());
            Log.i(CustomApdater.tag,"getView");

            convertView.setTag(holder);


        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }
}
