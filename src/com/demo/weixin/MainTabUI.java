package com.demo.weixin;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainTabUI extends TabActivity implements OnClickListener{
    RadioButton main_tab_weixin;
    RadioButton main_tab_address;
    RadioButton main_tab_find_friend;
    RadioButton main_tab_settings;
    
    int currentTab = 0; 
    TabHost tabHost;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_tab);
        main_tab_weixin = (RadioButton)findViewById(R.id.main_tab_weixin);
        main_tab_address = (RadioButton)findViewById(R.id.main_tab_address);
        main_tab_find_friend = (RadioButton)findViewById(R.id.main_tab_find_friend);
        main_tab_settings = (RadioButton)findViewById(R.id.main_tab_settings);
        
        main_tab_weixin.setOnClickListener(this);
        main_tab_address.setOnClickListener(this);
        main_tab_find_friend.setOnClickListener(this);
        main_tab_settings.setOnClickListener(this);
        
        tabHost = getTabHost();
        TabSpec tabspecMainUI;
        TabSpec tabspecAddressUIGroup;
        TabSpec tabspecFindMoreFriendsUI;
        TabSpec tabspecSettingsUI;
        
        Intent intentMainUI = new Intent(this,MainUI.class);
        tabspecMainUI = tabHost.newTabSpec("tab_main").setIndicator("Tab1", getResources().getDrawable(R.drawable.icon)).setContent(intentMainUI);
        tabHost.addTab(tabspecMainUI);
        tabHost.setCurrentTab(currentTab);
        Intent intentAddressUIGroup = new Intent(this, AddressUI.class);
        tabspecAddressUIGroup = tabHost.newTabSpec("tab_address").setIndicator("Tab2", getResources().getDrawable(R.drawable.icon)).setContent(intentAddressUIGroup);
        tabHost.addTab(tabspecAddressUIGroup);
        Intent intentFindMoreFriends = new Intent(this, FindMoreFriendsUI.class);
        tabspecFindMoreFriendsUI = tabHost.newTabSpec("tab_address").setIndicator("Tab3", getResources().getDrawable(R.drawable.icon)).setContent(intentFindMoreFriends);
        tabHost.addTab(tabspecFindMoreFriendsUI);
        Intent intentSettingsUI = new Intent(this, SettingsUI.class);
        tabspecSettingsUI = tabHost.newTabSpec("tab_address").setIndicator("Tab3", getResources().getDrawable(R.drawable.icon)).setContent(intentSettingsUI);
        tabHost.addTab(tabspecSettingsUI);
    }

    /* (non-Javadoc)
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     */
    @Override
    public void onClick(View paramView) {
        // TODO Auto-generated method stub
        if(paramView == main_tab_weixin){
            main_tab_weixin.setChecked(true);
            main_tab_address.setChecked(false);
            main_tab_find_friend.setChecked(false);
            main_tab_settings.setChecked(false);
            currentTab = 0; 
            tabHost.setCurrentTab(currentTab);
        }else if(paramView == main_tab_address){
            main_tab_weixin.setChecked(false);
            main_tab_address.setChecked(true);
            main_tab_find_friend.setChecked(false);
            main_tab_settings.setChecked(false);
            currentTab = 1; 
            tabHost.setCurrentTab(currentTab);
        }else if(paramView == main_tab_find_friend){
            main_tab_weixin.setChecked(false);
            main_tab_address.setChecked(false);
            main_tab_find_friend.setChecked(true);
            main_tab_settings.setChecked(false); 
            currentTab = 2; 
            tabHost.setCurrentTab(currentTab);
        }else if(paramView == main_tab_settings){
            main_tab_weixin.setChecked(false);
            main_tab_address.setChecked(false);
            main_tab_find_friend.setChecked(false);
            main_tab_settings.setChecked(true);
            currentTab = 3; 
            tabHost.setCurrentTab(currentTab);
        }else{
            
        }
    }
}