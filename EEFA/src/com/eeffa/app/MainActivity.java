package com.eeffa.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    @Override
	protected void onStart() {
		// TODO Auto-generated method stub
    	super.onStart();
    	
    	Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenWidth = size.x;
        int screenHeight = size.y;
        
        int categoryHeaderHeight = screenHeight * (1/12);
        int categoryHeaderWidth = screenWidth * (3/12);
        
        FrameLayout newsHeader = (FrameLayout) findViewById(R.id.main_news_header_frame_layout);
        FrameLayout videoHeader = (FrameLayout)findViewById(R.id.main_video_header_frame_layout);
        FrameLayout eventHeader = (FrameLayout)findViewById(R.id.main_event_header_frame_layout);
        
        newsHeader.setLayoutParams(new FrameLayout.LayoutParams(screenWidth, categoryHeaderHeight));
	}


	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        addNewsElements();
        addVideoElements();
        addEventElements();
    }
    
    
	private void addEventElements() {
		LinearLayout eventLinearLayout = (LinearLayout)findViewById(R.id.main_event_container);
        for (int i = 0; i < 10; i++) {
        	LinearLayout eventChild = (LinearLayout) getLayoutInflater().inflate(R.layout.main_news_list_element, null);
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
    
    public void onClick_Video(View v){
    	startActivityForResult(new Intent(this, VideoActivity.class), 1);
    }
    
}
