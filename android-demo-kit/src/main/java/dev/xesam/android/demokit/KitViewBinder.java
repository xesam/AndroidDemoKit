package dev.xesam.android.demokit;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by xesamguo@gmail.com on 16-3-24.
 */
public class KitViewBinder {

    private View mBindView;
    private SparseArray<View> views = new SparseArray<>();

    public KitViewBinder(View view) {
        mBindView = view;
    }

    public KitViewBinder(Context context, int layoutId) {
        this(LayoutInflater.from(context).inflate(layoutId, null, false));
    }

    public KitViewBinder(ViewGroup parent, int layoutId) {
        this(parent.getContext(), layoutId);
    }

    public View getView() {
        return mBindView;
    }

    @SuppressWarnings("unchecked")
    public final <T extends View> T get(int id) {
        View view = views.get(id);
        if (view == null) {
            view = mBindView.findViewById(id);
            views.append(id, view);
        }
        return (T) view;
    }

    public KitViewBinder text(int id, CharSequence charSequence) {
        this.<TextView>get(id).setText(charSequence);
        return this;
    }

    public KitViewBinder text(int id, int strResIdId) {
        text(id, mBindView.getResources().getString(strResIdId));
        return this;
    }

    public KitViewBinder textColor(int id, int color) {
        this.<TextView>get(id).setTextColor(color);
        return this;
    }

    public KitViewBinder image(int id, int imgResId) {
        this.<ImageView>get(id).setImageResource(imgResId);
        return this;
    }

    public KitViewBinder visible(int id) {
        get(id).setVisibility(View.VISIBLE);
        return this;
    }

    public KitViewBinder invisible(int id) {
        get(id).setVisibility(View.INVISIBLE);
        return this;
    }

    public KitViewBinder gone(int id) {
        get(id).setVisibility(View.GONE);
        return this;
    }
}
