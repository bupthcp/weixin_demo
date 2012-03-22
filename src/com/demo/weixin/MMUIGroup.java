/**
 * 
 */
package com.demo.weixin;

import java.util.ArrayList;
import java.util.List;

import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * @author huchenpeng
 *
 */
public abstract class MMUIGroup extends ActivityGroup{
    public MMUIGroup()
    {
    }
    
    protected abstract void a();
    
    public final void a(Intent intent)
    {
        Log.e("MMUIGroup", (new StringBuilder()).append("component name: ").append(intent.getComponent().toString()).toString());
        if((0x4000000 & intent.getFlags()) != 0)
            b(intent);
        else
            c(intent);
    }
    
    private void b(Intent intent){
        
    }
    
    private void c(Intent intent){
        
    }
    
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a = new ArrayList();
        b = getLocalActivityManager();
        a();
    }
    
    private List a;
    private LocalActivityManager b;
}
