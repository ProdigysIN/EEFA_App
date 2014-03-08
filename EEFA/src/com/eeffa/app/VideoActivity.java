package com.eeffa.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;

public class VideoActivity extends Activity implements OnRatingBarChangeListener{

	TextView rt;
	RatingBar rtb;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video);
		rt = (TextView) findViewById(R.id.rating);
		rtb = (RatingBar) findViewById(R.id.ratingBar);
		
		rtb.setOnRatingBarChangeListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.video, menu);
		return true;
	}

	@Override
	public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
		// TODO Auto-generated method stub
		rt.setText("Rating " + rating + "\n");
		if(fromUser)
			rt.setText(rt.getText().toString()+ "Changed by user");
		else
			rt.setText(rt.getText().toString()+ "Changed by function");
		
	}
	
	public void changeRating(View v){
		rtb.setRating(1.5f);
		
	}

}
