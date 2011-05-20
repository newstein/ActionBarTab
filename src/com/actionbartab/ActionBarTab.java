package com.actionbartab;




import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.LoaderManager;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.ContextMenu.ContextMenuInfo;
import android.webkit.WebIconDatabase.IconListener;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupMenu.OnMenuItemClickListener;

/**
 * This demonstrates the use of action bar tabs and how they interact
 * with other action bar features. 
 * 
 *
 */

//implements View.OnCreateContextMenuListener
public  class ActionBarTab extends Activity  {

	private static final String TAG = "ActionBarTab";	
    private CombinedTabView mComboView;
    private boolean  startWithHistory=false;	
    private Tab mActiveTab;
    protected static final FrameLayout.LayoutParams COVER_SCREEN_PARAMS =
        new FrameLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.MATCH_PARENT);
    protected FrameLayout mContentView;    
  
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_ACTION_BAR);
		// TODO Put your code here
//		 final Activity activity =getActivity();
//		setContentView(R.layout.tab);
		Log.e(TAG, "onCreate test3");
		
        mComboView = new CombinedTabView(this,
                startWithHistory ?
                		CombinedTabView.FRAGMENT_ID_TAB1
                        : CombinedTabView.FRAGMENT_ID_TAB2,
                        savedInstanceState);

        Log.e(TAG, "onCreate test3    2");

		setContentView(mComboView);        
        
	}
 

    public void onAddTab(View v) {
        final ActionBar bar = getActionBar();
        final int tabCount = bar.getTabCount();
        final String text = "Tab " + tabCount;
        bar.addTab(bar.newTab()
                .setText(text)
                .setTabListener(new TabListener(new TabContentFragment(text))));
    }

    public void onRemoveTab(View v) {
        final ActionBar bar = getActionBar();
        bar.removeTabAt(bar.getTabCount() - 1);
    }

    public void onToggleTabs(View v) {
        final ActionBar bar = getActionBar();

        if (bar.getNavigationMode() == ActionBar.NAVIGATION_MODE_TABS) {
            bar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
            bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE, ActionBar.DISPLAY_SHOW_TITLE);
        } else {
            bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
            bar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
        }
    }

    public void onRemoveAllTabs(View v) {
        getActionBar().removeAllTabs();
    }

    /**
     * A TabListener receives event callbacks from the action bar as tabs
     * are deselected, selected, and reselected. A FragmentTransaction
     * is provided to each of these callbacks; if any operations are added
     * to it, it will be committed at the end of the full tab switch operation.
     * This lets tab switches be atomic without the app needing to track
     * the interactions between different tabs.
     */
    private class TabListener implements ActionBar.TabListener {
        private TabContentFragment mFragment;

        public TabListener(TabContentFragment fragment) {
            mFragment = fragment;
        }

        public void onTabSelected(Tab tab, FragmentTransaction ft) {
            ft.add(R.id.fragment_content, mFragment, mFragment.getText());
        }

        public void onTabUnselected(Tab tab, FragmentTransaction ft) {
            ft.remove(mFragment);
        }

        public void onTabReselected(Tab tab, FragmentTransaction ft) {
            Toast.makeText(ActionBarTab.this, "Reselected!", Toast.LENGTH_SHORT).show();
        }

    }

    private class TabContentFragment extends Fragment {
        private String mText;

        public TabContentFragment(String text) {
            mText = text;
        }

        public String getText() {
            return mText;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View fragView = inflater.inflate(R.layout.action_bar_tab_content, container, false);

            TextView text = (TextView) fragView.findViewById(R.id.text);
            text.setText(mText);

            return fragView;
        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
    	Log.e(TAG, "onOptionsItemSelected  1");   
        switch (item.getItemId()) {
            case R.id.add_bookmark:
            	Log.e(TAG, "add_bookmark  1");   	
                break;
            case R.id.go_home:
            	Log.e(TAG, "go_home  1");   	
                break;
            case R.id.thumbnail_view:
            	Log.e(TAG, "thumbnail_view  1");   	
                break;
            case R.id.list_view:
            	Log.e(TAG, "list_view  1");   	
                break;
            case R.id.preferences_menu_id:
            	Log.e(TAG, "preferences_menu_id  1");   	
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
/*
    public boolean onContextItemSelected(MenuItem item) {
 
        AdapterView.AdapterContextMenuInfo i =
            (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        // If we have no menu info, we can't tell which item was selected.
        Log.e(TAG, "onContextItemSelected  1");   	
        if (i == null) {
            return false;
        }

        switch (item.getItemId()) {
        case R.id.open_context_menu_id:
        	Log.e(TAG, "open_context_menu_id  1");   	
            break;
        case R.id.edit_context_menu_id:
        	Log.e(TAG, "edit_context_menu_id  1");   
            break;
        case R.id.shortcut_context_menu_id:
        	Log.e(TAG, "shortcut_context_menu_id  1");   
            break;
        case R.id.delete_context_menu_id:
        	Log.e(TAG, "delete_context_menu_id  1");
            break;
        case R.id.new_window_context_menu_id:
        	Log.e(TAG, "new_window_context_menu_id  1");
            break;
        case R.id.share_link_context_menu_id: {
        	Log.e(TAG, "share_link_context_menu_id  1");
            break;
        }
        case R.id.copy_url_context_menu_id:
        	Log.e(TAG, "copy_url_context_menu_id  1");
            break;
        case R.id.homepage_context_menu_id: {
        	Log.e(TAG, "homepage_context_menu_id  1");
            break;
        }


        default:
            return super.onContextItemSelected(item);
        }
        return true;
    }
*/
 
/*
    private MenuItem.OnMenuItemClickListener mContextItemClickListener =
            new MenuItem.OnMenuItemClickListener() {
        public boolean onMenuItemClick(MenuItem item) {
        	Log.e(TAG, "OnMenuItemClickListener  1");
            return onContextItemSelected(item);
        }
    };
*/
    public boolean onCreateOptionsMenu(Menu menu) {
  //      inflater.inflate(R.menu.bookmark, menu);
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.bookmark, menu);
        return true;
    }
/*
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

        int count = menu.size();
        for (int i = 0; i < count; i++) {
            menu.getItem(i).setOnMenuItemClickListener(mContextItemClickListener);
        }
    }
*/


    
    
}
