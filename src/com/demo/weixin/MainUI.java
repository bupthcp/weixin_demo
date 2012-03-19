/**
 * 
 */
package com.demo.weixin;

import android.app.Activity;
import android.os.Bundle;

/**
 * @author huchenpeng
 *
 */
public class MainUI extends MMActivity{

    @Override
    protected int bodyView() {
        // TODO Auto-generated method stub
        return R.layout.main;
    }
    
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setRightButtonImage(R.drawable.mm_title_btn_compose_normal);
    }

}
