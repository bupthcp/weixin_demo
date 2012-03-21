package com.demo.weixin;
import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
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
    
    public static int getScaledPx()
    {
        return (int)(52F * MMActivity.getScale());
    }
    
    
    public static Bitmap decode(InputStream inputstream, float f)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inDensity = (int)(160F * f);
        options.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
        return BitmapFactory.decodeStream(inputstream, null, options);
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
            bitmap = decode(inStream,MMActivity.getScale());
            if(bitmap.getWidth()!=width){
                bitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
                bitmap = getRoundedCornerBitmap(bitmap);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return bitmap;
    }
    
    /* (non-Javadoc)
     * @see android.graphics.drawable.BitmapDrawable#draw(android.graphics.Canvas)
     */
//    @Override
//    public void draw(Canvas canvas) {        
//        Bitmap bitmap = getBitmap();
//        android.graphics.Rect rect;
//        //rect = getBounds();
//        rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()); 
//        final Paint paint = new Paint(); 
//        paint.setAntiAlias(true); 
//        canvas.drawRoundRect(new RectF(rect), 6F, 6F, paint);
//        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
//        canvas.drawBitmap(bitmap, rect, rect, paint);
//
//        //canvas.drawBitmap(getRoundedCornerBitmap(this.getBitmap()), rect, rect, paint);
//    }
    
    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap) { 
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), 
            bitmap.getHeight(), Config.ARGB_8888); 
        Canvas canvas = new Canvas(output); 


        final Paint paint = new Paint(); 
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()); 
        final RectF rectF = new RectF(rect); 
        final float roundPx = 6; 


        paint.setAntiAlias(true); 
        //canvas.drawARGB(0, 0, 0, 0); 
        //paint.setColor(color); 
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint); 


        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN)); 
        canvas.drawBitmap(bitmap, rect, rect, paint); 


        return output; 
    } 

}
