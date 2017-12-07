package com.example.vadym.toolbar_search;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
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
        // TODO add toolbar to the activity. See AppCompatActivity#setSupportActionBar

        bookListView = findViewById(R.id.bookListView);
        bookAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, getDataList());
        bookListView.setAdapter(bookAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO load menu from the XML file (book_list_menu.xml)

        // TODO Add SearchView.OnQueryTextListener to the search item in the menu
        // TODO use bookAdapter to implement search feature
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // TODO Set checkbox here; Night mode can be simulated as background color.
        return super.onOptionsItemSelected(item);
    }

    private List<String> getDataList(){
        List<String> words = new ArrayList<>();
        words.addAll(Arrays.asList("Apple", "Amazon", "Starbucks", "Disney", "Alphabet",
                "General Electric", "Facebook", "Microsoft"));
        return words;
    }
}
