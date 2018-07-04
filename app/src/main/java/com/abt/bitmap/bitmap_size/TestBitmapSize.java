package com.abt.bitmap.bitmap_size;

import android.graphics.Bitmap;

import com.abt.bitmap.R;
import com.abt.bitmap.util.BitmapUtil;

/**
 * @描述： @TestBitmapSize
 * @作者： @黄卫旗
 * @创建时间： @05/06/2018
 */
public class TestBitmapSize {

    /**
     * 测试结论：
     * 1、JPG或者PNG在内存中每个像素都是占有四个字节
     * 2、修改后缀为PNG，或者JPG，Bitmap大小不变
     */
    public static void testFilePostfix() {
        //String path = "ic_launcher.jpeg";
        String path = "ic_launcher.png";
        //String path = "open_source.jpeg";
        //String path = "open_source.png";
        Bitmap map = BitmapUtil.getBitmapFromAssetsFile(path);
        long size = BitmapUtil.getBitmapSize(map);
        int KB = (int) (size/1024);
        System.out.println("from assets, size = "+KB+"KB");
    }

    /**
     * 在ViVoX9真机上测试的结论：
     * 1、放在xhdpi和mipmap_xhdpi中的图片，加载到内存中的大小以至，都是20KB
     * 2、放在xxhdpi、mipmap_xxhdpi、assets中的图片，加载到内存中的大小以至，都是9KB
     * 3、放在drawable目录下的图片，加载到内存有可能会对图片做缩放，而导致内存大小变化
     */
    public static void testFileLocation() {
        String path = "ic_launcher.png";
        Bitmap map = BitmapUtil.getBitmapFromAssetsFile(path);
        long size = BitmapUtil.getBitmapSize(map);
        int KB = (int) (size/1024);
        System.out.println("from assets, size = "+KB+"KB");

        map = BitmapUtil.getBitmapFromDrawable(R.drawable.xhdpi);
        size = BitmapUtil.getBitmapSize(map);
        KB = (int) (size/1024);
        System.out.println("from xhdpi, size = "+KB+"KB");

        map = BitmapUtil.getBitmapFromDrawable(R.drawable.xxhdpi);
        size = BitmapUtil.getBitmapSize(map);
        KB = (int) (size/1024);
        System.out.println("from xxhdpi, size = "+KB+"KB");

        map = BitmapUtil.getBitmapFromDrawable(R.mipmap.xhdpi_mipmap);
        size = BitmapUtil.getBitmapSize(map);
        KB = (int) (size/1024);
        System.out.println("from mipmap_xhdpi, size = "+KB+"KB");

        map = BitmapUtil.getBitmapFromDrawable(R.mipmap.xxhdpi_mipmap);
        size = BitmapUtil.getBitmapSize(map);
        KB = (int) (size/1024);
        System.out.println("from mipmap_xxhdpi, size = "+KB+"KB");
    }
}
