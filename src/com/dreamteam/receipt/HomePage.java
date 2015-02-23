package com.dreamteam.receipt;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
 
import android.os.Bundle;
import android.app.Activity;

public class HomePage extends Activity {
	private InterstitialAd interstitial;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_page);
		
		 //Prepare the Interstitial Ad
				interstitial = new InterstitialAd(this);
				// Insert the Ad Unit ID
				interstitial.setAdUnitId("ca-app-pub-2367452553501966/6324836532");
				//Locate the Banner Ad in activity_main.xml
				AdView adView = (AdView) this.findViewById(R.id.adView);
		 
				// Request for Ads
				AdRequest adRequest = new AdRequest.Builder()
				
				//.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
				//.addTestDevice("abc") 
				.build();
				adView.loadAd(adRequest);
		 
				// Load ads into Banner Ads
				adView.loadAd(adRequest);
				
		ImageButton scanManual = (ImageButton) findViewById(R.id.custom_receipt);
		scanManual.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				sendManual();
			
			}
		});
		ImageButton scanButton = (ImageButton) findViewById(R.id.scan);
		scanButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				sendScan();
			
			}
		});
		
		
		Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Spinner1, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
		Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
		ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.Spinner2, android.R.layout.simple_spinner_item);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner2.setAdapter(adapter2);
		
	}
	private void sendScan(){
		Intent launchSubActivity = new Intent(this, SimpleAndroidOCRActivity.class);
		
		startActivity(launchSubActivity);
	}
	private void sendManual(){
		Intent launchSubActivity = new Intent(this, manualInput.class);
		
		startActivity(launchSubActivity);
	}
}
