package com.catr.test.vrtravel.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.catr.test.vrtravel.R;
import com.catr.test.vrtravel.adapter.PanoListAdapter;
import com.catr.test.vrtravel.utils.SceneryInfoUtil;

/**
 * Created by 1 on 2016/8/31.
 */
public class PanoListActivity_Backup extends Activity {
    private ListView mListView;
    private PanoListAdapter mAdapter;
    private int mCurrentItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_listview);
        mListView = (ListView) findViewById(R.id.video_lv);
        mAdapter = new PanoListAdapter(this, SceneryInfoUtil.getSceneryInfos());
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                int firstVisibleItem = mListView.getFirstVisiblePosition();
                if (scrollState == SCROLL_STATE_IDLE) {
                    if (null != mListView.getChildAt(0)) {
                        if (mListView.getChildAt(0).getTop() >= 0) {
                            mCurrentItem = firstVisibleItem;
                        } else {
                            mCurrentItem = firstVisibleItem + 1;
                        }
                        mAdapter.setCurrentItem(mCurrentItem);
                        mAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

    }
}