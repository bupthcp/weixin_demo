/**
 * 
 */
package com.demo.weixin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author huchenpeng
 *
 */
public class AlphabetScrollBar extends View{

    /**
     * @param context
     * @param attrs
     */
    public AlphabetScrollBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        String as[] = new String[29];
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
    }


}
