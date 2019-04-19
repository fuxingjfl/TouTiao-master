package com.chaychan.news.ui.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.FrameLayout;

import com.chaychan.news.R;
import com.chaychan.news.base.BaseFragment;
import com.chaychan.news.base.BasePresenter;
import com.chaychan.news.model.entity.News;
import com.chaychan.news.ui.adapter.MicroVideoAdapter;
import com.chaychan.uikit.powerfulrecyclerview.PowerfulRecyclerView;
import com.chaychan.uikit.refreshlayout.BGARefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by ysq on 2019/4/15.
 */

public class VideoListFragment extends BaseFragment {


    @Bind(R.id.refresh_layout_xs)
    BGARefreshLayout refresh_layout_xs;

    @Bind(R.id.fl_content_xs)
    FrameLayout fl_content_xs;


    @Bind(R.id.rv_news_xs)
    PowerfulRecyclerView rv_news_xs;

    private MicroVideoAdapter microVideoAdapter;
    private List<Integer> mList = new ArrayList<>();


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_xsvideo;
    }

    @Override
    public View getStateViewRoot() {
        return fl_content_xs;
    }

    @Override
    public void initView(View rootView) {

        rv_news_xs.setLayoutManager(new GridLayoutManager(mActivity, 2));
    }

    @Override
    protected void loadData() {



        for (int i=0;i<10;i++){

            mList.add(i);

        }


    }

    @Override
    public void initListener() {

        if (microVideoAdapter==null){
            microVideoAdapter=new MicroVideoAdapter(R.layout.item_xsvideo,mList);
        }

        rv_news_xs.setAdapter(microVideoAdapter);

    }
}
