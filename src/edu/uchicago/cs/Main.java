package edu.uchicago.cs;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class Main extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ArrayAdapter adpArray = ArrayAdapter.createFromResource(this,
				R.array.str_intents, android.R.layout.simple_spinner_item);
		adpArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		this.setListAdapter(adpArray);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		super.onListItemClick(l, v, position, id);

		Intent itn = null;
		switch (position) {
		case 0:
			itn = new Intent(
					Intent.ACTION_VIEW,
					Uri.parse("http://www.classes.cs.uchicago.edu/archive/2012/summer/51031-1/"));
			break;
		case 1:
			itn = new Intent(Intent.ACTION_CALL, Uri.parse("tel:800-555-1212"));
			break;
		case 2:
			itn = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:800-555-1212"));
			startActivity(itn);
			break;
		case 3:
			itn = new Intent(Intent.ACTION_VIEW,
					Uri.parse("geo:50.123,7.1434?z=19"));
			break;
		case 4:
			itn = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=query"));
			break;
		case 5:
			itn = new Intent("android.media.action.IMAGE_CAPTURE");
			break;
		case 6:
			itn = new Intent(Intent.ACTION_VIEW,
					Uri.parse("content://contacts/people/"));
			break;
		case 7:
			itn = new Intent(Intent.ACTION_EDIT,
					Uri.parse("content://contacts/people/1"));
			break;
			
		case 8:
			itn = new Intent(Intent.ACTION_SEND);
			itn.setType("text/plain");
			itn.putExtra(android.content.Intent.EXTRA_TEXT, "Android CSPP");
			//startActivity(itn);
			break;

		}
		if (itn != null) {
			startActivity(itn);
		}

	}

}
