/**
 * 
 */
package com.demo.weixin;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

/**
 * @author huchenpeng
 *
 */
public class FindMoreFriendsUI extends MMPreference{

    private View d;
    private CheckBox c;
    private IPreferenceScreen a;
    
    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setTitleText(R.string.find_more_friends_title);
    }
    
    private void o(){
        a.a();
        a.a(R.xml.find_more_friends);
    }
    
    public void onResume()
    {
        super.onResume();
        o();
    }
}
