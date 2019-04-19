package com.chaychan.news.ui.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.chaychan.news.R;
import com.chaychan.news.ui.adapter.CommentPopAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ysq on 2018/10/25.
 */

public class CommentPop extends PopupWindow {
    private int resId;
    private Context context;
    private LayoutInflater inflater;
    public View defaultView;
    private CommentSelectorListener commentSelectorListener;
    private RecyclerView rv_pl;

    private CommentPopAdapter adapter;
    private List<Integer> mlist;


    public CommentPop(Context context, int resId
            , CommentSelectorListener commentSelectorListener) {
        super(context);
        this.context = context;
        this.resId = resId;
        this.commentSelectorListener = commentSelectorListener;
        mlist = new ArrayList<>();
        for (int i=0;i<10;i++){
            mlist.add(i);
        }
        initPopupWindow();
    }

    public void initPopupWindow() {
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        defaultView = inflater.inflate(this.resId, null);
        defaultView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        setContentView(defaultView);

        rv_pl=defaultView.findViewById(R.id.rv_pl);

        rv_pl.setLayoutManager(new LinearLayoutManager(context));

        adapter = new CommentPopAdapter(R.layout.item_comment_pop,mlist);

        rv_pl.setAdapter(adapter);

        setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
		 setAnimationStyle(R.style.popwin_anim_style);
//        setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(android.R.color.transparent)));
        setFocusable(false);
        setOutsideTouchable(false);
        update();

    }


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){

            }
        }
    };




    public interface CommentSelectorListener {

        void onCancelListener();


    }

    /**
     * @return pop的View
     */
    public View getDefaultView() {
        return defaultView;
    }


}