/**
 * 
 */
package com.demo.weixin;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.preference.Preference;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import android.preference.PreferenceActivity;
import android.preference.PreferenceActivity.Header;


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
        mContext = context;
    }
    
    public final void inflate(int resource, IPreferenceScreen ipreferencescreen) {
        XmlResourceParser parser = mContext.getResources().getXml(resource);
        final AttributeSet attrs = Xml.asAttributeSet(parser);
        mConstructorArgs[0] = mContext;
        
        try {
            // Look for the root node.
            int type;
            while ((type = parser.next()) != parser.START_TAG
                    && type != parser.END_DOCUMENT) {
                ;
            }

            if (type != parser.START_TAG) {
                throw new InflateException(parser.getPositionDescription()
                        + ": No start tag found!");
            }

            if (DEBUG) {
                System.out.println("**************************");
                System.out.println("Creating root: "
                        + parser.getName());
                System.out.println("**************************");
            }
            // Temp is the root that was found in the xml
            Preference xmlRoot = createItemFromTag(parser, parser.getName(),
                    attrs);

            
            if (DEBUG) {
                System.out.println("-----> start inflating children");
            }
            // Inflate all children under temp
            rInflate(parser, ipreferencescreen, attrs);
            if (DEBUG) {
                System.out.println("-----> done inflating children");
            }

        } catch (InflateException e) {
            throw e;

        } catch (XmlPullParserException e) {
            InflateException ex = new InflateException(e.getMessage());
            ex.initCause(e);
            throw ex;
        } catch (IOException e) {
            InflateException ex = new InflateException(
                    parser.getPositionDescription()
                    + ": " + e.getMessage());
            ex.initCause(e);
            throw ex;
        }

        
    }
    
    
    private void rInflate(XmlPullParser parser, IPreferenceScreen parent, final AttributeSet attrs)
            throws XmlPullParserException, IOException {
        final int depth = parser.getDepth();

        int type;
        while (((type = parser.next()) != parser.END_TAG || 
                parser.getDepth() > depth) && type != parser.END_DOCUMENT) {

            if (type != parser.START_TAG) {
                continue;
            }

            if (DEBUG) {
                System.out.println("Now inflating tag: " + parser.getName());
            }
            String name = parser.getName();

            Preference item = createItemFromTag(parser, name, attrs);

            if (DEBUG) {
                System.out
                        .println("Creating params from parent: " + parent);
            }

            parent.a(item);

        }

    }
    
    
    private final Preference createItemFromTag(XmlPullParser parser, String name, AttributeSet attrs) {
        if (DEBUG) System.out.println("******** Creating item: " + name);

        try {
            Preference item ;
                if (-1 == name.indexOf('.')) {
                    item = createItem(name, "android.preference.",attrs);
                } else {
                    item = createItem(name, null, attrs);
                }

            if (DEBUG) System.out.println("Created item is: " + item);
            return item;

        } catch (InflateException e) {
            throw e;

        } catch (ClassNotFoundException e) {
            InflateException ie = new InflateException(attrs
                    .getPositionDescription()
                    + ": Error inflating class " + name);
            ie.initCause(e);
            throw ie;

        } catch (Exception e) {
            InflateException ie = new InflateException(attrs
                    .getPositionDescription()
                    + ": Error inflating class " + name);
            ie.initCause(e);
            throw ie;
        }
    }
    
    
    public final Preference createItem(String name, String prefix, AttributeSet attrs)
            throws ClassNotFoundException, InflateException {
        Constructor constructor = (Constructor) sConstructorMap.get(name);

        try {
            if (null == constructor) {
                // Class not found in the cache, see if it's real,
                // and try to add it
                Class clazz = mContext.getClassLoader().loadClass(
                        prefix != null ? (prefix + name) : name);
                constructor = clazz.getConstructor(mConstructorSignature);
                sConstructorMap.put(name, constructor);
            }

            Object[] args = mConstructorArgs;
            args[1] = attrs;
            return (Preference) constructor.newInstance(args);

        } catch (NoSuchMethodException e) {
            InflateException ie = new InflateException(attrs
                    .getPositionDescription()
                    + ": Error inflating class "
                    + (prefix != null ? (prefix + name) : name));
            ie.initCause(e);
            throw ie;

        } catch (ClassNotFoundException e) {
            // If loadClass fails, we should propagate the exception.
            throw e;
        } catch (Exception e) {
            InflateException ie = new InflateException(attrs
                    .getPositionDescription()
                    + ": Error inflating class "
                    + constructor.getClass().getName());
            ie.initCause(e);
            throw ie;
        }
    }
    

    private final boolean DEBUG = true;
    private final Context mContext;
    private final Object[] mConstructorArgs = new Object[2];

    private static final Class[] mConstructorSignature = new Class[] {
            Context.class, AttributeSet.class};

    private static final HashMap sConstructorMap = new HashMap();
}
