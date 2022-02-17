package com.example.hangman;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // Keep all Images in array
    public Integer[] letters = {};
    public Integer[] library = {
            R.drawable.a,R.drawable.b,R.drawable.c,
            R.drawable.d,R.drawable.e,R.drawable.f,
            R.drawable.g,R.drawable.h,R.drawable.i,
            R.drawable.j,R.drawable.k,R.drawable.l,
            R.drawable.n,R.drawable.m,R.drawable.o,
            R.drawable.p,R.drawable.q,R.drawable.r,
            R.drawable.s,R.drawable.t,R.drawable.u,
            R.drawable.v,R.drawable.w,R.drawable.x,
            R.drawable.y,R.drawable.z
    };
    // Constructor
    public ImageAdapter(Context c, char letter){
        mContext = c;
    }

    @Override
    public int getCount() {
        return letters.length;
    }

    @Override
    public Object getItem(int position) {
        return letters[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(letters[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(70, 70));
        return imageView;
    }

}