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
        IconPreference iconpreference2;
        IconPreference iconpreference3;
        IconPreference iconpreference4;
        IconPreference iconpreference5;
        IconPreference iconpreference6;
        IconPreference iconpreference7;
        

        iconpreference = (IconPreference)a.a("find_friends_by_qrcode");
        if(iconpreference != null)
        {
            iconpreference.a(a(R.drawable.find_friends_by_qrcode));
            iconpreference.a(View.VISIBLE);
            iconpreference.a((new StringBuilder()).append(" ").append(getString(R.string.app_new)).append(" ").toString(), R.drawable.tab_unread_bg); 
        }
        iconpreference1 = (IconPreference)a.a("find_friends_by_micromsg");
        if(iconpreference1 != null)
        {
            iconpreference1.a(a(R.drawable.find_friends_by_micromsg));
            iconpreference1.a(View.VISIBLE);
        }
        iconpreference2 = (IconPreference)a.a("find_friends_by_qq");
        if(iconpreference2 != null)
        {
            iconpreference2.a(a(R.drawable.find_more_friend_qq_icon));
            iconpreference2.a(View.VISIBLE);
        }
        iconpreference3 = (IconPreference)a.a("find_friends_by_mobile");
        if(iconpreference3 != null)
        {
            iconpreference3.a(a(R.drawable.find_more_friend_mobile_icon));
            iconpreference3.a(View.VISIBLE);
        }
        iconpreference4 = (IconPreference)a.a("find_friends_by_near");
        if(iconpreference4 != null)
        {
            iconpreference4.a(a(R.drawable.find_more_friend_near_icon));
            iconpreference4.a(View.VISIBLE);
        }
        iconpreference5 = (IconPreference)a.a("find_friends_by_shake");
        if(iconpreference5 != null)
        {
            iconpreference5.a(a(R.drawable.find_more_friend_shake));
            iconpreference5.a(View.VISIBLE);
        }
        iconpreference6 = (IconPreference)a.a("voice_bottle");
        if(iconpreference6 != null)
        {
            iconpreference6.a(a(R.drawable.find_more_friend_bottle));
            iconpreference6.a(View.VISIBLE);
        }
        iconpreference7 = (IconPreference)a.a("send_card_to_microblog");
        if(iconpreference7 != null)
        {
            iconpreference7.a(a(R.drawable.send_card_to_microblog));
            iconpreference7.a(View.VISIBLE);
        }
    }
    
    public void onResume()
    {
        super.onResume();
        o();
    }
}
