package com.eeffa.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

	private ShareActionProvider mShareActionProvider;
	
	// YouTube Variables
	static private final String DEVELOPER_KEY = "AIzaSyCD9NoLFZg-CtKpE1hiyH0U8qBHZZbqBmc";
	static private final String VIDEO = "k8gca3fJQpg";
	YouTubePlayerView youTubeView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video);
		
		setupYouTube();
	}

	private void setupYouTube() {
		youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
	    youTubeView.initialize(DEVELOPER_KEY, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.video, menu);
		

        MenuItem shareItem = menu.findItem(R.id.action_share);
        mShareActionProvider = (ShareActionProvider) shareItem.getActionProvider();
        mShareActionProvider.setShareIntent(getDefaultIntent());
        
		return true;
	}

	private Intent getDefaultIntent() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/*");
        return intent;
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
