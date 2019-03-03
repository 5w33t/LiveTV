package tk.tends2zero.livetv;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new home()).commit();
        }

    }

    public void homepage(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new home()).commit();
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_atnBanglaNewsTV:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new atnnewsTV()).commit();
                break;
            case R.id.menu_catMusicTV:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new fragment_catmusicTV()).commit();
                break;
            case R.id.menu_RTV:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new fragment_RTV()).commit();
                break;
            case R.id.menu_cnnTV:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new fragment_CNNTV()).commit();
                break;
            case R.id.menu_indiaTV:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new fragment_indiaTV()).commit();
                break;
            case R.id.menu_nTV:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new fragment_ntv()).commit();
                break;
            case R.id.menu_somoyTV:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new fragment_somoyTV()).commit();
                break;
            case R.id.menu_report:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new report()).commit();
                break;
            case R.id.menu_about:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new about()).commit();
                break;

        }
        drawer.closeDrawer(GravityCompat.START);

        return true;

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }

        else if(flag==1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new home()).commit();
            flag=0;
        }
        else {
            super.onBackPressed();
        }
    }

    public void developer(View view) {
        Uri uri = Uri.parse("https://www.linkedin.com/in/rahmansweet/"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void channels(View view)
    {
        drawer.openDrawer(GravityCompat.START);
    }

    public void report(View view)
    {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new report()).commit();
        flag = 1;
    }
    public void about(View view)
    {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new about()).commit();
        flag=1;
    }
}
