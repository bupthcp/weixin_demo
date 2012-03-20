/**
 * 
 */
package com.demo.weixin;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author huchenpeng
 *
 */
public class MainUI extends MMActivity{

    private ListView mainChattingLv;
    private TextView emptyConversationTv;
    
    public static int Count = 3; 
    
    
    @Override
    protected int bodyView() {
        // it is a abstract class in MMActivity
        // different view will use different layout xml file to show the body view
        return R.layout.main;
    }
    
    private void showEmptyOrList(int count){
        if(count>0){
            mainChattingLv.setVisibility(View.VISIBLE);
            emptyConversationTv.setVisibility(View.GONE);
        }else{
            mainChattingLv.setVisibility(View.GONE);
            emptyConversationTv.setVisibility(View.VISIBLE);
        }
    }
    
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setRightButtonImage(R.drawable.mm_title_btn_compose_normal);
        mainChattingLv = (ListView)findViewById(R.id.main_chatting_lv);
        emptyConversationTv = (TextView)findViewById(R.id.empty_conversation_tv);
        showEmptyOrList(Count);
        ConversationAdapter adapter = new ConversationAdapter(this);
        mainChattingLv.setAdapter(adapter);
        mainChattingLv.requestFocus();
    }

}
