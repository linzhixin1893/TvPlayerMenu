package com.xgimi.playermenu.menu;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xgimi.playermenu.R;

import java.util.List;

/**
 * Created by linzhixin on 2017/8/27.
 */

public class XgimiPlayerMenuAdapter extends BaseAdapter {

    private static final String TAG = "XgimiPlayerMenuAdapter";
    private List<XgimiPlayerMenu> mDataList;
    private Context mContext;

    public XgimiPlayerMenuAdapter(Context context, List<XgimiPlayerMenu> mMainMenu) {
        this.mDataList = mMainMenu;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.menu_item_layout, parent, false);
            viewHolder.iv = (ImageView) convertView.findViewById(R.id.iv_menu_item_icon);
            viewHolder.tv = (TextView) convertView.findViewById(R.id.tv_menu_item_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv.setText(mDataList.get(position).getmName());
        if (mDataList.get(position).getmIconId() != -1) {
            viewHolder.iv.setVisibility(View.VISIBLE);
            Glide.with(mContext).load(mDataList.get(position).getmIconId()).into(viewHolder.iv);
        } else {
            viewHolder.iv.setVisibility(View.GONE);
        }

        return convertView;
    }

    public void changeData(List<XgimiPlayerMenu> xgimiPlayerMenus) {
        if (mDataList != null) {
            mDataList = xgimiPlayerMenus;
            notifyDataSetChanged();
        }
    }

    private class ViewHolder {
        ImageView iv;
        TextView tv;
    }
}
