/**
 * 
 */
package com.demo.weixin;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author huchenpeng
 *
 */
public class SwitchKeyValuePreference extends Preference{

    public SwitchKeyValuePreference(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public SwitchKeyValuePreference(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        b = true;
        setLayoutResource(R.layout.mm_preference);
    }
    
    private TextView a;
    private boolean b;
}
