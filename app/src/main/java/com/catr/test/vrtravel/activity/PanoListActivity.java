package com.catr.test.vrtravel.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.catr.test.vrtravel.R;
import com.catr.test.vrtravel.adapter.SceneryListAdapter;
import com.catr.test.vrtravel.utils.SceneryInfoUtil;

/**
 * Created by 1 on 2016/8/31.
 */
public class PanoListActivity extends Activity {
    private ListView mListView;
//    private PanoListAdapter mAdapter;
    private SceneryListAdapter mAdapter;
    private int mCurrentItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_listview);
        mListView = (ListView) findViewById(R.id.video_lv);
//        mAdapter = new PanoListAdapter(this, SceneryInfoUtil.getSceneryInfos());
        mAdapter = new SceneryListAdapter(this, SceneryInfoUtil.getSceneryInfos());
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(getApplication(), VrPanoramaActivity.class);
//                intent.putExtra(VrApp.PANORAMA_NUM, position);
//                startActivity(intent);
//                finish();
            }
        });
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                Log.e("Test", scrollState + "");
                if ((scrollState == SCROLL_STATE_FLING || scrollState == SCROLL_STATE_TOUCH_SCROLL) && mAdapter.getScrollState() == SCROLL_STATE_IDLE) {
                    mAdapter.setScrollState(scrollState);
                    mAdapter.notifyDataSetChanged();
                    return;
                }

                if (scrollState == SCROLL_STATE_IDLE) {
                    mAdapter.setScrollState(scrollState);
                    int firstVisibleItem = mListView.getFirstVisiblePosition();
                    if (null != mListView.getChildAt(0)) {
                        if (mListView.getChildAt(0).getTop() >= 0) {
                            mCurrentItem = firstVisibleItem;
                        } else {
                            mCurrentItem = firstVisibleItem + 1;
                        }
                        //add by glf
                        if (mCurrentItem != mAdapter.getCurrentItem()) {
                            mAdapter.setCurrentItem(mCurrentItem);
                            mAdapter.notifyDataSetChanged();
                        }
                    }
                    return;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

    }
}
