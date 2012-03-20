package com.demo.weixin;
import com.demo.weixin.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 
 */

/**
 * @author huchenpeng
 *
 */
public class CopyOfConversationAdapter extends BaseAdapter{
    private Context mCtx;
    
    public CopyOfConversationAdapter(Context context)
    {
        super();
        mCtx = context;
    }
    
    /* (non-Javadoc)
     * @see android.widget.Adapter#getCount()
     */
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 1;
    }

    /* (non-Javadoc)
     * @see android.widget.Adapter#getItem(int)
     */
    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see android.widget.Adapter#getItemId(int)
     */
    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
     */
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewholder;

        if(view == null)
        {
            viewholder = new ViewHolder();
            view = View.inflate(mCtx, R.layout.conversation_item, null);//conversation_item
            viewholder.avatar_iv = (ImageView)view.findViewById(R.id.avatar_iv);//avatar_iv
            viewholder.bnickname_tv = (TextView)view.findViewById(R.id.nickname_tv);//nickname_tv
            viewholder.group_count_tv = (TextView)view.findViewById(R.id.group_count_tv);//group_count_tv
            viewholder.usericon_iv = (ImageView)view.findViewById(R.id.usericon_iv);//usericon_iv
            viewholder.update_time_tv = (TextView)view.findViewById(R.id.update_time_tv);//update_time_tv
            viewholder.last_msg_tv = (TextView)view.findViewById(R.id.last_msg_tv);//last_msg_tv
            viewholder.state_iv = (ImageView)view.findViewById(R.id.state_iv);//state_iv
            viewholder.tipcnt_tv = (TextView)view.findViewById(R.id.tipcnt_tv);//tipcnt_tv
            view.setTag(viewholder);
        } else
        {
            viewholder = (ViewHolder)view.getTag();
        }
        return view;
    }

    private class ViewHolder
    {

        public ImageView avatar_iv;
        public TextView bnickname_tv;
        public TextView group_count_tv;
        public ImageView usericon_iv;
        public TextView update_time_tv;
        public TextView last_msg_tv;
        public ImageView state_iv;
        public TextView tipcnt_tv;

        public ViewHolder()
        {
        }
    }
}
