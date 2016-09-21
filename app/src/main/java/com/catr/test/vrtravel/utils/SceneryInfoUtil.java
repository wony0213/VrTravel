package com.catr.test.vrtravel.utils;

import com.catr.test.vrtravel.R;
import com.catr.test.vrtravel.model.SceneryInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Wony on 2016/9/6.
 */
public class SceneryInfoUtil {
    public static List<SceneryInfo> sceneryInfos;
    private static String[] mPlaceName = {"故宫", "九寨沟", "卡帕热气球", "白宫", "白金汉宫", "威尼斯水城", "城山日出峰", "富士山"};
    private static String[] mCountry = {"中国", "中国", "土耳其", "美国", "英国", "意大利", "韩国", "日本"};
    private static String[] mCity = {"北京", "四川", "卡帕多西亚", "哥伦比亚特区", "伦敦", "威尼斯", "济州特别自治道", "静冈"};
    private static int[] mImgs = {R.drawable.gugong, R.drawable.jiuzhaigou, R.drawable.kapareqiqiu, R.drawable.baigong, R.drawable.baijinhan, R.drawable.weinisi, R.drawable.chengshanrichufeng, R.drawable.fushishan};
    private static String[] mPanoImgs = {"black-mono.jpg", "black-mono.jpg", "black-mono.jpg", "black-mono.jpg", "black-mono.jpg", "black-mono.jpg", "black-mono.jpg", "black-mono.jpg"};
    private static String[] mPanoImgs2 = {"black-mono.jpg", "js-mono-170.jpg", "js-mono-170.jpg", "js-mono-170.jpg", "js-mono-170.jpg", "js-mono-170.jpg", "js-mono-170.jpg", "js-mono-170.jpg"};

    public static Map<String, Integer> picResMap;

    static {
        picResMap = new HashMap<>();
        picResMap.put("故宫", R.drawable.gugong);
        picResMap.put("九寨沟", R.drawable.jiuzhaigou);
        picResMap.put("卡帕热气球", R.drawable.kapareqiqiu);
        picResMap.put("白宫", R.drawable.baigong);
        picResMap.put("白金汉宫", R.drawable.baijinhan);
        picResMap.put("威尼斯水城", R.drawable.weinisi);
        picResMap.put("城山日出峰", R.drawable.chengshanrichufeng);
        picResMap.put("富士山", R.drawable.fushishan);
    }

    public static List<SceneryInfo> getSceneryInfos() {
        sceneryInfos = new ArrayList<>();
        for (int i = 0; i < mPlaceName.length; i++) {
            SceneryInfo sceneryInfo = new SceneryInfo();
            sceneryInfo.setSceneryName(mPlaceName[i]);
            sceneryInfo.setCity(mCity[i]);
            sceneryInfo.setCountry(mCountry[i]);
            sceneryInfo.setPanoName(mPanoImgs2[i]);

            sceneryInfo.setPicResId(picResMap.get(mPlaceName[i]));

            sceneryInfos.add(sceneryInfo);
        }
        return sceneryInfos;
    }
}
