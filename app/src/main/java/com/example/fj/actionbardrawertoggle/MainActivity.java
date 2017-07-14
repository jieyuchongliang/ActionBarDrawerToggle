package com.example.fj.actionbardrawertoggle;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initActionBar();
        initDrawerLayout();
        initActionBarDrawerToggle();
    }

    private void initActionBarDrawerToggle() {
        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        toggle.syncState();//同步返回图标与drawerlayout的状态
        drawerLayout.setDrawerListener(toggle);//设置drawerlayout的状态监听
    }

    private void initDrawerLayout() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    }

    private void initActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("主标题");//设置主标题
        actionBar.setSubtitle("副标题");//设置副标题
        actionBar.setIcon(R.drawable.ic_a);//设置icon
        actionBar.setLogo(R.drawable.ic_b);//设置logo
        actionBar.setDisplayShowHomeEnabled(true);//默认情况是false，只有手动设为true，图标才能显示
        actionBar.setDisplayUseLogoEnabled(true);//默认是false，即默认显示的是icon。设置为true，改变了显示优先级，icon隐藏，logo显示。
        actionBar.setDisplayHomeAsUpEnabled(true);//默认是false，回退键是隐藏的。手动设置为true，回退键才能显示。
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home://回退键的id
                toggle.onOptionsItemSelected(item);//drawerlayout与返回键联动。
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
