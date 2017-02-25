package com.leostones.applicationmarket.ui.fragment;

import java.util.HashMap;

/**
 * 作者：LeoStones
 * 时间：2016/11/14  17:56
 * 邮箱：
 * 说明：生产fragment
 */
public class FragmentFactroy {

    private static HashMap<Integer, BaseFragment> mFragmentMap = new HashMap<Integer, BaseFragment>();
    public static BaseFragment createFragment(int pos){

        // 先从集合中取, 如果没有,才创建对象, 提高性能
        BaseFragment fragment = mFragmentMap.get(pos);
        if (fragment == null) {
            switch (pos) {
                case 0:
                    fragment = new HomeFragment();
                    break;
                case 1:
                    fragment = new AppFragment();
                    break;
                case 2:
                    fragment = new GameFragment();
                    break;
                case 3:
                    fragment = new SubjectFragment();
                    break;
                case 4:
                    fragment = new RecommendFragment();
                    break;
                case 5:
                    fragment = new CategoryFragment();
                    break;
                case 6:
                    fragment = new HotFragment();
                    break;

                default:
                    break;
            }
            mFragmentMap.put(pos, fragment);
        }
        return fragment;
    }
}
