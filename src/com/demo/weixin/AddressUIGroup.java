/**
 * 
 */
package com.demo.weixin;

import android.content.Intent;
import android.os.Bundle;

/**
 * @author huchenpeng
 *
 */
public class AddressUIGroup extends MMUIGroup{
    public static AddressUIGroup a;
    
    public AddressUIGroup()
    {
    }

    protected final void a()
    {
        Intent intent = new Intent(this, AddressUI.class);
        intent.putExtra("key_group", 2);
        a(intent);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a = this;
    }

    protected void onDestroy()
    {
        super.onDestroy();
        a = null;
    }
}
