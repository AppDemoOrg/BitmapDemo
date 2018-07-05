

### 加载大图（世界地图、清明上河图、微博长图）     
1、单个图片巨大，不允许压缩   
2、局部加载BitmapRegionDecoder   
3、把局部Rect拿到draw到Canvas上
4、通过局部Rect限定显示内容，onTouchEvent更新Rect
5、处理Rect与触摸事件，以及边处理

## 参考文献   
1、[Android高清加载巨图方案拒绝压缩图片](https://blog.csdn.net/lmj623565791/article/details/49300989/)      
