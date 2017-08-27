package com.xgimi.playermenu.menu;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.xgimi.playermenu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linzhixin on 2017/8/27.
 */

public class MenuFactory {



    private static MenuFactory mFactory;
    private Context mContext;

    private XgimiPlayerMenuAdapter mMainMenuAdapter;
    private ArrayAdapter mMainMenuSimpleAdapter;
    private List<XgimiPlayerMenu> mMainMenu;
    private List<String> mTestMenu;

    public static MenuFactory getInstance(Context context) {
        if (mFactory == null) {
            mFactory = new MenuFactory(context);
        }
        return mFactory;
    }


    private MenuFactory(Context context) {
        this.mContext = context;
    }

    public XgimiPlayerMenuAdapter getMainMenuAdapter() {
        if (mMainMenu == null) {
            mMainMenu = new ArrayList<>();
            XgimiPlayerMenu threeDmenu = new XgimiPlayerMenu("3D模式");
            threeDmenu.setmIconId(R.drawable.img_menu_3d);

            XgimiPlayerMenu imageModeMenu = new XgimiPlayerMenu("图像模式");
            imageModeMenu.setmIconId(R.drawable.img_menu_image_mode);

            XgimiPlayerMenu zoomMenu = new XgimiPlayerMenu("画面比例");
            zoomMenu.setmIconId(R.drawable.img_menu_zoom);

            XgimiPlayerMenu subTitleMenu = new XgimiPlayerMenu("字幕设置");
            subTitleMenu.setmIconId(R.drawable.img_menu_subtitle);

            mMainMenu.add(threeDmenu);
            mMainMenu.add(imageModeMenu);
            mMainMenu.add(zoomMenu);
            mMainMenu.add(subTitleMenu);
        }


        if (mMainMenuAdapter == null) {
            mMainMenuAdapter = new XgimiPlayerMenuAdapter(mContext, mMainMenu);
        }

        return mMainMenuAdapter;
    }

    public List<XgimiPlayerMenu> getMainMenuList() {
        if (mMainMenu == null) {
            mMainMenu = new ArrayList<>();
            XgimiPlayerMenu threeDmenu = new XgimiPlayerMenu("3D模式");
            threeDmenu.setmIconId(R.drawable.img_menu_3d);
            threeDmenu.getmSubMenuList().add(new XgimiPlayerMenu("关闭"));
            threeDmenu.getmSubMenuList().add(new XgimiPlayerMenu("左右"));
            threeDmenu.getmSubMenuList().add(new XgimiPlayerMenu("上下"));
            threeDmenu.getmSubMenuList().add(new XgimiPlayerMenu("2D转3D"));
            threeDmenu.getmSubMenuList().add(new XgimiPlayerMenu("3D转2D"));

            XgimiPlayerMenu imageModeMenu = new XgimiPlayerMenu("图像模式");
            imageModeMenu.setmIconId(R.drawable.img_menu_image_mode);
            imageModeMenu.getmSubMenuList().add(new XgimiPlayerMenu("标准"));
            imageModeMenu.getmSubMenuList().add(new XgimiPlayerMenu("明亮"));
            imageModeMenu.getmSubMenuList().add(new XgimiPlayerMenu("关灯"));
            imageModeMenu.getmSubMenuList().add(new XgimiPlayerMenu("自定义"));

            XgimiPlayerMenu zoomMenu = new XgimiPlayerMenu("画面比例");
            zoomMenu.setmIconId(R.drawable.img_menu_zoom);
            zoomMenu.getmSubMenuList().add(new XgimiPlayerMenu("16:9"));
            zoomMenu.getmSubMenuList().add(new XgimiPlayerMenu("4:3"));
            zoomMenu.getmSubMenuList().add(new XgimiPlayerMenu("去黑边"));
            zoomMenu.getmSubMenuList().add(new XgimiPlayerMenu("原始比例"));

            XgimiPlayerMenu subTitleMenu = new XgimiPlayerMenu("字幕设置");
            subTitleMenu.setmIconId(R.drawable.img_menu_subtitle);
            subTitleMenu.getmSubMenuList().add(new XgimiPlayerMenu("关闭"));
            subTitleMenu.getmSubMenuList().add(new XgimiPlayerMenu("自动下载"));

            mMainMenu.add(threeDmenu);
            mMainMenu.add(imageModeMenu);
            mMainMenu.add(zoomMenu);
            mMainMenu.add(subTitleMenu);
        }
        return mMainMenu;
    }

    public ArrayAdapter getMainMenuSimpleAdapter() {

        if (mTestMenu == null) {
            mTestMenu = new ArrayList<>();
            mTestMenu.add("3D模式");
            mTestMenu.add("图像模式");
            mTestMenu.add("画面比例");
            mTestMenu.add("字幕设置");
        }
        if (mMainMenuSimpleAdapter == null) {
            mMainMenuSimpleAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, mTestMenu);
        }

        return mMainMenuSimpleAdapter;
    }
}
