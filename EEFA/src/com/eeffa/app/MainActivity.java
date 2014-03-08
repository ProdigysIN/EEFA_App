package com.eeffa.app;

import java.util.ArrayList;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final ListView lvNews = (ListView)findViewById(R.id.lvNews);
        String[] newsTitle = new String[]{ "Tree", "Plant", "Bush", "Flower"};
        
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.main_news_list_element, R.id.newsElementTitle, newsTitle);
        lvNews.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
