package com.dreamteam.receipt;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.text.*;

import com.sirqul.sdk.Sirqul;
import com.sirqul.sdk.data.SirqulKeys;
import com.sirqul.sdk.helpers.SirqulCallback;
import com.sirqul.sdk.responses.ProfileResponse;
import com.sirqul.sdk.responses.SirqulResponse;
import com.sirqul.sdk.services.LocationService;
import com.sirqul.sdk.*;
import com.sirqul.sdk.api.common.AccountApi;
import com.sirqul.sdk.interfaces.ISirqulCallback;
import com.sirqul.sdk.responses.AccountLoginResponse;

public class SignUp extends Activity {
	private String user;
	private String password;
	private String confirmPassword;
	private TextView test;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		
		
		// set usernameEditText's TextWatcher
		EditText usernameEditText = (EditText) findViewById(R.id.request_username);
		usernameEditText.addTextChangedListener(usernameEditTextWatcher);
			
		// set passwordEditText's TextWatcher
		EditText passwordEditText = (EditText) findViewById(R.id.password_req);
		usernameEditText.addTextChangedListener(passwordEditTextWatcher);
		
		// set passwordEditText's TextWatcher
		EditText confirmPassEditText = (EditText) findViewById(R.id.re_password_req);
		confirmPassEditText.addTextChangedListener(confirmPassEditTextWatcher);
		
		
		// Initialize Sirqul
		Bundle bundle = new Bundle();
		bundle.putString(Sirqul.PUBLIC_KEY, "301e9419de6c649d7c46337887afb16d");
		bundle.putString(Sirqul.PRIVATE_KEY, "cbd1221fea0b31f34370f7f2b5faad973327d2e4");
		//bundle.putBoolean(Sirqul.LOG_ENABLED, true);
		Sirqul.getInstance().initialize(this.getApplicationContext(), bundle);
		
		
		if(password == confirmPassword){
			createUser();
		}
		else{
			usernameEditText.setText("");
		}
		
		Button submitButton = (Button) findViewById(R.id.try_sign);
		
		submitButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {

				sendSubmit();
				
			}
		});
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
	
	private TextWatcher confirmPassEditTextWatcher = new TextWatcher() {
		// called when the user enters a number
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			confirmPassword = s.toString();
			
		} // end method onTextChanged
		
		@Override
		public void afterTextChanged(Editable s) {
		} // end method afterTextChanged
		
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		}
	};
	
	private void createUser(){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(SirqulKeys.username, user);
		params.put(SirqulKeys.password, password);
		
		Sirqul.getInstance().api().accountApi().createAccount(params, new SirqulCallback<AccountLoginResponse>() {
			@Override
			public void isValid(AccountLoginResponse response) {
				
			}
		});
		
	}
	
	private void sendSubmit(){
    	Intent launchSubActivity = new Intent(this, HomePage.class);
    	
    	//passing information to launched activity
    	
    	startActivity(launchSubActivity);
    }

	
	
}
