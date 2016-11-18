package dev.xesam.android.demokit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import butterknife.ButterKnife;

/**
 * Created by xesamguo@gmail.com on 12/2/15.
 */
public abstract class KitListActivity extends KitActivity {

    protected ListView vKitLv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind();
    }

    private void bind() {
        vKitLv = ButterKnife.findById(this, R.id.kit_lv);
    }
}
