package dev.xesam.android.demokit;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 从a - z 的一个adapter
 */
public class AzAdapter extends ArrayAdapter<String> {

    public static List<String> strings = new ArrayList<>();

    static {
        char start = 'a';
        char end = 'z';
        for (int i = start; i <= end; i++) {
            strings.add(String.valueOf((char) i));
        }
    }

    public AzAdapter(Context context) {
        super(context, android.R.layout.simple_list_item_1, strings);
    }
}
