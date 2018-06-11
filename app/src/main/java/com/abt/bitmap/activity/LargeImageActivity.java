package com.abt.bitmap.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.abt.bitmap.R;
import com.abt.bitmap.large_image.LargeImageView;

import java.io.IOException;
import java.io.InputStream;

public class LargeImageActivity extends AppCompatActivity {

    private LargeImageView mLargeImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large_image);

        mLargeImageView = findViewById(R.id.id_largetImageview);
        try {
            InputStream inputStream = getAssets().open("qm.jpg");
            mLargeImageView.setInputStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
