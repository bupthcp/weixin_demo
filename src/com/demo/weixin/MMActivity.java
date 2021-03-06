/**
 * 
 */
package com.demo.weixin;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author huchenpeng
 *
 */
public abstract class MMActivity extends Activity{

    private View mmActivityView;
    private LinearLayout rootView;
    private View mmTitleView;
    
    private static float scale = 1F;
    
    protected abstract int bodyView();
    
    public static float getScale()
    {
        return scale;
    }
    
    public static void setScale(float f1)
    {
        scale = f1;
    }
    
    public final Drawable a(int i1)
    {
        Drawable drawable;
        drawable = getResources().getDrawable(i1);
        return drawable;
    }
    
    protected void setRightButtonText(int resId){
        if(null != mmTitleView){
            MMImageButton rightButton = (MMImageButton)mmTitleView.findViewById(R.id.title_btn1);
            rightButton.setVisibility(View.VISIBLE);
            rightButton.setTextById(resId);
            MMImageButton leftButton = (MMImageButton)mmTitleView.findViewById(R.id.title_btn4);
            leftButton.setVisibility(View.INVISIBLE);
        }
    }
    
    protected void setRightButtonImage(int resId){
        if(null != mmTitleView){
            MMImageButton rightButton = (MMImageButton)mmTitleView.findViewById(R.id.title_btn1);
            rightButton.setImageById(resId);
            rightButton.setVisibility(View.VISIBLE);
            MMImageButton leftButton = (MMImageButton)mmTitleView.findViewById(R.id.title_btn4);
            leftButton.setVisibility(View.INVISIBLE);
        }
    }
    
    protected void setTitleText(int resId){
        if(null != mmTitleView){
            TextView titleView = (TextView)mmTitleView.findViewById(R.id.title);
            titleView.setText(resId);
        }
    }
    
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        MMActivity.setScale((float)Utils.getDip(this, 160F) / 160F);
        LayoutInflater inflater = (LayoutInflater)getSystemService("layout_inflater");
        mmActivityView  = inflater.inflate(R.layout.mm_activity, null);
        rootView = (LinearLayout)mmActivityView.findViewById(R.id.mm_root_view);
        View transLayer = mmActivityView.findViewById(R.id.mm_trans_layer);
        
        mmTitleView = inflater.inflate(R.layout.mm_title, null);
        rootView.addView(mmTitleView, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        rootView.addView(inflater.inflate(bodyView(),null), LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        
        setContentView(mmActivityView);
    }
}
