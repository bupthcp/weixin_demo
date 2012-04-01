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
    
    //set visibility
    public final void b(int j)
    {
        g = j;
    }
    
    public final void a(int j)
    {
        d = j;
    }
    
    public final void a(String s)
    {
        e = s;
    }
    
    public final void a(String s, int j)
    {
        b = s;
        c = j;
    }
    
    public IconPreference(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
        mCtx = (MMActivity)context;
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
        LinearLayout linearlayout;
        TextView textview;
        TextView textview1;
        ImageView imageview = (ImageView)view.findViewById(R.id.image_iv);
        if(imageview != null)
        {
            imageview.setImageDrawable(a);

            byte byte0;
            if(a == null)
                byte0 = 8;
            else
                byte0 = 0;
            imageview.setVisibility(byte0);
        }
        linearlayout = (LinearLayout)view.findViewById(R.id.mm_preference_ll_id);
        textview = (TextView)view.findViewById(R.id.text_tv_one);
        if(textview != null)
        {
            textview.setVisibility(d);
            textview.setText(b);
            if(c != -1){
                textview.setBackgroundResource(c);
//                textview.setBackgroundDrawable(((MMActivity)mCtx).a(c));
            }   
        }
//        textview1 = (TextView)view.findViewById(R.id.text_tv_two);
//        if(textview1 != null)
//        {
//            textview1.setVisibility(g);
//            textview1.setText(e);
//            if(f != -1)
//                textview1.setBackgroundDrawable(i.a(f));
//        }
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
    private int g;
    private int f;
    private int d;
    private String b;
    private int c;
}
