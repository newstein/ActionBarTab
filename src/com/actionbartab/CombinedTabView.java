package com.actionbartab;


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






public class CombinedTabView extends LinearLayout
        implements OnTouchListener, TabListener/*, OptionsMenuHandler*/ {

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
    



    public CombinedTabView(Activity activity,
            int startingFragment, Bundle extras) {
        super(activity);

         Log.e(TAG, "CombinedTabView");
        mActivity = activity;
        mExtras = extras;
        mActionBar = mActivity.getActionBar();

        View v = LayoutInflater.from(activity).inflate(R.layout.tab2, this);
        v.setOnTouchListener(this);
        Resources res = activity.getResources();

/*
           Log.e(TAG, "CombinedTabView  2");
        mBookmarksHeader = new FrameLayout(mActivity);
        mBookmarksHeader.setLayoutParams(new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.MATCH_PARENT,
                Gravity.CENTER_VERTICAL));
*/
        // Start up the default fragment
 //        mFragmentIndex=0;
        
 //        initFragments(mExtras,mFragmentIndex,mFragmentDefaultCount);
 //        setupActionBar(startingFragment,mFragmentIndex,mFragmentDefaultCount);
         

        initFragments(mExtras);

        Log.e(TAG, "CombinedBookmarkHistoryView  4");
         setupActionBar(startingFragment);

        
        
    }
    
    public void onAddTab(View v) {
        final ActionBar bar = mActivity.getActionBar();
        final int tabCount = bar.getTabCount();
        final String text = "Tab " + tabCount;
 //       bar.addTab(bar.newTab()
 //               .setText(text)
 //               .setTabListener(new TabListener(new TabFragment4(text))));
    }

    public void onRemoveTab(View v) {
        final ActionBar bar = mActivity.getActionBar();
        bar.removeTabAt(bar.getTabCount() - 1);
    }

    public void onToggleTabs(View v) {
        final ActionBar bar = mActivity.getActionBar();

        if (bar.getNavigationMode() == ActionBar.NAVIGATION_MODE_TABS) {
            bar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
            bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE, ActionBar.DISPLAY_SHOW_TITLE);
        } else {
            bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
            bar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
        }
    }

    public void onRemoveAllTabs(View v) {
    	mActivity.getActionBar().removeAllTabs();
    }

    
    
    
    
    private void initFragments(Bundle extras,int fragindex,int count) {
 
    
        for (int i = 0; i < fragindex; i++) {


        }
  /*  	
		Log.e(TAG, "initFragments  1");   	
        mFrag0 = TabFragment0.newInstance(
                extras, mBookmarksHeader);
 //       mFrag0.setBreadCrumbMaxVisible(2);
 //       mFrag0.setBreadCrumbUseBackButton(false);
	
        mFrag1 = TabFragment1.newInstance( extras);

        mFrag2 = TabFragment2.newInstance( extras);
 */
    }
    void setupActionBar(int startingFragment,int fragindex,int count) {
    	
     	Log.e(TAG, "setupActionBar  1");
  //     mActionBar = getActionBar();
       if (mActionBar == null) {
           Log.w(TAG, "ActionBar is null.");
       } 
        Log.e(TAG, "configureActionBar  2");   	
    	
        mActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME
                | ActionBar.DISPLAY_USE_LOGO);
        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	    Log.e(TAG, "configureActionBar  3");   		
        mActionBar.removeAllTabs();
		Log.e(TAG, "configureActionBar  4");   	
        mTab1 = mActionBar.newTab();
        mTab1.setText(R.string.tab1);
        mTab1.setTabListener(this);		
        mActionBar.addTab(mTab1, 0);
	    Log.e(TAG, "configureActionBar  5");   		
	    mTab2 = mActionBar.newTab();
	    mTab2.setText(R.string.tab2);
	    mTab2.setTabListener(this);
        mActionBar.addTab(mTab2, 1);

        mTab2 = mActionBar.newTab();
        mTab2.setText(R.string.tab3);
        mTab2.setTabListener(this);		
        mActionBar.addTab(mTab2, 2);

		
	    Log.e(TAG, "configureActionBar  6");   	
   //     mActionBar.setCustomView(mBookmarksHeader);

    }  
    
    
    void setupActionBar(int startingFragment) {
    	
     	Log.e(TAG, "setupActionBar  1");
  //     mActionBar = getActionBar();
       if (mActionBar == null) {
           Log.w(TAG, "ActionBar is null.");
       } 
        Log.e(TAG, "configureActionBar  2");   	
    	
        mActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME
                | ActionBar.DISPLAY_USE_LOGO);
        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	    Log.e(TAG, "configureActionBar  3");   		
        mActionBar.removeAllTabs();
		Log.e(TAG, "configureActionBar  4");   	
        mTab1 = mActionBar.newTab();
        mTab1.setText(R.string.tab1);
        mTab1.setTabListener(this);		
        mActionBar.addTab(mTab1, 0);
	    Log.e(TAG, "configureActionBar  5");   		
	    mTab2 = mActionBar.newTab();
	    mTab2.setText(R.string.tab2);
	    mTab2.setTabListener(this);
        mActionBar.addTab(mTab2, 1);

        mTab2 = mActionBar.newTab();
        mTab2.setText(R.string.tab3);
        mTab2.setTabListener(this);		
        mActionBar.addTab(mTab2, 2);

		
	    Log.e(TAG, "configureActionBar  6");   	
   //     mActionBar.setCustomView(mBookmarksHeader);

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
/*
    public boolean onCreateOptionsMenu(Menu menu) {
        // Handled by fragment
        return false;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        // Handled by fragment
        return false;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
 
            return true;
        case R.id.go_home:
 
            return true;
        case R.id.add_bookmark:
 
            return true;
        case R.id.preferences_menu_id:
 
            return true;
        }

        switch (mCurrentFragment) {
        case FRAGMENT_ID_TAB1:
            return mFrag0.onOptionsItemSelected(item);
        case FRAGMENT_ID_TAB2:
            return mFrag1.onOptionsItemSelected(item);
        case FRAGMENT_ID_TAB3:
            return mFrag2.onOptionsItemSelected(item);            
            
        }
        return false;
    }
*/
	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		return false;
	}
}

