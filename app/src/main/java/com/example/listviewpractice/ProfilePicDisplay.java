package com.example.listviewpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

public class ProfilePicDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_pic_display);

        ImageView mImage  = findViewById(R.id.imageView);
        Bundle extra = getIntent().getExtras();
        Bitmap bmp = (Bitmap)extra.getParcelable("imagebitmap");

        mImage.setImageBitmap(bmp);
    }
}