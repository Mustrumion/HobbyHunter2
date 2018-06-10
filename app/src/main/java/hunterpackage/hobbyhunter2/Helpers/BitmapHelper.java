package hunterpackage.hobbyhunter2.Helpers;

import android.graphics.Bitmap;
import android.graphics.Matrix;

import static java.lang.Math.min;

public class BitmapHelper {
    public static Bitmap getResizedBitmap(Bitmap bm, float maxDimension) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float rescale = min(maxDimension/width, maxDimension/height);
        if(rescale > 1){
            return bm;
        }
        // CREATE A MATRIX FOR THE MANIPULATION
        Matrix matrix = new Matrix();
        // RESIZE THE BIT MAP
        matrix.postScale(rescale, rescale);

        // "RECREATE" THE NEW BITMAP
        Bitmap resizedBitmap = Bitmap.createBitmap(
                bm, 0, 0, width, height, matrix, false);
        bm.recycle();
        return resizedBitmap;
    }
}
