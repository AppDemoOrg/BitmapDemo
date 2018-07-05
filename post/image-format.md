
## 图片格式

### 支持的图片格式
1、JPEG   
2、PNG  
3、GIF    
4、BMP   
5、WebP（自Android4.0开始支持）   

### 支持的编解码格式
1、JPEG   
2、PNG  
3、WebP    
详情可查看Bitmap类的CompressFormat

### GIF
- 需要引入第三方函数库进行支持
- 古老的图片格式，诞生于1987   
- 支持多帧动画，比如微信上的动态表情


### JPEG  
- 有损图片压缩标准  
- 不支持透明和多帧动画   
- 摄影类作品最终以JPEG格式展示   
- 通过控制压缩比，可调整图片的大小  

### PNG
- 无损图片格式，通过空间占用大，支持透明通道
- 有ARGB四个通道，JPEG只有RGB三个通道
- app瘦身时，通常要处理png图片以减少占用空间


### WebP
- Google在2010年发布
- 支持无损和有损压缩
- 支持完整的透明通道  
- 支持多帧动画
- 既保证图片质量和图片大小的需求下，WebP是首选
- 主流app（微信、微博、淘宝）已经应用了WebP

### JPG/PNG占内存大小计算方式     
1、[jpg和png文件头，图片更改文件后缀名有什么影响](https://blog.csdn.net/qq_33436621/article/details/71038606)    


### 参考文献
1、[android一张图片占用的内存大小](http://blog.sina.com.cn/s/blog_96a1468901016hcw.html)     
2、[Bitmap,jpg,png区别以及在Android上实现不载入内存压缩图片](https://blog.csdn.net/zaizai2154365/article/details/70740623)     
