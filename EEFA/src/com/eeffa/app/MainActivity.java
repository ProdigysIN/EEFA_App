package com.eeffa.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Adding News elements
        LinearLayout newsLinearLayout = (LinearLayout)findViewById(R.id.main_news_container);
        for (int i = 0; i < 10; i++) {
        	LinearLayout eventChild = (LinearLayout) getLayoutInflater().inflate(R.layout.main_news_list_element, null);
        	newsLinearLayout.addView(eventChild);
		}
        
        // Adding Video elements
        LinearLayout videoLinearLayout = (LinearLayout)findViewById(R.id.main_video_container);
        for (int i = 0; i < 10; i++) {
        	LinearLayout eventChild = (LinearLayout) getLayoutInflater().inflate(R.layout.main_video_list_element, null);
        	videoLinearLayout.addView(eventChild);
		}
        
        // Adding Event elements
        LinearLayout eventLinearLayout = (LinearLayout)findViewById(R.id.main_event_container);
        for (int i = 0; i < 10; i++) {
        	LinearLayout eventChild = (LinearLayout) getLayoutInflater().inflate(R.layout.main_news_list_element, null);
            eventLinearLayout.addView(eventChild);
		}
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void onClick_Video(View v){
    	startActivityForResult(new Intent(this, VideoActivity.class), 1);
    	}
    
}
