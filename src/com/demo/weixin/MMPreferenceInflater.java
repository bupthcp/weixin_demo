/**
 * 
 */
package com.demo.weixin;

import org.xmlpull.v1.XmlPullParser;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;

/**
 * @author huchenpeng
 *
 */
 //这个类负责将find_more_friends.xml这类xml文件解析成出来
 //构造preference，然后调用MMPreferenceAdapter中的a(Preference preference)
 //将preference 添加到hashmap和linkedlist中去
public class MMPreferenceInflater {
    public MMPreferenceInflater(Context context)
    {
        b = context;
    }
    
    public final void a(int i, IPreferenceScreen ipreferencescreen)
    {
        XmlResourceParser xmlresourceparser = b.getResources().getXml(i);
        AttributeSet attributeset = Xml.asAttributeSet(xmlresourceparser);
        try{
            for(int j=0; (j != XmlPullParser.START_TAG) && (j != XmlPullParser.END_DOCUMENT); j = xmlresourceparser.next()){
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        xmlresourceparser.close();
    }
    
    private final Context b;
}
