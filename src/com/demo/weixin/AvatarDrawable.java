package com.demo.weixin;
import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

/**
 * 
 */

/**
 * @author huchenpeng
 *
 */
public class AvatarDrawable extends BitmapDrawable{

    private ImageView iv;
    private static final Paint paint;
    
    static 
    {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
    }
    
    public AvatarDrawable(ImageView imageview,Bitmap bitmap)
    {
        super(imageview.getResources(), bitmap);
        iv = imageview;
    }
    
    public static Bitmap a(int width, int height, String avatarPath, Context context)
    {
        AssetManager am = context.getAssets();
        InputStream inStream = null;
        Bitmap bitmap = null;
        try{
            if(null == avatarPath){
                inStream = am.open("avatar/default_nor_avatar.png");
            }else{
                inStream = am.open(avatarPath);
            }
            bitmap = BitmapFactory.decodeStream(inStream);
            if(bitmap.getWidth()!=width){
                bitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return bitmap;
    }
    
    /* (non-Javadoc)
     * @see android.graphics.drawable.BitmapDrawable#draw(android.graphics.Canvas)
     */
    @Override
    public void draw(Canvas canvas) {        
        Bitmap bitmap;
        android.graphics.Rect rect;
        rect = getBounds();
        canvas.drawRoundRect(new RectF(rect), 10F, 10F, paint);
        canvas.drawBitmap(this.getBitmap(), null, rect, paint);
    }

}
