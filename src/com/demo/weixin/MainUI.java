/**
 * 
 */
package com.demo.weixin;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Paint;
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
    
    public static int Count = 8; 
    public static Conversation[] mConversation= new Conversation[Count];
    
    static 
    {
        for(int i=0;i<Count;i++){
            mConversation[i]= new Conversation();
        }
    }
    
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
        mConversation[0].avatar_iv_path = "avatar/default_facebook.jpg";
        mConversation[0].bnickname = "facebook助手";
        mConversation[0].last_msg = "您的好友Tom有了更新";
        mConversation[0].update_time = "早上08:30";
        mConversation[1].avatar_iv_path = "avatar/default_friends.png";
        mConversation[1].bnickname = "好友推荐助手";
        mConversation[1].last_msg = "李强加入了微信";
        mConversation[1].update_time = "2月8日";
        mConversation[2].avatar_iv_path = "avatar/default_hd_avatar.png";
        mConversation[2].bnickname = "windwalker";
        mConversation[2].last_msg = "最近在干啥哪？";
        mConversation[2].update_time = "早上09:20";
        mConversation[3].avatar_iv_path = "avatar/default_masssend.jpg";
        mConversation[3].bnickname = "群发助手";
        mConversation[3].last_msg = "可以帮助您发送消息给多个好友";
        mConversation[3].update_time = "周二早上";
        mConversation[4].avatar_iv_path = "avatar/default_qqsync.jpg";
        mConversation[4].bnickname = "通讯录安全助手";
        mConversation[4].last_msg = "最近一次备份：2012年3月19日。";
        mConversation[4].update_time = "周一早上";
        mConversation[5].avatar_iv_path = "avatar/default_qqmail.png";
        mConversation[5].bnickname = "QQ邮箱助手";
        mConversation[5].last_msg = "2012年3月1日8时37分43秒：【快讯好消息";
        mConversation[5].update_time = "3月1日";
        mConversation[6].avatar_iv_path = "avatar/default_readerapp_weibo.jpg";
        mConversation[6].bnickname = "微博推荐";
        mConversation[6].last_msg = "多收听高质量的微博，每天收到精彩的推荐";
        mConversation[6].update_time = "3月22日";   
        mConversation[7].avatar_iv_path = "avatar/default_qq.png";
        mConversation[7].bnickname = "qq离线助手";
        mConversation[7].last_msg = "李强：好久没联系啊，最近咋样？";
        mConversation[7].update_time = "3月22日";  
    }
}
