package com.xgimi.playermenu.menu;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.xgimi.playermenu.R;

import java.util.List;

/**
 * Created by linzhixin on 2017/8/27.
 */

public class XgimiPlayerMenuView extends RelativeLayout implements IXgimiPlayerMenuView{

    private static final String TAG = "XgimiPlayerMenuView";
    private Context mContext;
    private RelativeLayout mRootView;
    private RelativeLayout mMainMenuRl;
    private RelativeLayout mSubMenuRl;
    private ListView mMainMenuLv;
    private ListView mSubMenuLv;

    private Animation mMainMenuSelectedAnimation;
    private Animation mMainMenuNotSelectedAnimation;
    private Animation mSubMenuSelectedAnimation;
    private Animation mSubMenuNotSelectedAnimation;


    private List<XgimiPlayerMenu> mMainMenuList;
    private XgimiPlayerMenuAdapter mSubMenuAdapter;

    private AdapterView.OnItemClickListener mOnMainMenuItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Log.d(TAG, "onItemClick: " + mMainMenuList.get(position).getmName() + ", subSzie = " + mMainMenuList.get(position).getmSubMenuList().size());
            mSubMenuAdapter.changeData(mMainMenuList.get(position).getmSubMenuList());
        }
    };

    private AdapterView.OnItemClickListener mOnSubMenuItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }
    };

    public XgimiPlayerMenuView(Context context) {
        super(context);
        initView(context);
    }

    public XgimiPlayerMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public XgimiPlayerMenuView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public XgimiPlayerMenuView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }


    private void initView(Context context) {
        mContext = context;
        mRootView = (RelativeLayout) LayoutInflater.from(mContext).inflate(R.layout.layout_menu, null);

        mMainMenuRl = new RelativeLayout(mContext);
        RelativeLayout.LayoutParams mainRlParams = new RelativeLayout.LayoutParams(400, ViewGroup.LayoutParams.MATCH_PARENT);
        mainRlParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        mMainMenuRl.setLayoutParams(mainRlParams);
        mMainMenuRl.setBackgroundColor(Color.parseColor("#6CA6CD"));

        mSubMenuRl = new RelativeLayout(mContext);
        RelativeLayout.LayoutParams subRlParams = new RelativeLayout.LayoutParams(300, ViewGroup.LayoutParams.MATCH_PARENT);
        subRlParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        mSubMenuRl.setLayoutParams(subRlParams);
        mSubMenuRl.setBackgroundColor(Color.parseColor("#A066CDAA"));

        mRootView.addView(mMainMenuRl);
        mRootView.addView(mSubMenuRl);

        this.addView(mRootView);
    }


    @Override
    public void initMainMenu(List<XgimiPlayerMenu> mainMenuList, XgimiPlayerMenuAdapter adapter) {
        mMainMenuLv = new ListView(mContext);
        mMainMenuList = mainMenuList;
        RelativeLayout.LayoutParams mainMenuLvParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        mainMenuLvParams.leftMargin = 20;
        mainMenuLvParams.rightMargin = 20;
        mainMenuLvParams.addRule(RelativeLayout.CENTER_VERTICAL);
        mMainMenuLv.setLayoutParams(mainMenuLvParams);
        mMainMenuLv.setAdapter(adapter);
        mMainMenuLv.setOnItemClickListener(mOnMainMenuItemClickListener);
        mMainMenuRl.addView(mMainMenuLv);

        mSubMenuLv = new ListView(mContext);
        RelativeLayout.LayoutParams subMenuParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        subMenuParams.leftMargin = 20;
        subMenuParams.rightMargin = 20;
        subMenuParams.addRule(RelativeLayout.CENTER_VERTICAL);
        mSubMenuAdapter = new XgimiPlayerMenuAdapter(mContext, mMainMenuList.get(0).getmSubMenuList());
        mSubMenuLv.setLayoutParams(subMenuParams);
        mSubMenuLv.setAdapter(mSubMenuAdapter);
        mSubMenuLv.setOnItemClickListener(mOnSubMenuItemClickListener);
        mSubMenuRl.addView(mSubMenuLv);
        invalidate();
    }

    @Override
    public void initMainMenu(ArrayAdapter mainMenuSimpleAdapter) {
        mMainMenuLv = new ListView(mContext);
        RelativeLayout.LayoutParams mainMenuLvParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        mainMenuLvParams.leftMargin = 20;
        mainMenuLvParams.rightMargin = 20;
        mMainMenuLv.setLayoutParams(mainMenuLvParams);
        mMainMenuLv.setAdapter(mainMenuSimpleAdapter);
        mMainMenuRl.addView(mMainMenuLv);
        invalidate();
    }

    @Override
    public void mainMenuSelected() {
        if (mMainMenuSelectedAnimation == null) {
            mMainMenuSelectedAnimation = AnimationUtils.loadAnimation(mContext, R.anim.menu_main_menu_seletced);
            mMainMenuSelectedAnimation.setFillAfter(true);
        }
        if (mSubMenuNotSelectedAnimation == null) {
            mSubMenuNotSelectedAnimation = AnimationUtils.loadAnimation(mContext, R.anim.menu_sub_menu_not_seletced);
            mSubMenuNotSelectedAnimation.setFillAfter(true);
        }
        mMainMenuRl.startAnimation(mMainMenuSelectedAnimation);
        mSubMenuRl.startAnimation(mSubMenuNotSelectedAnimation);
    }

    @Override
    public void subMenuSeletced() {
        if (mMainMenuNotSelectedAnimation == null) {
            mMainMenuNotSelectedAnimation = AnimationUtils.loadAnimation(mContext, R.anim.menu_main_menu_not_selcted);
            mMainMenuNotSelectedAnimation.setFillAfter(true);
        }
        if (mSubMenuSelectedAnimation == null) {
            mSubMenuSelectedAnimation = AnimationUtils.loadAnimation(mContext, R.anim.menu_sub_menu_selected);
            mSubMenuSelectedAnimation.setFillAfter(true);

        }
        mMainMenuRl.startAnimation(mMainMenuNotSelectedAnimation);
        mSubMenuRl.startAnimation(mSubMenuSelectedAnimation);
    }


}
