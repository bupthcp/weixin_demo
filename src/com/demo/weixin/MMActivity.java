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

/**
 * @author huchenpeng
 *
 */
public abstract class MMActivity extends Activity{

    protected abstract int bodyView();
    
    public final Drawable a(int i1)
    {
        Drawable drawable;
        drawable = getResources().getDrawable(i1);
        return drawable;
    }
    
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        LayoutInflater inflater = (LayoutInflater)getSystemService("layout_inflater");
        View mmActivityView = inflater.inflate(R.layout.mm_activity, null);
        LinearLayout rootView = (LinearLayout)mmActivityView.findViewById(R.id.mm_root_view);
        View transLayer = mmActivityView.findViewById(R.id.mm_trans_layer);
        
        View mmTitleView = inflater.inflate(R.layout.mm_title, null);
        rootView.addView(mmTitleView, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        rootView.addView(inflater.inflate(bodyView(),null), LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        
        setContentView(mmActivityView);
    }
}
