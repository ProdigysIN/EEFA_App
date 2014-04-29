package com.eeffa.app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.support.v4.app.NavUtils;

public class VideoListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video_list);
		// Show the Up button in the action bar.
		setupActionBar();
		
		LinearLayout eventLinearLayout = (LinearLayout)findViewById(R.id.vertical_list);
        for (int i = 0; i < 20; i++) {
        	LinearLayout eventChild = (LinearLayout) getLayoutInflater().inflate(R.layout.main_video_list_element, null);
            eventLinearLayout.addView(eventChild);
		}

		LinearLayout eventLinearLayout1 = (LinearLayout)findViewById(R.id.vertical_list1);
        for (int i = 0; i < 20; i++) {
        	LinearLayout eventChild = (LinearLayout) getLayoutInflater().inflate(R.layout.main_video_list_element, null);
            eventLinearLayout1.addView(eventChild);
		}
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.vertical_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void onClick_Video_Elment(View v){
    	startActivityForResult(new Intent(this, VideoActivity.class), 1);
    }
}
