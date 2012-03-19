// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.demo.weixin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;

// Referenced classes of package com.tencent.mm.ui:
//            MMActivity

public class MMImageButton extends LinearLayout
{

    public MMImageButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ctx = (MMActivity)context;
        View view = LayoutInflater.from(ctx).inflate(R.layout.image_button, this, true);
        titleImage = (ImageView)view.findViewById(R.id.title_btn_iv);
        titleText = (TextView)view.findViewById(R.id.title_btn_tv);
    }

    public final void a(int i)
    {
        titleImage.setImageDrawable(ctx.a(i));
        titleImage.setVisibility(VISIBLE);
        titleText.setVisibility(GONE);
    }

    public final void a(String s)
    {
        titleText.setText(s);
        titleText.setVisibility(VISIBLE);
        titleImage.setVisibility(GONE);
    }

    public final void b(int i)
    {
        titleText.setText(i);
        titleText.setVisibility(VISIBLE);
        titleImage.setVisibility(GONE);
    }

    public void setEnabled(boolean flag)
    {
        super.setEnabled(flag);
        titleText.setEnabled(flag);
        titleImage.setEnabled(flag);
    }

    private TextView titleText;
    private ImageView titleImage;
    private MMActivity ctx;
}
