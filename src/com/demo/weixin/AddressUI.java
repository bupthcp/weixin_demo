/**
 * 
 */
package com.demo.weixin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author huchenpeng
 *
 */
public class AddressUI extends MMActivity{

    /* (non-Javadoc)
     * @see com.demo.weixin.MMActivity#bodyView()
     */
    public static int contactNum = 12;
    public static Contact mContacts[]= new Contact[contactNum];
    
    static 
    {
        for(int i=0;i<contactNum;i++){
            mContacts[i]= new Contact();
            mContacts[i].isSuperUser = false;
        }
    }
    
    @Override
    protected int bodyView() {
        // TODO Auto-generated method stub
        return R.layout.address;
    }

    
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setRightButtonText(R.string.address_multi_select_opt);
        setTitleText(R.string.group_weixin);
        View searchBar= View.inflate(this, R.layout.search_bar, null);//search_bar
        EditText edittext = (EditText)searchBar.findViewById(R.id.search_bar_et);//search_bar_et
        TextView emptyText = (TextView)findViewById(R.id.empty_blacklist_tip_tv);
        emptyText.setVisibility(View.GONE);
        
        Button search_clear_bt = (Button)searchBar.findViewById(R.id.search_clear_bt);//search_clear_bt
        edittext.setCompoundDrawablesWithIntrinsicBounds(R.drawable.search_bar_icon_normal, 0, 0, 0);//search_bar_icon_normal
        
        ListView listView = (ListView)findViewById(R.id.address_contactlist);//address_contactlist
        listView.addHeaderView(searchBar);
        listView.setVisibility(View.VISIBLE);
        AddressAdapter adapter = new AddressAdapter(this);
        listView.setAdapter(adapter);
        listView.requestFocus();
        
        mContacts[0].accountName = "好友推荐助手";
        mContacts[0].avatar_iv_path = "avatar/default_friends.png";
        mContacts[0].hasTecentWeibo = false;
        mContacts[0].isSuperUser = true;
        mContacts[0].signature = "";
        mContacts[0].isFirstInGroup = "系统插件";
        mContacts[1].accountName = "群发助手";
        mContacts[1].avatar_iv_path = "avatar/default_masssend.jpg";
        mContacts[1].hasTecentWeibo = false;
        mContacts[1].isSuperUser = true;
        mContacts[1].signature = "";
        mContacts[1].isFirstInGroup = null;
        mContacts[2].accountName = "QQ离线助手";
        mContacts[2].avatar_iv_path = "avatar/default_qq.png";
        mContacts[2].hasTecentWeibo = false;
        mContacts[2].isSuperUser = true;
        mContacts[2].signature = "";
        mContacts[2].isFirstInGroup = null;
        mContacts[3].accountName = "qq邮箱助手";
        mContacts[3].avatar_iv_path = "avatar/default_qqmail.png";
        mContacts[3].hasTecentWeibo = false;
        mContacts[3].isSuperUser = true;
        mContacts[3].signature = "";
        mContacts[3].isFirstInGroup = null;
        mContacts[4].accountName = "爱卿平身";
        mContacts[4].avatar_iv_path = "avatar/default_hd_avatar.png";
        mContacts[4].hasTecentWeibo = false;
        mContacts[4].signature = "";
        mContacts[4].isFirstInGroup = "A";
        mContacts[5].accountName = "Bruce";
        mContacts[5].avatar_iv_path = "avatar/default_hd_avatar.png";
        mContacts[5].hasTecentWeibo = true;
        mContacts[5].signature = "";
        mContacts[5].isFirstInGroup = "B";
        mContacts[6].accountName = "代志成";
        mContacts[6].avatar_iv_path = "avatar/default_hd_avatar.png";
        mContacts[6].hasTecentWeibo = false;
        mContacts[6].signature = "";
        mContacts[6].isFirstInGroup = "D";
        mContacts[7].accountName = "高军";
        mContacts[7].avatar_iv_path = "avatar/default_hd_avatar.png";
        mContacts[7].hasTecentWeibo = true;
        mContacts[7].signature = "日啊，开不起车";
        mContacts[7].isFirstInGroup = "G";
        mContacts[8].accountName = "高明";
        mContacts[8].avatar_iv_path = "avatar/default_hd_avatar.png";
        mContacts[8].hasTecentWeibo = false;
        mContacts[8].signature = "";
        mContacts[8].isFirstInGroup = null;
        mContacts[9].accountName = "刘工";
        mContacts[9].avatar_iv_path = "avatar/default_hd_avatar.png";
        mContacts[9].hasTecentWeibo = false;
        mContacts[9].signature = "";
        mContacts[9].isFirstInGroup = "L";
        mContacts[10].accountName = "陆工";
        mContacts[10].avatar_iv_path = "avatar/default_hd_avatar.png";
        mContacts[10].hasTecentWeibo = false;
        mContacts[10].signature = "落花无言，人淡如菊";
        mContacts[10].isFirstInGroup = null;
        mContacts[11].accountName = "李工";
        mContacts[11].avatar_iv_path = "avatar/default_hd_avatar.png";
        mContacts[11].hasTecentWeibo = false;
        mContacts[11].signature = "你幸福不";
        mContacts[11].isFirstInGroup = null;
    }
}
