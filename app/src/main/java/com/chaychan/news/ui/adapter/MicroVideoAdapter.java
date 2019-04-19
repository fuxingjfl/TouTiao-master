package com.chaychan.news.ui.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.news.model.entity.News;

import java.util.List;

/**
 * Created by ysq on 2019/4/12.
 */

public class MicroVideoAdapter extends BaseQuickAdapter<Integer, BaseViewHolder> {



    public MicroVideoAdapter(@LayoutRes int layoutResId, @Nullable List<Integer> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, Integer news) {

    }
}
