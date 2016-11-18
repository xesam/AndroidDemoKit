package dev.xesam.android.demokit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import dev.xesam.android.logtools.L;

/**
 * Created by xesamguo@gmail.com on 12/14/15.
 */
public class KitBroadcastReceiver extends BroadcastReceiver {

    IntentFilter filter = new IntentFilter();
    private BroadcastReceiver mBroadcastReceiver;

    public KitBroadcastReceiver(String... actions) {
        addActions(actions);
    }

    public KitBroadcastReceiver(BroadcastReceiver broadcastReceiver, String... actions) {
        mBroadcastReceiver = broadcastReceiver;
        addActions(actions);
    }

    private void addActions(String... actions) {
        if (actions != null) {
            for (String action : actions) {
                filter.addAction(action);
            }
        }
    }

    public void register(Context context) {
        context.registerReceiver(this, filter);
    }

    public void unRegister(Context context) {
        context.unregisterReceiver(this);
    }

    public void onIntercept(Context context, Intent intent) {

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        L.d(this, "onReceive action", action);

        onIntercept(context, intent);

        if (mBroadcastReceiver != null) {
            mBroadcastReceiver.onReceive(context, intent);
        }
    }
}
