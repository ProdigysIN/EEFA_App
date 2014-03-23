package com.eeffa.app;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoActivity extends YouTubeBaseActivity implements OnRatingBarChangeListener, YouTubePlayer.OnInitializedListener {

	TextView rt;
	RatingBar rtb;
	
	// YouTube Variables
	static private final String DEVELOPER_KEY = "AIzaSyCD9NoLFZg-CtKpE1hiyH0U8qBHZZbqBmc";
	static private final String VIDEO = "k8gca3fJQpg";
	YouTubePlayerView youTubeView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video);
		
		setupYouTube();
		
		TextView videoTitle = (TextView)findViewById(R.id.video_title);
		videoTitle.setText("Dhuna Kibernetike - Siguria ne internet");

		rt = (TextView) findViewById(R.id.rating);
		rtb = (RatingBar) findViewById(R.id.ratingBar);
		rtb.setOnRatingBarChangeListener(this);
		
	}

	private void setupYouTube() {
		youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
	    youTubeView.initialize(DEVELOPER_KEY, this);
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

	@Override
	public void onInitializationFailure(Provider provider, YouTubeInitializationResult error) {
		Toast.makeText(this, "Oh no! "+error.toString(), Toast.LENGTH_LONG).show();
	}

	@Override
	public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
		player.loadVideo(VIDEO);
	}
	
}
