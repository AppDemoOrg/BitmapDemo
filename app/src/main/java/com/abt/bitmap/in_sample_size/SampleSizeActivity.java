package com.abt.bitmap.in_sample_size;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.abt.bitmap.R;
import com.orhanobut.logger.Logger;

/**
 * @描述： @采用率activity
 * @作者： @黄卫旗
 * @创建时间： @04/07/2018
 */
public class SampleSizeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_size);

        ImageView img = findViewById(R.id.img_view);
        int resId = R.drawable.clock_memo_gaitubao_com_108x108;
        Bitmap bitmap = SampleSizeUtil.decodeBitmapFromResource(getResources(), resId, 108, 108);
        int kb = bitmap.getByteCount() / 1024;
        Logger.d("kb="+kb);
        img.setImageBitmap(bitmap);
    }
}
