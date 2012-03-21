/**
 * 
 */
package com.demo.weixin;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * @author huchenpeng
 *
 */
public class Utils {
    
    private static int getPx(Context context, float dip)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        return (int)((dip * (float)displaymetrics.densityDpi) / 160F);
    }
    
    public static int getDip(Context context, float f)
    {
        int i;
        if(Integer.valueOf(android.os.Build.VERSION.SDK).intValue() <= 3)
            i = getPx(context, f);
        else
            i = getPx(context, f);
        return i;
    }
}
