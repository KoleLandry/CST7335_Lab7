package com.landrykole.testtoolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class TestToolbar extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_toolbar_layout);

        drawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); // Set the toolbar as the action bar

        // Initialize ActionBarDrawerToggle to sync with the drawer with the icon on the toolbar
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // Display the menu icon on the top left of the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Initialize the navigation view so we can handle user input
        NavigationView navView = findViewById(R.id.navigation_view);

        navView.setNavigationItemSelectedListener(item -> {
                if (item.getItemId() == R.id.nav_chat) {
                    // Bring user to the Chat Page
                    startActivity(new Intent(TestToolbar.this, ChatPage.class));
                } else if (item.getItemId() == R.id.nav_weather) {
                    // Bring user to the Weather Forecast Page
                    startActivity(new Intent(TestToolbar.this, WeatherForecast.class));
                } else if (item.getItemId() == R.id.nav_logout) {
                    // Bring user back to the Profile Activity
                    finish();
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.choice_1) {
            // Display output when choosing choice 1
            Toast.makeText(this, "You clicked on item 1", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.choice_2) {
            // Display output when choosing choice 2
            Toast.makeText(this, "You clicked on item 2", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.choice_3) {
            // Display output when choosing choice 3
            Toast.makeText(this, "You clicked on item 3", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.overflow) {
            // Display output when choosing overflow
            Toast.makeText(this, "You clicked on the overflow menu", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
