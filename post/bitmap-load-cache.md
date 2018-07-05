
## Bitmap 

### Bitmap疑问
1、为啥要在nativeDecodeBitmap？      
2、在native中如何decode的？    
3、inSampleSize是如何控制采用的？    
4、Bitmap按采用率缩放后，图像质量如何保证？    
5、Bitmap与ImageView如何适配？     
6、不同drawable目录下加载到不同图片尺寸，求Android资源加载机制。       

### Bitmap的核心问题
- 如何高效加载
- Bitmap的缓存策略
- 列表滑动的流畅性，如何优化   

### 如何高效加载Bitmap
- 为何要高效加载，因为Bitmap的特殊性及Android对单个应用所施加的内存限制，     
比如16M，导致加载Bitmap很容易出现内存溢出（OOM），所以如何有效、     
高效的加载Bitmap就变得重要了
- 如何加载Bitmap，加载的本质是从磁盘把Bitmap加载到内存，Bitmap是指图片，
在磁盘中可以是png，也可以是jpg等格式
- BitmapFactory提供了四类方法：decodeByteArray、decodeFile、decodeResource、decodeStream
分别用于从字节数组、文件系统、资源、输入流中加载Bitmap对象
- 其中decodeFile和decodeResource又间接调用了decodeStream方法，这四类方法最终在Android
底层实现，对应着BitmapFactory类的几个native方法
- 高效加载Bitmap的核心思想：采用BitmapFactory.Options来加载所需尺寸的图片
- 通过BitmapFactory.Options可以按照一定的采样率来加载缩小后的图片，
展示缩小后的图片，就会降低内存占用，从而一定程度上避免OOM，提高了Bitmap加载性能

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
- 不要在getView中做耗时操作
- 控制异步加载的频率，只有在列表idle时采取加载图片
- 开启activity的硬件加速

### mipmap和drawable区别    
1、mipmap主要用于存放icon    
2、drawable存放xml\png\jpg\gif等   

### 避免OOM       
1、对于图片显示：根据需要显示图片控件的大小对图片进行压缩显示   
2、如果图片数量非常多：则会使用LruCache等缓存机制，     
3、将所有图片占据的内存维持在一个范围内，       

## 参考文献   
1、[BitMap优化最佳实践及官方Demo“图片墙”实例详解](https://blog.csdn.net/brillianteagle/article/details/50597201)     
2、[Android中mipmap与drawable区别](https://blog.csdn.net/userzhanghao123/article/details/70243872)      
