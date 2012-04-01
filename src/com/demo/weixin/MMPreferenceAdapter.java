package com.demo.weixin;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.util.Log;
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
    private String TAG;
    
    public MMPreferenceAdapter(Context context, SharedPreferences sharedpreferences)
    {
        mCtx = context;
        c = new MMPreferenceInflater(context);
        g = sharedpreferences;
        j = false;
        k = false;
    }
    
    private static void a(Preference preference, SharedPreferences sharedpreferences)
    {
        if(preference instanceof CheckBoxPreference)
        {
            CheckBoxPreference checkboxpreference = (CheckBoxPreference)preference;
            if(checkboxpreference.isPersistent())
                checkboxpreference.setChecked(sharedpreferences.getBoolean(preference.getKey(), ((CheckBoxPreference)preference).isChecked()));
        }
    }
    
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return b.size();
    }


    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return b.get(position);
    }


    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int getItemViewType(int l)
    {
        Preference preference = (Preference)b.get(l);
        Integer integer = (Integer)d.get(c(preference));
        int i1;
        if(integer == null)
            i1 = -1;
        else
            i1 = integer.intValue();
        return i1;
    }
    
    @Override
    public int getViewTypeCount()
    {
        if(!k)
            k = true;
        return Math.max(1, d.size());
    }

    
    private static String c(Preference preference)
    {
        return (new StringBuilder()).append(preference.getClass().getName()).append("L").append(preference.getLayoutResource()).append("W").append(preference.getWidgetLayoutResource()).toString();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View view1;
        int i1;
        Preference preference = (Preference)b.get(position);
        view1 = preference.getView(view, parent);
//        if(preference.getLayoutResource() != R.layout.mm_preference){
////            view1.setAlpha(0);
//            view1 = preference.getView(null, parent);
//            return view1;
//        }
//        if(i[position] == 1){
//            view1.setBackgroundResource(R.drawable.preference_first_item);
//        }
//        else if(i[position] == 2){
//            view1.setBackgroundResource(R.drawable.preference_last_item);
//        }
//        else if(i[position] == 0){
//            view1.setBackgroundResource(R.drawable.preference_item);
//        }
        return view1;
    }

    /* it is used to write data to shared preference
     */
    @Override
    public void notifyDataSetChanged() {
        // TODO Auto-generated method stub
        super.notifyDataSetChanged();
        int l;
        l = 0;
        i = new int[b.size()];
        if(i.length<=0){
            return;
        }
        while(l < b.size()) 
        {
            if(i.length == 1)
            {
                if(((Preference)b.get(l)).getLayoutResource() == R.layout.mm_preference)//mm_preference
                    i[l] = 3;
                else
                    i[l] = 4;
                a((Preference)b.get(l), g);
                continue; /* Loop/switch isn't completed */
            }
            a((Preference)b.get(l), g);
            if(((Preference)b.get(l)).getLayoutResource() == R.layout.mm_preference)
            {
                if(l == 0)
                {
                    int ai4[] = i;
                    ai4[l] = 1 | ai4[l];
                } else
                {
                    if(l == -1 + b.size())
                    {
                        int ai3[] = i;
                        ai3[l] = 2 | ai3[l];
                    }
                    if(((Preference)b.get(l + -1)).getLayoutResource() != R.layout.mm_preference)
                    {
                        int ai2[] = i;
                        ai2[l] = 1 | ai2[l];
                    }
                }
            } else
            {
                int ai[] = i;
                ai[l] = 4 | ai[l];
                if(l != 0 && ((Preference)b.get(l + -1)).getLayoutResource() == R.layout.mm_preference)
                {
                    int ai1[] = i;
                    int i1 = l + -1;
                    ai1[i1] = 2 | ai1[i1];
                }
            }
            l++;
        }
        Log.i(TAG, "on data set changed");
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
        b.clear();
        a.clear();
        notifyDataSetChanged();
        
    }

    /* (non-Javadoc)
     * @see com.demo.weixin.IPreferenceScreen#a(int)
     */
	 //使用MMPreferenceInflater解析xml文件，然后插入到adapter的hashmap中
    @Override
    public void a(int i) {
        // TODO Auto-generated method stub
        c.inflate(i, this);
        notifyDataSetChanged();
    }
    
    

    /* (non-Javadoc)
     * @see com.demo.weixin.IPreferenceScreen#a(android.preference.Preference)
     */
    @Override
    public void a(Preference preference) {
        b.add(preference);
        a.put(preference.getKey(), preference);
        if(!d.containsKey(c(preference)))
            d.put(c(preference), Integer.valueOf(d.size()));
        if(preference.getDependency() != null)
            e.put((new StringBuilder()).append(preference.getDependency()).append("|").append(preference.getKey()).toString(), preference.getKey());
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
    private final HashMap d = new HashMap();
    private final HashMap e = new HashMap();
    private final MMPreferenceInflater c;
    private int i[];
    private final SharedPreferences g;
    private boolean j;
    private boolean k;
}
