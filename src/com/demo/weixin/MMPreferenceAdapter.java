package com.demo.weixin;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * 
 */

/**
 * @author huchenpeng
 *
 */
public class MMPreferenceAdapter extends BaseAdapter implements IPreferenceScreen{
    private Context mCtx;
    
    
    public MMPreferenceAdapter(Context context, SharedPreferences sharedpreferences)
    {
        mCtx = context;
        c = new MMPreferenceInflater(context);
    }
    
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return b.size();
    }


    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View view1;
        int i1;
        Preference preference = (Preference)b.get(position);
        view1 = preference.getView(view, parent);
        return view1;
    }

    /* (non-Javadoc)
     * @see android.widget.BaseAdapter#notifyDataSetChanged()
     */
    @Override
    public void notifyDataSetChanged() {
        // TODO Auto-generated method stub
        super.notifyDataSetChanged();
        int l;
        l = 0;
        i = new int[b.size()];
    }

    /* (non-Javadoc)
     * @see com.demo.weixin.IPreferenceScreen#a(java.lang.String)
     */
    @Override
    public final Preference a(String s)
    {
        return (Preference)a.get(s);
    }

    /* (non-Javadoc)
     * @see com.demo.weixin.IPreferenceScreen#a()
     */
    @Override
    public void a() {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see com.demo.weixin.IPreferenceScreen#a(int)
     */
	 //使用MMPreferenceInflater解析xml文件，然后插入到adapter的hashmap中
    @Override
    public void a(int i) {
        // TODO Auto-generated method stub
        c.inflate(i, this);
    }

    /* (non-Javadoc)
     * @see com.demo.weixin.IPreferenceScreen#a(android.preference.Preference)
     */
    @Override
    public void a(Preference preference) {
        b.add(preference);
        a.put(preference.getKey(), preference);
    }

    /* (non-Javadoc)
     * @see com.demo.weixin.IPreferenceScreen#b()
     */
    @Override
    public List b() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.demo.weixin.IPreferenceScreen#b(android.preference.Preference)
     */
    @Override
    public boolean b(Preference preference) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see com.demo.weixin.IPreferenceScreen#b(java.lang.String)
     */
    @Override
    public boolean b(String s) {
        // TODO Auto-generated method stub
        return false;
    }

    
    private final HashMap a = new HashMap();
    private final LinkedList b = new LinkedList();
    private final MMPreferenceInflater c;
    private int i[];
}
