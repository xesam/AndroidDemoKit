package dev.xesam.android.demokit;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import butterknife.ButterKnife;

/**
 * Created by xesamguo@gmail.com on 12/2/15.
 */
public abstract class KitListFragment extends KitFragment {

    protected ListView vKitLv;

    protected int getLayoutId() {
        return R.layout.kit_list;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bind(view);
    }

    private void bind(View view) {
        vKitLv = ButterKnife.findById(view, R.id.kit_lv);
    }
}
