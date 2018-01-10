package com.twinflag.twinflaggou;

import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

import com.twinflag.twinflaggou.photoview.OnSingleFlingListener;
import com.twinflag.twinflaggou.photoview.PhotoView;

public class HomeActivity extends AppCompatActivity {

    Toolbar toolbar;
    PhotoView goodsDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(operationMenuItemClick);
        goodsDisplay = findViewById(R.id.goods_display);
    }

    private Toolbar.OnMenuItemClickListener operationMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.edit_goods:
                    editGoods.setVisible(false);
                    editCancel.setVisible(true);
                    editConfirm.setVisible(true);
                    goodsDisplay.setOnDragListener(null);
                    break;

                case R.id.edit_confirm:
                    editGoods.setVisible(true);
                    editCancel.setVisible(false);
                    editConfirm.setVisible(false);
                    break;

                case R.id.edit_cancel:
                    editGoods.setVisible(true);
                    editCancel.setVisible(false);
                    editConfirm.setVisible(false);
                    break;
            }
            return true;
        }
    };

    private MenuItem editGoods, editCancel, editConfirm;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);

        editGoods = menu.findItem(R.id.edit_goods);
        editCancel = menu.findItem(R.id.edit_cancel);
        editConfirm = menu.findItem(R.id.edit_confirm);
        return true;
    }
}
