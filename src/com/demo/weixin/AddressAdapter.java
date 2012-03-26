/**
 * 
 */
package com.demo.weixin;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author huchenpeng
 *
 */
public class AddressAdapter extends BaseAdapter{

    private Context mCtx;
    private ColorStateList textcolor_one;
    private ColorStateList textcolor_spuser;
    
    public AddressAdapter(Context context)
    {
        super();
        mCtx = context;
        android.content.res.XmlResourceParser xmlresourceparser = context.getResources().getXml(R.color.mm_list_textcolor_one);
        android.content.res.XmlResourceParser xmlresourceparser1 = context.getResources().getXml(R.color.mm_list_textcolor_spuser);
        try{
            textcolor_one = ColorStateList.createFromXml(context.getResources(), xmlresourceparser);
            textcolor_spuser = ColorStateList.createFromXml(context.getResources(), xmlresourceparser1);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return AddressUI.contactNum;
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
            view = View.inflate(mCtx, R.layout.contact_item, null); //contact_item
            viewholder = new ViewHolder();
            viewholder.contactitem_catalog = (TextView)view.findViewById(R.id.contactitem_catalog);//contactitem_catalog
            viewholder.contactitem_avatar_iv = (ImageView)view.findViewById(R.id.contactitem_avatar_iv);//contactitem_avatar_iv
            viewholder.contactitem_nick = (TextView)view.findViewById(R.id.contactitem_nick);//contactitem_nick
            viewholder.contactitem_icon = (ImageView)view.findViewById(R.id.contactitem_icon);//contactitem_icon
            viewholder.contactitem_select_cb = (CheckBox)view.findViewById(R.id.contactitem_select_cb);//contactitem_select_cb
            viewholder.contactitem_account = (TextView)view.findViewById(R.id.contactitem_account);//contactitem_account
            viewholder.contactitem_signature = (TextView)view.findViewById(R.id.contactitem_signature);//contactitem_signature
            view.setTag(viewholder);
        } else
        {
            viewholder = (ViewHolder)view.getTag();
        }

        viewholder.contactitem_account.setVisibility(View.GONE);
        viewholder.contactitem_select_cb.setVisibility(View.GONE);
        if(AddressUI.mContacts[position].signature.equals("")){
            viewholder.contactitem_signature.setVisibility(View.GONE);
        }else{
            viewholder.contactitem_signature.setText(AddressUI.mContacts[position].signature);
            viewholder.contactitem_signature.setVisibility(View.VISIBLE);
        }
        if(AddressUI.mContacts[position].isFirstInGroup == null){
            viewholder.contactitem_catalog.setVisibility(View.GONE);
        }else{
            viewholder.contactitem_catalog.setVisibility(View.VISIBLE);
            viewholder.contactitem_catalog.setText(AddressUI.mContacts[position].isFirstInGroup);
        }
        if(AddressUI.mContacts[position].hasTecentWeibo == true){
            viewholder.contactitem_icon.setVisibility(View.VISIBLE);
            viewholder.contactitem_icon.setImageResource(R.drawable.icon_tencent_weibo);
        }else{
            viewholder.contactitem_icon.setVisibility(View.GONE);
        }
        viewholder.contactitem_nick.setText(AddressUI.mContacts[position].accountName);
        if(AddressUI.mContacts[position].isSuperUser){
            viewholder.contactitem_nick.setTextColor(textcolor_spuser);
        }else{
            viewholder.contactitem_nick.setTextColor(textcolor_one);
        }
        Bitmap bitmap = AvatarDrawable.a(AvatarDrawable.getScaledPx(),AvatarDrawable.getScaledPx(),AddressUI.mContacts[position].avatar_iv_path,mCtx);
        viewholder.contactitem_avatar_iv.setImageDrawable(new AvatarDrawable(viewholder.contactitem_avatar_iv,bitmap));
        return view;
    }
    
    private class ViewHolder
    {

        ImageView contactitem_avatar_iv;
        TextView contactitem_catalog;
        TextView contactitem_nick;
        TextView contactitem_account;
        TextView contactitem_signature;
        ImageView contactitem_icon;
        CheckBox contactitem_select_cb;
        
        ViewHolder()
        {
        }
    }

}
