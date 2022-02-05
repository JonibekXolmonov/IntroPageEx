package com.example.intropageex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class PageAdapter extends PagerAdapter {

    private final ArrayList<Page> pages;
    private final Context context;

    public PageAdapter(ArrayList<Page> pages, Context context) {
        this.pages = pages;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pages.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.item_page, container, false);

        ((ImageView) view.findViewById(R.id.iv_opener)).setImageResource(pages.get(position).image);
        ((TextView) view.findViewById(R.id.tv_context)).setText(pages.get(position).context);
        ((TextView) view.findViewById(R.id.tv_description)).setText(pages.get(position).description);

        ((ViewPager) container).addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((View) object);
    }
}
