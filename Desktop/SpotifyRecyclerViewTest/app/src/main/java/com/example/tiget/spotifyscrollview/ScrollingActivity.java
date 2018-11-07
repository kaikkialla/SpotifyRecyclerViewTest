package com.example.tiget.spotifyscrollview;

import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //toolbar.setVisibility(View.GONE);

        NestedScrollView scroller = (NestedScrollView) findViewById(R.id.nested_scroll_view);
        final TextView staticImageView = findViewById(R.id.static_button);


        if (scroller != null) {

            scroller.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
                @Override
                public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    Resources resources = getResources();
                    DisplayMetrics metrics = resources.getDisplayMetrics();

                    //float px = dp * metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);

                    //float  px / getResources().getDisplayMetrics().density;

                    if (scrollY > oldScrollY) {
                        staticImageView.setY(scrollY + 64);
                    } else if(scrollY < oldScrollY) {
                        if(scrollY<64) {
                            staticImageView.setY(scrollY);
                        } else staticImageView.setY(scrollY + 64);

                    }



                }
            });
        }

    }
}
