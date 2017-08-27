package com.xgimi.playermenu.menu;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by linzhixin on 2017/8/27.
 */

public class XgimiPlayerMenuItemView extends RelativeLayout {

    private Context mContext;
    private String mName;
    private int mIconId;
    private TextView mNameTv;

    public XgimiPlayerMenuItemView(Context context, String name, int iconId) {
        super(context);
        this.mContext = context;
        this.mName = name;
        this.mIconId = iconId;
        initView(context);
    }

    public XgimiPlayerMenuItemView(Context context) {
        super(context);
        initView(context);
    }


    public XgimiPlayerMenuItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public XgimiPlayerMenuItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public XgimiPlayerMenuItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }


    private void initView(Context context) {
        this.mContext = context;
        mNameTv = new TextView(mContext);
        RelativeLayout.LayoutParams tvParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        tvParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        mNameTv.setLayoutParams(tvParams);
        mNameTv.setText(this.mName);
        mNameTv.setTextColor(Color.WHITE);
//        nameTv.setTextSize(15.0f);


        ImageView iconIv = new ImageView(mContext);
        RelativeLayout.LayoutParams ivParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );
        ivParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        iconIv.setLayoutParams(ivParams);
        Glide.with(mContext).load(mIconId).into(iconIv);

        this.addView(mNameTv);
        this.addView(iconIv);
    }

}
