package com.eeffa.app;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class EventListActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event_list);
		// Show the Up button in the action bar.
		setupActionBar();
		
		LinearLayout eventLinearLayout = (LinearLayout)findViewById(R.id.event_list_layout);
        for (int i = 0; i < 20; i++) {
        	LinearLayout eventChild = (LinearLayout) getLayoutInflater().inflate(R.layout.main_event_list_element, null);
            eventLinearLayout.addView(eventChild);
		}
        
    	Spinner spinner  = (Spinner) findViewById(R.id.spinner1);
    	List<String> list = new ArrayList<String>();
    	list.add("By Country");
    	list.add("By Date");
    	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
    	android.R.layout.simple_spinner_item, list);
    	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	spinner.setAdapter(dataAdapter);
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
		getMenuInflater().inflate(R.menu.event_list, menu);
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

	public void onClick_Event_Elment(View v){
    	startActivityForResult(new Intent(this, EventActivity.class), 1);
    }
}
