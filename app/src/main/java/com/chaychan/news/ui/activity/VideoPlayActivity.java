package com.chaychan.news.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chaychan.news.R;
import com.chaychan.news.base.BaseActivity;
import com.chaychan.news.base.BasePresenter;
import com.chaychan.news.ui.widget.CommentPop;
import com.chaychan.news.ui.widget.DragRelativeLayout;
import com.chaychan.news.ui.widget.MyVideoView;
import com.chaychan.news.ui.widget.OnDragListener;
import com.chaychan.news.utils.DensityUtil;
import com.chaychan.news.utils.transition.StatusBarUtils;
import com.chaychan.news.utils.transition.TransitionCallback;
import com.chaychan.news.utils.transition.TransitionController;
import com.chaychan.news.utils.transition.TransitionParam;
import com.chaychan.news.utils.transition.TransitionUtils;
import com.chaychan.uikit.statusbar.Eyes;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by ysq on 2019/4/15.
 */

public class VideoPlayActivity extends BaseActivity{

    private static final String ANIM_PARAM = "ANIM_PARAM";

    /**
     * 外部控件位置参数
     */
    private TransitionParam targetAnimBean;

    private TransitionController transitionController;

    @Bind(R.id.vv_sp)
    MyVideoView vv_sp;

    @Bind(R.id.rl_video)
    RelativeLayout rl_video;

    @Bind(R.id.tv_gq)
    TextView tv_gq;

    @Bind(R.id.iv_kz)
    ImageView iv_kz;

    @Bind(R.id.rl_sp)
    RelativeLayout rl_sp;

    @Bind(R.id.ll_pl)
    LinearLayout ll_pl;

    @Bind(R.id.rl_drag)
    DragRelativeLayout mDragLayout;

    private boolean isjs;
    int mVideoWidth,showVideoHeight;
    int mVideoHeight;
    float scale;
    private CommentPop commentPop;
    public static void intentStart(Context context, TransitionParam animBean) {
        Intent intent = new Intent(context, VideoPlayActivity.class);
        intent.putExtra(ANIM_PARAM, animBean);
        context.startActivity(intent);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
//        StatusBarUtils.enableStatusBar(this, true);
        return R.layout.activity_video_play;
    }

    @Override
    public void initView() {
        Eyes.translucentStatusBar(VideoPlayActivity.this,true);
        //文本跑马灯
        tv_gq.setSelected(true);

        setupView();
        Uri uri = Uri.parse( "http://domhttp.kksmg.com/2019/04/15/h264_1200k_mp4_SHDongFangHD30000002019041531773395091_aac.mp4" );
        MediaController mediaController = new MediaController(VideoPlayActivity.this);
        mediaController.setVisibility(View.INVISIBLE);
        //设置视频控制器
        vv_sp.setMediaController(mediaController);

        vv_sp.setVideoURI(uri);
        //开始播放视频
        vv_sp.start();
    }

    @Override
    public void initData() {

        commentPop = new CommentPop(VideoPlayActivity.this,R.layout.pop_comment_layout,commentSelectorListener);

    }

    @Override
    public void initListener() {

        mDragLayout.setOnoDragListener(new OnDragListener() {
            @Override
            public void onStartDrag() {
                super.onStartDrag();

            }

            @Override
            public void onStartEnter(boolean outOfBound) {
                super.onStartEnter(outOfBound);
            }

            @Override
            public void onRelease(boolean isResume) {
                super.onRelease(isResume);

            }

            @Override
            public void onEndExit() {
                super.onEndExit();
                finish();
            }

            @Override
            public void onEndEnter() {
                super.onEndEnter();
            }

            @Override
            public void onStartExit(boolean outOfBound) {
                super.onStartExit(outOfBound);
            }

            @Override
            public void onEndResume() {
                super.onEndResume();

            }
        });
        //播放完成回调
        vv_sp.setOnCompletionListener( new MyPlayerOnCompletionListener());
        vv_sp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {


                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i1) {
//                        int mVideoHeight = mediaPlayer.getVideoHeight();
//                        int mVideoWidth = mediaPlayer.getVideoWidth();
//                                    Log.e("TAG","视频有效高度：：："+mVideoHeight);
//
//                        if(mVideoWidth>mVideoHeight){
//                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) rl_video.getLayoutParams();
//
//                            layoutParams.height=mVideoHeight;
//                            rl_video.setLayoutParams(layoutParams);
//
//                            RelativeLayout.LayoutParams sp = (RelativeLayout.LayoutParams) vv_sp.getLayoutParams();
//                            layoutParams.width=RelativeLayout.LayoutParams.MATCH_PARENT;
//                            vv_sp.setLayoutParams(layoutParams);
//                            Log.e("TAG","layoutParams.height==="+layoutParams.height);
//                        }else{
//                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) rl_video.getLayoutParams();
//                            layoutParams.width=RelativeLayout.LayoutParams.MATCH_PARENT;
//                            vv_sp.setLayoutParams(layoutParams);
//                        }

//                                                        vv_sp.setVisibility(View.VISIBLE);


//                        //FixMe 获取视频资源的宽度
//                        mVideoWidth= mediaPlayer.getVideoWidth();
//                        //FixMe 获取视频资源的高度
//                        mVideoHeight = mediaPlayer.getVideoHeight();
//
//                        scale= (float) mVideoWidth / (float) mVideoHeight;
//                        refreshPortraitScreen(showVideoHeight == 0 ? DensityUtil.dip2px(VideoPlayActivity.this, 300) : showVideoHeight);

                    }
                });
            }
        });

    }


    public void stopVideo(){
        Log.e("TAG","开始关闭播放了");
        vv_sp.pause();
        iv_kz.setVisibility(View.VISIBLE);

    }

    //重新刷新 竖屏显示的大小  树屏显示以宽度为准
    public void refreshPortraitScreen(int height) {
        if (height == 0) {
            height = showVideoHeight;
        }
        if (mVideoHeight > 0 && mVideoWidth > 0) {
            //FixMe 拉伸比例

            mVideoWidth = (int) (height * scale);//FixMe 设置surfaceview画布大小
//            mVideoHeight = (int) (mVideoWidth / scale);
            vv_sp.getHolder().setFixedSize(mVideoWidth, height);
            //FixMe 重绘VideoView大小，这个方法是在重写VideoView时对外抛出方法
            vv_sp.setMeasure(mVideoWidth, height);
            //FixMe 请求调整
            vv_sp.requestLayout();
        }
    }

    private void setupView() {

        targetAnimBean = getIntent().getParcelableExtra(ANIM_PARAM);

        transitionController = new TransitionController.Builder()
                .with(findViewById(R.id.main_root_layer))
                .setInterpolator(PathInterpolatorCompat.create(0.32F, 0.94F, 0.6F, 1.0F))
                .duration(320)
                .build();
        transitionController.transitionEnter(targetAnimBean, new TransitionCallback() {
            @Override
            public void onTransitionStop() {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (commentPop!=null&&commentPop.isShowing()){
            commentPop.dismiss();
        }else{
            if (targetAnimBean != null) {
                transitionController.transitionExit(new TransitionCallback() {
                    @Override
                    public void onTransitionStop() {
                        finish();
                    }
                });
            } else {
                finish();
            }
        }

    }

    @Override
    public void finish() {
        super.finish();
        TransitionUtils.finishTransition(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (transitionController != null) {
            transitionController.transitionRelease();
        }
        try{
            if(vv_sp.isPlaying()){
                vv_sp.pause();
            }
            vv_sp.stopPlayback();
            vv_sp=null;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mp) {
//            Toast.makeText( LocalVideoActivity.this, "播放完成了", Toast.LENGTH_SHORT).show();

            iv_kz.setVisibility(View.VISIBLE);
            isjs=true;
        }
    }

    @OnClick(R.id.rl_sp)
    public void onViewClicked() {
        if(isjs){
            vv_sp.start();
            iv_kz.setVisibility(View.INVISIBLE);
            isjs=false;
        }else{//暂停

            if(iv_kz.getVisibility()==View.VISIBLE){
                vv_sp.start();
                iv_kz.setVisibility(View.INVISIBLE);
            }else if(iv_kz.getVisibility()==View.INVISIBLE){
                Log.e("TAG","暂停=-------------====");
                vv_sp.pause();
                iv_kz.setVisibility(View.VISIBLE);
            }
        }
    }

    @OnClick(R.id.ll_pl)
    public void onViewPL() {
        if (commentPop != null) {
                        if (commentPop.isShowing()) {
                            commentPop.dismiss();
                        } else {
                            commentPop.showAtLocation(ll_pl, Gravity.BOTTOM, 0, 0);
                        }
                    }
    }


    private CommentPop.CommentSelectorListener commentSelectorListener = new CommentPop.CommentSelectorListener() {
        @Override
        public void onCancelListener() {

        }
    };

}
