

## 图片缓存
1、流量是收费的，必须要解决流量消耗问题     
2、提高加载的效率，从内存、文件加载缓存，提高了用户体验    

### LruCache
- LruCache是Android3.1所提供的一个缓存类，
通过support-v4兼容包可以兼容到早期的Android版本
- LruCache是一个泛型类，内部采用LinkedHashMap存储缓存对象  
- 从Android3.1开始，LruCache已经是Android源码的一部分了  


### 