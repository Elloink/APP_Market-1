package com.leostones.applicationmarket.ui.fragment;

import android.view.View;
import com.leostones.applicationmarket.ui.view.LoadingPage.ResultState;
/**
 * 作者：LeoStones
 * 时间：2016/11/14  18:05
 * 邮箱：
 * 说明：游戏
 */
public class GameFragment extends BaseFragment {
    @Override
    public View onCreateSuccessView() {
        return null;
    }

    @Override
    public ResultState onLoad() {
        return ResultState.STATE_EMPTY;
    }
}
