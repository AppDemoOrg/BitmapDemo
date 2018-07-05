

## image-framework  
- BitmapFun
- Picasso
- Glide 
- Fresco
- Android-Universal-Image-Loader


### 任务
1、图片框架源码学习及使用


### BitmapFun
- Android官方教程中的入门级图片框架
- 早期使用较多，现已退出实际项目开发的舞台
- 作为入门教程，依然不可忽视，毕竟万变不离其宗 


### Picasso
- square公司开源的项目
- 实现了图片的下载和二级缓存
- 解决了在adapter中正常的处理image view回收和下载的取消
- 解决了用最少内存实现复杂的图像变换
- Picasso.with(context).load("img_url").into(image_view);

### Glide
- Google推荐的用于Android平台上的图片加载和缓存库
- Glide被广泛用于Google的开源项目中
- Glide和Picasso有90%的相似度，可以说是Picasso的克隆版，在细节上有区别
- Glide为包含图片的滚动列表做了尽可能的流畅优化
- 除了静态图片，Glide也支持GIF格式图片
- Glide提供了灵活的api可以让开发者方便地替换下载图片的网络库
- 默认使用HttpUrlConnection作为网络请求模块
- 开发者可以根据项目需要替换为Google的Volley或者Square的OkHttp
- Glide.with(context).load("img_url").into(image_view);

### Fresco
- Facebook开源的功能强大的图片加载和缓存框架
- 显著特点是三级缓存：两级内存和一级磁盘缓存
- 主要特性：   
渐进地加载jpg图片     
显示gif和webp动画   
可扩展，可自定义图片的加载和显示
在Android4.x和一下系统，将图片放在内存的一个特殊区域，        
从而使得应用运行更加流畅，同时极大减低出现OOM的错误    


### Android-Universal-Image-Loader
- 简称UIL，老牌的图片下载和缓存库
- 功能强大灵活且可自定义
- 提供一系列的配置选项，能很好的控制加载和缓存过程
- 支持二级缓存，主要特性如下：
同步或者异步的多线程图片加载   
高度自定义：线程池、下载器、解码器、内存和磁盘缓存、图片显示选项等
可实时监听图片加载流程，包括下载进度 
  

### 图片库空间占用大小比较
1、BitmapFun：71KB
2、Picasso：120KB
3、Glide：475KB
4、Fresco：3.4MB
5、UIL：162KB


### 图片库选型
1、原则：按照App具体情况而定   
2、对于严重依赖图片缓存的App，可选最专业的Fresco   
3、一般的app选Fresco显比较重   
4、根据对App图片缓存框架的需求从低到高排序   
5、BitmapFun < Picasso < UIL < Glide < Fresco  