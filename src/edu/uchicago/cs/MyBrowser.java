package edu.uchicago.cs;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

public class MyBrowser extends Activity implements OnKeyListener {
 	
	//TextView txt;
	WebView web;
	EditText edt;
	
	
	@Override			
 	public void onCreate(Bundle savedInstanceState) {
 		super.onCreate(savedInstanceState);
 		setContentView(R.layout.mybrowser);
 		
 		//txt = (TextView) findViewById(R.id.txt);
 		edt = (EditText) findViewById(R.id.edt);
 		edt.setOnKeyListener(this);
 		
 		web = (WebView) findViewById(R.id.web);

 		//the getData is the URI that you passed into the intent. 
 		String strUrl = getIntent().getData().toString();
 		edt.setText(strUrl);
 		web.loadUrl(strUrl);
 		

 		
 	}


	@Override
	public boolean onKey(View v, int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		
		if (keyCode ==  KeyEvent.KEYCODE_ENTER ){
			web.loadUrl(edt.getText().toString());
			return true;
		}
		else {
			return false;
		}

	}

}
