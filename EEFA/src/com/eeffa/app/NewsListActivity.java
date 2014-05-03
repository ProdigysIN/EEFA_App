package com.eeffa.app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;

public class NewsListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news_list);
		
		LinearLayout eventLinearLayout = (LinearLayout)findViewById(R.id.news_list_layout);
        for (int i = 0; i < 20; i++) {
        	LinearLayout eventChild = (LinearLayout) getLayoutInflater().inflate(R.layout.main_news_list_element, null);
            eventLinearLayout.addView(eventChild);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.news_list, menu);
		return true;
	}

	public void onClick_News_Elment(View v){
    	startActivityForResult(new Intent(this, NewsActivity.class), 1);
    }
}
