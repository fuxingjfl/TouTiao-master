package com.chaychan.news.ui.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by ysq on 2019/4/16.
 */

public class CommentPopAdapter extends BaseQuickAdapter<Integer,BaseViewHolder> {



    public CommentPopAdapter(@LayoutRes int layoutResId, @Nullable List<Integer> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, Integer integer) {

    }
}
