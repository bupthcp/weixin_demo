package com.demo.weixin;

import android.os.Bundle;
/**
 * 
 */
import android.view.View;
import android.widget.CheckBox;

/**
 * @author huchenpeng
 *
 */
public class SettingsUI extends MMPreference{
    private View d;
    private CheckBox c;
    private IPreferenceScreen a;
    
    
    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setTitleText(R.string.settings_title);
        a = q();
    }
    
    private void o(){
        a.a();
        a.a(R.xml.settings_pref);
    }
    
    public void onResume()
    {
        super.onResume();
        o();
    }
}
