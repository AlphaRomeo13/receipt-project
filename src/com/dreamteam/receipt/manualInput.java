package com.dreamteam.receipt;


import android.app.Activity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class manualInput extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custom_input);
		
		EditText receiptName = 
   	         (EditText) findViewById(R.id.receipt_name);
		EditText receiptAmount = 
	   	         (EditText) findViewById(R.id.receipt_amount);
		
		Spinner spinner = (Spinner) findViewById(R.id.receipt_category);
		ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,R.array.Spinner1, android.R.layout.simple_spinner_item);
		adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter3);
		
		Button submitButton = (Button) findViewById(R.id.submitCustom);
		
		submitButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {

				sendSubmit();
				
			}
		});
		
	}
	
	 private void sendSubmit(){
	    	Intent launchSubActivity = new Intent(this, HomePage.class);
	    	
	    	//passing information to launched activity
	    	
	    	startActivity(launchSubActivity);
	    }
}
