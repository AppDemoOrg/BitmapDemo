package com.abt.bitmap.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.text.TextUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by huangweiqi on 15/05/2018.
 */
public class BitmapUtil {

    /**
     * 获取图片缩略图
     * @param imagePath 图片路径
     * @param width    缩略图宽度
     * @param height   缩略图高度
     */
    public static final Bitmap getImageThumbnail(String imagePath, int width, int height) {
        if (TextUtils.isEmpty(imagePath)) {
            return null;
        }

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds  = true;
        // 获取这个图片的宽和高，注意此处的bitmap为null
        Bitmap bitmap = BitmapFactory.decodeFile(imagePath, options);
        options.inJustDecodeBounds = false; // 设为 false
        // 计算缩放比
        int h = options.outHeight;
        int w = options.outWidth;
        int beWidth = w / width;
        int beHeight = h / height;
        int ratio = 1;
        if (beWidth < beHeight) {
            ratio = beWidth;
        } else {
            ratio = beHeight;
        }
        if (ratio <= 0) {
            ratio = 1;
        }
        options.inSampleSize = ratio;
        // 重新读入图片，读取缩放后的bitmap，注意这次要把options.inJustDecodeBounds 设为 false
        bitmap = BitmapFactory.decodeFile(imagePath, options);
        // 利用ThumbnailUtils来创建缩略图，这里要指定要缩放哪个Bitmap对象
        bitmap = ThumbnailUtils.extractThumbnail(bitmap, width, height,
                ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
        return bitmap;
    }

    /**
     * 获取视频缩略图
     */
    public static final Bitmap getVideoThumbnail(String videoPath, int width, int height, int kind) {
        if (TextUtils.isEmpty(videoPath)) {
            return null;
        }
        // 获取视频的缩略图
        Bitmap bitmap = ThumbnailUtils.createVideoThumbnail(videoPath, kind);
        if (null != bitmap) {
            bitmap = ThumbnailUtils.extractThumbnail(bitmap, width, height,
                    ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
            return bitmap;
        }
        return null;
    }

    /** 保存位图到指定的路径 */
    public static void saveBitmap(Bitmap bitmap, String fileName, int quality) {
        if (bitmap != null) {
            final File file = new File(fileName);
            try {
                File dirFile = file.getParentFile();
                if (!dirFile.exists()) {
                    dirFile.mkdir();
                }
                if (file.createNewFile()) {
                    FileOutputStream fOut = null;
                    try {
                        fOut = new FileOutputStream(fileName);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    if (fOut != null) {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, quality, fOut);
                        fOut.flush();
                        fOut.close();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
