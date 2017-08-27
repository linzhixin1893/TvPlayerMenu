package com.xgimi.playermenu.menu;

import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by linzhixin on 2017/8/27.
 */

public interface IXgimiPlayerMenuView {

    void initMainMenu(List<XgimiPlayerMenu> mainMenuList, XgimiPlayerMenuAdapter adapter);

    void mainMenuSelected();

    void subMenuSeletced();

    void initMainMenu(ArrayAdapter mainMenuSimpleAdapter);
}
