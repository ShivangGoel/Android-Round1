package com.demo.hqinterviewdemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.demo.hqinterviewdemo.R;
import com.demo.hqinterviewdemo.model.DataBeanList;

import java.util.HashMap;

/**
 * Created by shivang on 19/1/16.
 */
public class ListAdapter extends BaseAdapter {

    private Context mContext;
    private ViewHolder viewHolder;
    private LayoutInflater inflater;
    private HashMap<String, Object> mDataMap;
    private DataBeanList mDataBeanList;

    public ListAdapter(Context context, DataBeanList dataBeanList){
        mContext = context;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mDataBeanList = dataBeanList;

    }

    @Override
    public int getCount() {
        return mDataBeanList.getDataBeanList().size();
    }

    @Override
    public Object getItem(int position) {
        return mDataBeanList.getDataBeanList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = inflater.inflate(R.layout.layout_list_items, parent, false);
            viewHolder=new ViewHolder();

            //cache the views
            viewHolder.textView = (TextView)convertView.findViewById(R.id.textview);

            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();
        }

        viewHolder.textView.setText(mDataBeanList.getDataBean(position).getKey());

        return convertView;
    }

    //class for caching the views in a row
    private class ViewHolder{
        TextView textView;

    }

}
