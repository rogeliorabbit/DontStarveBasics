package com.hitglynorthz.dontstarvebasics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class SingleListItem extends Activity{
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.single_list_item);
        getActionBar().setDisplayHomeAsUpEnabled(true);
         
        TextView txtProduct = (TextView) findViewById(R.id.SingleItemTitle);
         
        Intent i = getIntent();
        // getting attached intent data
        String title = i.getStringExtra("title");
        setTitle(title);
        // displaying selected product name
        txtProduct.setText(title);
         
    }
    
    @Override 
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
		    break;
		}
		return true; /** true -> consumimos el item, no se propaga*/
	}
    
}
