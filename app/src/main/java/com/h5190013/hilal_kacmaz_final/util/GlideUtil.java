package com.h5190013.hilal_kacmaz_final.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GlideUtil {

    public  static  void imageDownload(Context context, String url, ImageView img)
    {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .into(img);
    }
}
