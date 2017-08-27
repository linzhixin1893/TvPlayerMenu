package com.xgimi.playermenu.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linzhixin on 2017/8/27.
 */

public class XgimiPlayerMenu {
    private String mName;
    private int mIconId = -1;
    private int mType;
    private List<String> mTextOptions;
    private List<Integer> mIntOptions;
    private List<Float> mFloatOptions;

    private List<XgimiPlayerMenu> mSubMenuList;

    public XgimiPlayerMenu() {
    }

    public XgimiPlayerMenu(String mName) {
        this.mName = mName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmIconId() {
        return mIconId;
    }

    public void setmIconId(int mIconId) {
        this.mIconId = mIconId;
    }

    public int getmType() {
        return mType;
    }

    public void setmType(int mType) {
        this.mType = mType;
    }

    public List<String> getmTextOptions() {
        return mTextOptions;
    }

    public void setmTextOptions(List<String> mTextOptions) {
        this.mTextOptions = mTextOptions;
    }

    public List<Integer> getmIntOptions() {
        return mIntOptions;
    }

    public void setmIntOptions(List<Integer> mIntOptions) {
        this.mIntOptions = mIntOptions;
    }

    public List<Float> getmFloatOptions() {
        return mFloatOptions;
    }

    public void setmFloatOptions(List<Float> mFloatOptions) {
        this.mFloatOptions = mFloatOptions;
    }

    public List<XgimiPlayerMenu> getmSubMenuList() {
        if (mSubMenuList == null) {
            mSubMenuList = new ArrayList<>();
        }
        return mSubMenuList;
    }

    public void setmSubMenuList(List<XgimiPlayerMenu> mSubMenuList) {
        if (mSubMenuList == null) {
            mSubMenuList = new ArrayList<>();
        }
        this.mSubMenuList = mSubMenuList;
    }
}
