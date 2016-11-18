package dev.xesam.android.demokit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by xesamguo@gmail.com on 12/14/15.
 */
public class KitText2Adapter<T> extends BaseAdapter {

    private List<T> items = new ArrayList<>();

    public KitText2Adapter() {
    }

    public void addItem(T item) {
        this.items.add(item);
        notifyDataSetChanged();
    }

    public void addItems(Collection<T> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    protected String getString1(int position, T item) {
        return null;
    }

    protected String getString2(int position, T item) {
        return null;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public T getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();

        T item = getItem(position);
        viewHolder.vTv1.setText(getString1(position, item));
        viewHolder.vTv2.setText(getString2(position, item));

        return convertView;
    }

    private class ViewHolder {
        TextView vTv1;
        TextView vTv2;

        public ViewHolder(View view) {
            vTv1 = ButterKnife.findById(view, android.R.id.text1);
            vTv2 = ButterKnife.findById(view, android.R.id.text2);
        }
    }
}
