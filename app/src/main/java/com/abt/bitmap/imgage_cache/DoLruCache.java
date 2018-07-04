package com.abt.bitmap.imgage_cache;

import android.util.LruCache;

/**
 * @描述： @
 * @作者： @黄卫旗
 * @创建时间： @05/07/2018
 */
public class DoLruCache {

    LruCache<String, String> cache = new LruCache<>(16);

    public LruCache<String, String> getCache() {
        return cache;
    }
}
