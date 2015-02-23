package com.dreamteam.receipt;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sirqul.sdk.Sirqul;
import com.sirqul.sdk.data.SirqulKeys;
import com.sirqul.sdk.helpers.SirqulCallback;
import com.sirqul.sdk.responses.ProfileResponse;
import com.sirqul.sdk.responses.SirqulResponse;
import com.sirqul.sdk.services.LocationService;
import com.sirqul.sdk.*;

public class MainActivity extends Activity {
	private String user;
	private String password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_page);
		
		// Initialize Sirqul
		Bundle bundle = new Bundle();
		bundle.putString(Sirqul.PUBLIC_KEY, "301e9419de6c649d7c46337887afb16d");
		bundle.putString(Sirqul.PRIVATE_KEY, "cbd1221fea0b31f34370f7f2b5faad973327d2e4");
		bundle.putBoolean(Sirqul.LOG_ENABLED, true);
		Sirqul.getInstance().initialize(this.getApplicationContext(), bundle);
		
		// set usernameEditText's TextWatcher
		EditText usernameEditText = (EditText) findViewById(R.id.usernametext);
		usernameEditText.addTextChangedListener(usernameEditTextWatcher);
		
		// set passwordEditText's TextWatcher
		EditText passwordEditText = (EditText) findViewById(R.id.passwordtext);
		usernameEditText.addTextChangedListener(passwordEditTextWatcher);
		
		
		
		Button loginButton = (Button) findViewById(R.id.login);
		Button signUpButton = (Button) findViewById(R.id.signup);
        
		
		signUpButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {

				sendSignUp();
				
			}
		});
        loginButton.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View view) {
        		Map<String, Object> params = new HashMap<String, Object>();
        		params.put(SirqulKeys.username, user);
        		params.put(SirqulKeys.password, password);
        		params.put(SirqulKeys.returnProfile, true);
        		//params.put(SirqulKeys.responseFilters, ProfileFilters.getAllValues());
        		Sirqul.getInstance().api().accountApi().getAccount(params, new SirqulCallback<SirqulResponse>() {
        			@Override
        			public void isValid(SirqulResponse response) {
        				ProfileResponse response_Profile = (ProfileResponse) response;
        			}
        		});
        		sendLogin();
        	}
        });
		
		
	}
	
	 private void sendSignUp(){
	    	Intent launchSubActivity = new Intent(this, SignUp.class);
	    	
	    	//passing information to launched activity
	    	
	    	startActivity(launchSubActivity);
	    }
	 private void sendLogin(){
	    	Intent launchSubActivity = new Intent(this, HomePage.class);
	    	
	    	//passing information to launched activity
	    	
	    	startActivity(launchSubActivity);
	    }
	 
	 private TextWatcher usernameEditTextWatcher = new TextWatcher() {
			// called when the user enters a number
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				user = s.toString();
			} // end method onTextChanged
			
			@Override
			public void afterTextChanged(Editable s) {
			} // end method afterTextChanged
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}
		};
		
		private TextWatcher passwordEditTextWatcher = new TextWatcher() {
			// called when the user enters a number
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				password = s.toString();
			} // end method onTextChanged
			
			@Override
			public void afterTextChanged(Editable s) {
			} // end method afterTextChanged
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}
		};
}
