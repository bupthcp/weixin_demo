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
        a = q();
    }
    
    private void o(){
        a.a();
        a.a(R.xml.find_more_friends);
        
        IconPreference iconpreference;
        IconPreference iconpreference1;
        IconPreference iconpreference3;
        IconPreference iconpreference5;
        IconPreference iconpreference6;
        IconPreference iconpreference8;
        IconPreference iconpreference2;
        IconPreference iconpreference4;
        IconPreference iconpreference7;
        IconPreference iconpreference9;
        
        iconpreference = (IconPreference)a.a("find_friends_by_near");
        if(iconpreference != null)
        {
                iconpreference.b(View.VISIBLE);
                iconpreference.a("");
                iconpreference.a(a(R.drawable.find_more_friend_near_icon));  
        }
    }
    
    public void onResume()
    {
        super.onResume();
        o();
    }
}
