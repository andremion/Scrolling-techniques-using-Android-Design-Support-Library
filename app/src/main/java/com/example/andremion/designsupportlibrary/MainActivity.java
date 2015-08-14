package com.example.andremion.designsupportlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        List<String> items = new ArrayList<>();
        items.add(getString(R.string.title_activity_coordinator));
        items.add(getString(R.string.title_activity_appbar));
        items.add(getString(R.string.title_activity_tabs));
        items.add(getString(R.string.title_activity_collapsing_toolbar));
        items.add(getString(R.string.title_activity_collapsing_parallax));
        items.add(getString(R.string.title_activity_coordinator_custom_view));

        RecyclerView recyclerView = (RecyclerView) findViewById(android.R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListAdapter adapter = new ListAdapter(items);
        adapter.setOnItemClickListener(new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(getApplicationContext(), CoordinatorActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(), AppBarActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(), TabsActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(getApplicationContext(), CollapsingToolbarActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(getApplicationContext(), CollapsingParallaxActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(getApplicationContext(), CoordinatorCustomViewActivity.class));
                        break;
                }
            }
        });
        recyclerView.setAdapter(adapter);
    }

}
