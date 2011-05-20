package com.actionbartab;

import com.actionbartab.TabFragment4;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;






public class CombinedTabViewM extends LinearLayout
        implements OnTouchListener /*, TabListener, OptionsMenuHandler*/ {

    final static String STARTING_FRAGMENT = "fragment";

    final static int INVALID_ID = 0;
    final static int FRAGMENT_ID_TAB1 = 1;
    final static int FRAGMENT_ID_TAB2 = 2;
    final static int FRAGMENT_ID_TAB3 = 3;

    private Activity mActivity;
    private ActionBar mActionBar;

    private Bundle mExtras;

    int mCurrentFragment = INVALID_ID;

    private int mFragmentIndex=0;
    private int mFragmentDefaultCount=3;
    private int mFragmentCount=0;
    
    
    ActionBar.Tab mTab1;
    ActionBar.Tab mTab2;
    ActionBar.Tab mTab3;


	
    ViewGroup mBookmarksHeader;

    TabFragment0 mFrag0;
	
    TabFragment1 mFrag1;
    TabFragment2 mFrag2;
//    TabFragment3 mFrag3;
    

	private static final String TAG = "com.actionbartab.CombinedTabView";
    



    public CombinedTabViewM(Activity activity,
            int startingFragment, Bundle extras) {
        super(activity);

         Log.e(TAG, "CombinedTabView");
        mActivity = activity;
        mExtras = extras;
        mActionBar = mActivity.getActionBar();

        View v = LayoutInflater.from(activity).inflate(R.layout.tab3, this);
        v.setOnTouchListener(this);
        Resources res = activity.getResources();

        // Start up the default fragment
         mFragmentIndex=0;
        
         initFragments(mExtras,v,mFragmentIndex,mFragmentDefaultCount);
         setupActionBar(startingFragment,mFragmentIndex,mFragmentDefaultCount);
            
        
    }
    

    
    private void initFragments(Bundle extras,View v,int fragindex,int count) {
 
    
        for (int i = 0; i < fragindex; i++) {


        }

    }
    void setupActionBar(int startingFragment,int fragindex,int count) {
    	
 
		
	    Log.e(TAG, "setupActionBar  6");   	
   

    }  
    
    




    private void initFragments(Bundle extras) {
		Log.e(TAG, "initFragments  1");   	
        mFrag0 = TabFragment0.newInstance(
                extras, mBookmarksHeader);
 //       mFrag0.setBreadCrumbMaxVisible(2);
 //       mFrag0.setBreadCrumbUseBackButton(false);
	
        mFrag1 = TabFragment1.newInstance( extras);

        mFrag2 = TabFragment2.newInstance( extras);
 
    }

    private void loadFragment(int id, FragmentTransaction ft) {
        if (mCurrentFragment == id) return;

        switch (id) {
            case FRAGMENT_ID_TAB1:
				Log.e(TAG, "loadFragment  1");   	
                ft.replace(R.id.fragment, mFrag0);
				Log.e(TAG, "loadFragment  2");   	
                break;
            case FRAGMENT_ID_TAB2:
				Log.e(TAG, "loadFragment  3");   	
                ft.replace(R.id.fragment, mFrag1);
			  Log.e(TAG, "loadFragment  4");   	
                break;
            case FRAGMENT_ID_TAB3:
				Log.e(TAG, "loadFragment  4");   	
                ft.replace(R.id.fragment, mFrag2);
			  Log.e(TAG, "loadFragment  5");   	
                break;
            default:
                throw new IllegalArgumentException();
        }
        mCurrentFragment = id;
    }




    public void onTabReselected(Tab tab, FragmentTransaction ft) {
        // Ignore
    }

    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        if (tab == mTab1) {
            loadFragment(FRAGMENT_ID_TAB1, ft);
        } else if (tab == mTab2) {
            loadFragment(FRAGMENT_ID_TAB2, ft);
        } else if (tab == mTab3) {
            loadFragment(FRAGMENT_ID_TAB3, ft);
        } 
        
    	
    }

    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        // Ignore
    }

	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		return false;
	}
	
    private class TabListener implements ActionBar.TabListener {
        private TabFragment4 mFragment;

        public TabListener(TabFragment4 fragment) {
            mFragment = fragment;
        }

        public void onTabSelected(Tab tab, FragmentTransaction ft) {
            ft.add(R.id.fragment_content, mFragment, mFragment.getText());
        }

        public void onTabUnselected(Tab tab, FragmentTransaction ft) {
            ft.remove(mFragment);
        }

        public void onTabReselected(Tab tab, FragmentTransaction ft) {
 //           Toast.makeText(mActivity.this, "Reselected!", Toast.LENGTH_SHORT).show();
        }

    }
	
	
	
	
	
}


