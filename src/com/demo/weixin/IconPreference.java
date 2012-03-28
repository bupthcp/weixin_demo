package com.demo.weixin;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 
 */

/**
 * @author huchenpeng
 *
 */
public class IconPreference extends Preference{
    private Context mCtx;
    
    public final void a(Drawable drawable)
    {
        a = drawable;
    }
    
    public IconPreference(Context context, AttributeSet attributeset, int j)
    {
        super(context, attributeset, j);
        mCtx = context;
        setLayoutResource(R.layout.mm_preference);
        setWidgetLayoutResource(R.layout.mm_preference_submenu);
    }
    
    protected final void onBindView(View view)
    {
        super.onBindView(view);
        ImageView imageview = (ImageView)view.findViewById(R.id.image_iv);
        if(imageview != null)
        {
            imageview.setImageDrawable(a);
            LinearLayout linearlayout;
            TextView textview;
            TextView textview1;
            byte byte0;
            if(a == null)
                byte0 = 8;
            else
                byte0 = 0;
            imageview.setVisibility(byte0);
        }
    }
    
    protected final View onCreateView(ViewGroup viewgroup)
    {
        View view = super.onCreateView(viewgroup);
        ViewGroup viewgroup1 = (ViewGroup)view.findViewById(R.id.content);
        viewgroup1.removeAllViews();
        View.inflate(getContext(), R.layout.mm_preference_content_icon, viewgroup1);
        return view;
    }

    
    private Drawable a;
    private String e;
}
