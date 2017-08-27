package com.xgimi.playermenu.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xgimi.playermenu.R;
import com.xgimi.playermenu.menu.IXgimiPlayerMenuView;
import com.xgimi.playermenu.menu.MenuFactory;
import com.xgimi.playermenu.menu.XgimiPlayerMenuView;

public class MainActivity extends AppCompatActivity {

    private IXgimiPlayerMenuView mMenuView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initMenu();
    }

    private void initView() {
        mMenuView = (IXgimiPlayerMenuView) findViewById(R.id.menu_main);
    }

    private void initMenu() {
        mMenuView.initMainMenu(MenuFactory.getInstance(this).getMainMenuList(), MenuFactory.getInstance(this).getMainMenuAdapter());
    }

    public void mainMenuSeletced(View view) {
        mMenuView.mainMenuSelected();
    }

    public void subMenuSeletced(View view) {
        mMenuView.subMenuSeletced();
    }
}
