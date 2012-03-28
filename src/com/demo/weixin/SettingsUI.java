package com.demo.weixin;

import android.os.Bundle;
/**
 * 
 */

/**
 * @author huchenpeng
 *
 */
public class SettingsUI extends MMPreference{
    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setTitleText(R.string.settings_title);
    }
}
