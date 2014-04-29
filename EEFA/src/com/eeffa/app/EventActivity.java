package com.eeffa.app;

import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.ResourceProxy;
import org.osmdroid.api.IMapController;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.OverlayItem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

public class EventActivity extends Activity {

	private ShareActionProvider mShareActionProvider;
	
	// Map Variables
	private MapView mMapView;
	private IMapController mMapController;
	private ItemizedIconOverlay<OverlayItem> mMyLocationOverlay;
	private ResourceProxy mResourceProxy;
	
	private static final GeoPoint SHKODRA = new GeoPoint(42.0667, 19.5);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mResourceProxy = new DefaultResourceProxyImpl(getApplicationContext());
		setContentView(R.layout.activity_event);
		
		setupMap();
	}
	
	private void setupMap() {
		mMapView = (MapView) findViewById(R.id.mapview);
		// mMapView.setTileSource(TileSourceFactory.MAPNIK);
		mMapView.setMultiTouchControls(true);
		mMapController = mMapView.getController();
		mMapController.setZoom(16);
		mMapController.setCenter(SHKODRA);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.event, menu);
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

}
