/**
 * 
 */
package com.demo.weixin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * @author huchenpeng
 *
 */
public class AlphabetScrollBar extends View{

    private Context mCtx;
    private PopupWindow popupWindow;
    private TextView headTostText;
    private Bitmap searchIcon;
    private int popupWindowWidth;
    private int marginTop;
    float e;
    String as[]= new String[29];
    private OnScollBarTouchListener j;
    /**
     * @param context
     * @param attrs
     */
    public AlphabetScrollBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        as[0] = "!";
        as[1] = "+";
        as[2] = "A";
        as[3] = "B";
        as[4] = "C";
        as[5] = "D";
        as[6] = "E";
        as[7] = "F";
        as[8] = "G";
        as[9] = "H";
        as[10] = "I";
        as[11] = "J";
        as[12] = "K";
        as[13] = "L";
        as[14] = "M";
        as[15] = "N";
        as[16] = "O";
        as[17] = "P";
        as[18] = "Q";
        as[19] = "R";
        as[20] = "S";
        as[21] = "T";
        as[22] = "U";
        as[23] = "V";
        as[24] = "W";
        as[25] = "X";
        as[26] = "Y";
        as[27] = "Z";
        as[28] = "#";

        setFocusable(true);
        setFocusableInTouchMode(true);
        mCtx = context;
        marginTop = Utils.getDip(context, 3F);
        popupWindowWidth = Utils.getDip(context, 79F);
        View view = inflate(context, R.layout.show_head_toast, null);
        headTostText = (TextView)view.findViewById(R.id.show_head_toast_text);
        popupWindow = new PopupWindow(view,popupWindowWidth,popupWindowWidth);
        searchIcon = BitmapFactory.decodeStream(getResources().openRawResource(R.drawable.scroll_bar_search_icon));//scroll_bar_search_icon
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int scrollBarHeight = getMeasuredHeight();
        int scrollBarWidth = getMeasuredWidth();
        e = (float)(scrollBarHeight - searchIcon.getHeight() - marginTop) / (1.2F * (float)as.length);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(0xff858c94);
        paint.setTextAlign(android.graphics.Paint.Align.CENTER);
        paint.setTextSize(e);
        canvas.drawBitmap(searchIcon, (float)(scrollBarWidth - searchIcon.getWidth()) / 2F, marginTop, paint);
        for(int i1 = 0; i1 < as.length; i1++)
            canvas.drawText(as[i1], (float)scrollBarWidth / 2F, e + 1.2F * ((float)i1 * e) + (float)searchIcon.getHeight() + (float)marginTop, paint);
    }
    
    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if(motionevent.getAction() == MotionEvent.ACTION_DOWN || motionevent.getAction() == MotionEvent.ACTION_MOVE)
        {
            float f = motionevent.getY();
            if(f < 0F)
                f = 0F;
            if(f > (float)getMeasuredHeight())
                f = getMeasuredHeight();
            setBackgroundDrawable(getResources().getDrawable(R.drawable.scrollbar_bg));//scrollbar_bg
            float f1 = f;
            float f2 = 1.2F * e;
            int k;
            if(f1 < (float)(searchIcon.getHeight() + marginTop))
            {
                k = -1;
            } else
            {
                k = (int)(((f1 - (float)searchIcon.getHeight()) + (float)marginTop) / f2);
                if(k < 0)
                    k = 0;
                if(k >= as.length)
                    k = -1 + as.length;
            }
            int d = k;
            if(d == -1)
                headTostText.setText(R.string.scroll_bar_search);
            else
                headTostText.setText(as[d]);
            popupWindow.showAtLocation(this, 17, 0, 0);
            if(j != null)
                if(d == -1){
                    j.a(mCtx.getString(R.string.scroll_bar_search));
                }
                else{
                    j.a(as[d]);
                }
        }
        if(motionevent.getAction() == MotionEvent.ACTION_UP)
        {
            setBackgroundResource(0);
            popupWindow.dismiss();
        }
        return true;
    }
    
    public final void a(OnScollBarTouchListener onscollbartouchlistener)
    {
        j = onscollbartouchlistener;
    }
    
    public abstract interface OnScollBarTouchListener
    {
        public abstract void a(String s);
    }
}
