package com.actionbartab;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;




/**
 * Activity for displaying the browser's history, divided into
 * days of viewing.
 */
public  class TabFragment1 extends Fragment
        implements 
        OnItemClickListener {

 
    private static final String TAG = "com.example.fragemnttest.BrowserHistoryPage";

 

 



    static TabFragment1 newInstance( Bundle args) {
    	TabFragment1 bhp = new TabFragment1();
        bhp.setArguments(args);
        return bhp;
    }


  

 

	
	
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
      Log.e(TAG, "BrowserHistoryPage.onCreate  0");
        setHasOptionsMenu(true);
      Log.e(TAG, "BrowserHistoryPage.onCreate 1");
       
 //       mDisableNewWindow = args.getBoolean(BrowserBookmarksPage.EXTRA_DISABLE_WINDOW, false);
	Log.e(TAG, "BrowserHistoryPage.onCreate 2");
//        int mvlimit = getResources().getInteger(R.integer.most_visits_limit);
//        mMostVisitsLimit = Integer.toString(mvlimit);




    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

 	Log.e(TAG, "BrowserHistoryPage.onCreateView  0");		
  //     mRoot = inflater.inflate(R.layout.main_list, container, false);
    View fragView = inflater.inflate(R.layout.main_list, container, false);

    TextView text = (TextView) fragView.findViewById(R.id.text);
    text.setText("This is Tab Fragemtn content");
    Log.e(TAG, "BrowserHistoryPage.onCreateView  2");	
    return fragView;	
 	
 	
    }

    
    
   

    @Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		Log.e(TAG, "BrowserHistoryPage2.onActivityCreated");
		
		
	}


	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);

           Log.e(TAG, "BrowserHistoryPage2.onAttach");
/*
            Intent intent = new Intent(Intent.ACTION_VIEW);
             intent.setClassName(mContext, SplashScreenActivity.class.getName());
			
  //          ((SplashScreenActivity)activity).onAttach(this);
        	Log.e(TAG, "BrowserHistoryPage2.onAttach2");
         mContext.startActivity(intent);
*/
		
	}



    @Override
    public void onDestroy() {
        super.onDestroy();

    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.history, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.clear_history_menu_id:
 
            	  return false;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }



	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}

    
}


