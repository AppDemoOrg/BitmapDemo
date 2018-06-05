# BitmapDemo

## TODO  
1、jpg/png占内存大小计算方式    
3、加载大图   
4、mipmap和drawable区别

### 8888和565区别
A：透明度，R：红色，G：绿，B：蓝   
Bitmap.Config ARGB_4444：即A=4，R=4，G=4，B=4，那么一个像素点占4+4+4+4=16位   
Bitmap.Config ARGB_8888：即A=8，R=8，G=8，B=8，那么一个像素点占8+8+8+8=32位    
Bitmap.Config RGB_565：即R=5，G=6，B=5，没有透明度，那么一个像素点占5+6+5=16位   
Bitmap.Config ALPHA_8：只有透明度，没有颜色，那么一个像素点占8=8位     
一般情况下我们都是使用的ARGB_8888，由此可知它是最占内存的，    
因为一个像素占32位，8位=1字节，所以一个像素占4字节的内存。   
假设有一张480x800的图片，如果格式为ARGB_8888，那么将会占用1500KB的内存。   

## 参考文献
1、[Bitmap,jpg,png区别以及在Android上实现不载入内存压缩图片](https://blog.csdn.net/zaizai2154365/article/details/70740623)    
2、[android 一张图片占用的内存大小 ](http://blog.sina.com.cn/s/blog_96a1468901016hcw.html)    
3、[BitMap优化最佳实践及官方Demo“图片墙”实例详解](https://blog.csdn.net/brillianteagle/article/details/50597201)    

