package com.demo.weixin;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
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
//        view1.setBackgroundDrawable(((MMActivity)mCtx).a(R.drawable.preference_item));

        if(i[position] == FIRST){
            view1.setBackgroundResource(R.drawable.preference_first_item);
        }
        else if(i[position] == MIDDLE){
            view1.setBackgroundResource(R.drawable.preference_item);
        }
        else if(i[position] == LAST){
            view1.setBackgroundResource(R.drawable.preference_last_item);
        }else if(i[position] == SINGLE){
            view1.setBackgroundResource(R.drawable.preference_single_item);
        }else if(i[position] == DIVIDER){
            //we can not use setAlpha here . setAlpha is not supported before SDK 11
            view1.setBackgroundDrawable(null);
        }
        return view1;
    }

    /* it is used to write data to shared preference
     */
    @Override
    public void notifyDataSetChanged() {
        // TODO Auto-generated method stub
        super.notifyDataSetChanged();
        int  l = 0;
        i = new int[b.size()];
        if(i.length<=0){
            return;
        }
		//第一个0x000
        //中间的0x010
		//最后的0x001
		//单独的0x011
		//分隔符0x100
        while(l < b.size()) 
        {
            if(b.get(l) instanceof PreferenceCategory){
                i[l] = DIVIDER;
            }else{
                if(l==0){
                    i[l] = DIVIDER;
                    l++;
                    continue;
                }else if(l == (b.size()-1)){
                    if(b.get(l-1) instanceof PreferenceCategory){
                        i[l] = SINGLE;
                    }else{
                        i[l] = LAST;
                    }
                    l++;
                    continue;
                }
                if( (b.get(l-1) instanceof PreferenceCategory) && (b.get(l+1) instanceof PreferenceCategory)){
                    i[l] = SINGLE;
                }else if((b.get(l-1) instanceof PreferenceCategory) && !(b.get(l+1) instanceof PreferenceCategory)){
                    i[l] = FIRST;
                }else if(!(b.get(l-1) instanceof PreferenceCategory) && (b.get(l+1) instanceof PreferenceCategory)){
                    i[l] = LAST;
                }else{
                    i[l] = MIDDLE;
                }
            }
//            if(i.length == 1)
//            {
//                if(((Preference)b.get(l)).getLayoutResource() == R.layout.mm_preference)//mm_preference
//                    i[l] = 0x011;
//                else
//                    i[l] = 0x100;
//                a((Preference)b.get(l), g);
//                break;
//            }
//            a((Preference)b.get(l), g);
//            if(((Preference)b.get(l)).getLayoutResource() == R.layout.mm_preference)
//            {   
//                if(l == 0)
//                {
//                    i[l] = 0x000;
//                }else if(l == (b.size()-1)){
//                    if(((Preference)b.get(l-1)).getLayoutResource() != R.layout.mm_preference)
//                    {
//                        i[l] = 0x011;
//                    }else{
//                        i[l] = 0x001;
//                    }
//                }
//                else
//                {
//                    if(((Preference)b.get(l-1)).getLayoutResource() != R.layout.mm_preference)
//                    {
//                        i[l] = 0x000;
//                    }else{
//                        i[l] = 0x010;
//                    }
//                }
//            } else
//            {
//                i[l] = 0x100;
//                if(l != 0 && ((Preference)b.get(l-1)).getLayoutResource() == R.layout.mm_preference)
//                {
//                    i[l-1] = 0x001;
//                }
//            }
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
    private static int FIRST = 1;
    private static int MIDDLE = 2;
    private static int LAST = 3;
    private static int SINGLE = 4 ;
    private static int DIVIDER =5;
}
