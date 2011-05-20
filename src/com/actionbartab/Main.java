package com.actionbartab;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Main extends Activity implements 
          OnItemClickListener {
    /** Called when the activity is first created. */
	private static final String TAG = "com.example.fragemnttest.FragmentTestActivity";
		
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // This needs to be created before setContentView
  
        
        setContentView(R.layout.main);

        
 
        
 
        ListView l = (ListView) findViewById(R.id.number_list);
        ArrayAdapter numbers = new ArrayAdapter<String>(getApplicationContext(),
        		android.R.layout.simple_list_item_1, 
        		new String [] {
        	"Frag1 by google", "Frag2 by sean", "three", "four", "five", "six"
        });
        l.setAdapter(numbers);
        l.setOnItemClickListener(this);
        

        
    }

    
 

	/**
	 * Called when a number gets clicked
	 */
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//		stackAFragment(position + 1);
        switch (position+1) {
        case 1:
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setClassName(this, ActionBarTabG.class.getName());
            this.startActivity(intent);
            break;
        case 2:  // 
            Intent intent2 = new Intent(Intent.ACTION_VIEW);
            intent2.setClassName(this, ActionBarTab.class.getName());
            this.startActivity(intent2);    
            break;
        case 3:  //
            Intent intent3 = new Intent(Intent.ACTION_VIEW);
            intent3.setClassName(this, ActionBarTabG.class.getName());
            this.startActivity(intent3);       	
            break;
        case 4:
            Intent intent4 = new Intent(Intent.ACTION_VIEW);
            intent4.setClassName(this, ActionBarTabG.class.getName());
            this.startActivity(intent4);           
            break;
        default:
	  
            break;
    }	
		
		
	}
	
	


   
    	
}	
