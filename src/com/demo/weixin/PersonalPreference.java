/**
 * 
 */
package com.demo.weixin;

import android.content.Context;
import android.graphics.Bitmap;
import android.preference.Preference;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author huchenpeng
 *
 */
public class PersonalPreference extends Preference{

    public PersonalPreference(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        i = (MMActivity)context;
    }

    public PersonalPreference(Context context, AttributeSet attributeset, int l)
    {
        super(context, attributeset, l);
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        i = (MMActivity)context;
    }
    
    private TextView a;
    private TextView b;
    private ImageView c;
    private Button d;
    private Bitmap e;
    private String f;
    private String g;
    private String h;
    private MMActivity i;
    
}
