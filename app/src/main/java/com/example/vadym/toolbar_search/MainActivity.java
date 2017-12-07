package com.example.vadym.toolbar_search;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView bookListView;
    private ArrayAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.list_toolbar));

        bookListView = findViewById(R.id.bookListView);
        bookAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, getDataList());
        bookListView.setAdapter(bookAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.book_list_menu, menu);

        final MenuItem searchItem = menu.findItem(R.id.actionSearch);
        final SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {

                bookAdapter.getFilter().filter(query);
                // Reset SearchView
                searchView.clearFocus();
                searchView.setQuery("", false);
                searchView.setIconified(true);
                searchItem.collapseActionView();
                // Set activity title to search query
                MainActivity.this.setTitle(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                bookAdapter.getFilter().filter(s);
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.nightModeCheck) {
            item.setChecked(!item.isChecked());
            LinearLayout mainLayout = findViewById(R.id.mainLayout);
            if (item.isChecked()){
                mainLayout.setBackgroundColor(Color.GRAY);
            } else {
                mainLayout.setBackgroundColor(Color.WHITE);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private List<String> getDataList(){
        List<String> words = new ArrayList<>();
        words.addAll(Arrays.asList("Apple", "Amazon", "Starbucks", "Disney", "Alphabet",
                "General Electric", "Facebook", "Microsoft"));
        return words;
    }
}
