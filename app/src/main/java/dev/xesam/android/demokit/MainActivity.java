package dev.xesam.android.demokit;

import android.os.Bundle;

import dev.xesam.android.demokit.app.R;

public class MainActivity extends KitActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
