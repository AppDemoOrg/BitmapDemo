
## Bitmap 

### Bitmap的核心问题
- 如何高效加载
- Bitmap的缓存策略
- 列表滑动的流畅性，如何优化   

### 如何高效加载Bitmap
1、为何要高效加载，因为Bitmap的特殊性及Android对单个应用所施加的内存限制，     
比如16M，导致加载Bitmap很容易出现内存溢出（OOM），所以如何有效、     
高效的加载Bitmap就变得重要了

### Bitmap的缓存策略     
- 缓存策略是一个通用的思想     
- 目前常用的缓存策略是LruCache和DiskLruCache   
其中LruCache常用做内存缓存，DiskLruCache用作存储缓存    
通过缓存策略，我们就不需要每次都从网络请求图片，    
这样极大的提高图片加载的效率和用户体验     
- Lru是Least Recently Used的缩写，即最近最少使用算法    
算法核心思想为：当缓存快满时，删除近期最少使用的缓存     

### 如何优化图片列表卡顿现象
- 列表加载大量子视图，当用户快速滑动时，容易出现卡顿    

### 如何避免OOM或者内存泄漏

### mipmap和drawable区别    
1、mipmap主要用于存放icon    
2、drawable存放xml\png\jpg\gif等   

### 加载大图（世界地图、清明上河图、微博长图）     
1、单个图片巨大，不允许压缩   
2、局部加载BitmapRegionDecoder   
3、把局部Rect拿到draw到Canvas上
4、通过局部Rect限定显示内容，onTouchEvent更新Rect
5、处理Rect与触摸事件，以及边处理

### 避免OOM       
1、对于图片显示：根据需要显示图片控件的大小对图片进行压缩显示   
2、如果图片数量非常多：则会使用LruCache等缓存机制，     
3、将所有图片占据的内存维持在一个范围内，       

### JPG/PNG占内存大小计算方式     
1、[jpg和png文件头，图片更改文件后缀名有什么影响](https://blog.csdn.net/qq_33436621/article/details/71038606)    

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
2、[android一张图片占用的内存大小](http://blog.sina.com.cn/s/blog_96a1468901016hcw.html)     
3、[BitMap优化最佳实践及官方Demo“图片墙”实例详解](https://blog.csdn.net/brillianteagle/article/details/50597201)     
4、[Android中mipmap与drawable区别](https://blog.csdn.net/userzhanghao123/article/details/70243872)      
5、[Android高清加载巨图方案拒绝压缩图片](https://blog.csdn.net/lmj623565791/article/details/49300989/)      
