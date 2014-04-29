package com.eeffa.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ShareActionProvider;

public class MainActivity extends Activity {
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setTitle("Environmental Film Festival");
        addNewsElements();
        addVideoElements();
        addEventElements();
    }
    
    
	private void addEventElements() {
		LinearLayout eventLinearLayout = (LinearLayout)findViewById(R.id.main_event_container);
        for (int i = 0; i < 10; i++) {
        	LinearLayout eventChild = (LinearLayout) getLayoutInflater().inflate(R.layout.main_event_list_element, null);
            eventLinearLayout.addView(eventChild);
		}
	}


	private void addVideoElements() {
		LinearLayout videoLinearLayout = (LinearLayout)findViewById(R.id.main_video_container);
        for (int i = 0; i < 10; i++) {
        	LinearLayout eventChild = (LinearLayout) getLayoutInflater().inflate(R.layout.main_video_list_element, null);
        	videoLinearLayout.addView(eventChild);
		}
	}


	private void addNewsElements() {
		LinearLayout newsLinearLayout = (LinearLayout)findViewById(R.id.main_news_container);
        for (int i = 0; i < 10; i++) {
        	LinearLayout eventChild = (LinearLayout) getLayoutInflater().inflate(R.layout.main_news_list_element, null);
        	newsLinearLayout.addView(eventChild);
		}
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        
        return true;
    }
    
    
    public void onClick_News_Header(View v){
    	startActivityForResult(new Intent(this, NewsListActivity.class), 1);
    }
    
    public void onClick_Video_Header(View v){
    	startActivityForResult(new Intent(this, VideoListActivity.class), 1);
    }
    
    public void onClick_Event_Header(View v){
    	startActivityForResult(new Intent(this, EventListActivity.class), 1);
    }
    
    public void onClick_News_Elment(View v){
    	startActivityForResult(new Intent(this, NwesActivity.class), 1);
    }
    
    public void onClick_Event_Elment(View v){
    	startActivityForResult(new Intent(this, EventActivity.class), 1);
    }
    
    public void onClick_Video_Elment(View v){
    	startActivityForResult(new Intent(this, VideoActivity.class), 1);
    }
    
    public void onClick_Info(MenuItem m){
    	startActivityForResult(new Intent(this, InfoActivity.class), 1);
    }
}
