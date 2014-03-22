package com.eeffa.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class news_list extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news_list);
		
        final ListView lvNews = (ListView)findViewById(R.id.lvNews);
        String[] newsTitle = new String[]{ "News1", "News2", "News3", "News4"};
        
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.activity_news, R.id.newsElementTitle, newsTitle);
        lvNews.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.news__list, menu);
		return true;
	}

}
