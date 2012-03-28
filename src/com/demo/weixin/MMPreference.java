/**
 * 
 */
package com.demo.weixin;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;

/**
 * @author huchenpeng
 *
 */
public abstract class MMPreference extends MMActivity{
    private MMPreferenceAdapter a;
    private ListView b;
    private SharedPreferences c;
    private boolean d;
    
    protected int bodyView()
    {
        return R.layout.mm_preference_list_content;
    }
    
    public final IPreferenceScreen q()
    {
        return a;
    }
    
    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        c = getSharedPreferences((new StringBuilder()).append(getPackageName()).append("_preferences").toString(), 0);
        a = new MMPreferenceAdapter(this, c);
        b = (ListView)findViewById(android.R.id.list);
        b.setAdapter(a);
    }
}
