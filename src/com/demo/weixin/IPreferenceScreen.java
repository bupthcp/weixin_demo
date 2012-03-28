package com.demo.weixin;
/**
 * 
 */

/**
 * @author huchenpeng
 *
 */
import android.preference.Preference;
import java.util.List;

public interface IPreferenceScreen
{

    public abstract Preference a(String s);

    public abstract void a();

    public abstract void a(int i);

    public abstract void a(Preference preference);

    public abstract List b();

    public abstract boolean b(Preference preference);

    public abstract boolean b(String s);

    public abstract void notifyDataSetChanged();
}
