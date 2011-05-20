package com.actionbartab;

import android.app.Activity;
import android.app.Fragment;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
//import android.provider.BrowserContract.ChromeSyncColumns;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.PopupMenu.OnMenuItemClickListener;



/**
 *  View showing the user's bookmarks in the browser.
 */
public class TabFragment4 extends Fragment implements View.OnCreateContextMenuListener,
         OnItemClickListener, 
        OnMenuItemClickListener {



    static final String EXTRA_DISABLE_WINDOW = "disable_new_window";


	private static final String TAG = "com.example.fragemnttest.TabFragment4";
	

    View mRoot;
    GridView mGrid;
    ListView mList;
//    BrowserBookmarksAdapter mAdapter;
    boolean mDisableNewWindow;
    boolean mCanceled = false;
    boolean mEnableContextMenu = true;
    boolean mShowRootFolder = false;
    View mEmptyView;
    int mCurrentView;
    View mHeader;
    ViewGroup mHeaderContainer;
//    BreadCrumbView mCrumbs;
    int mCrumbVisibility = View.VISIBLE;
    int mCrumbMaxVisible = -1;
    boolean mCrumbBackButton = false;
    
    private String mText;

    public TabFragment4(String text) {
        mText = text;
    }

   
    public String getText() {
        return mText;
    }
    

    
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        final Activity activity = getActivity();
        // It is possible that the view has been canceled when we get to
        // this point as back has a higher priority
        if (mCanceled) {
            return false;
        }
        AdapterView.AdapterContextMenuInfo i =
            (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        // If we have no menu info, we can't tell which item was selected.
        if (i == null) {
            return false;
        }

        switch (item.getItemId()) {
        case R.id.open_context_menu_id:
 
            break;
        case R.id.edit_context_menu_id:
 
            break;
        case R.id.shortcut_context_menu_id:
 //           Cursor c = mAdapter.getItem(i.position);
 //           activity.sendBroadcast(createShortcutIntent(getActivity(), c));
            break;
        case R.id.delete_context_menu_id:
   
            break;
        case R.id.new_window_context_menu_id:

            break;
        case R.id.share_link_context_menu_id: {
 
            break;
        }
        case R.id.copy_url_context_menu_id:
   
            break;
        case R.id.homepage_context_menu_id: {

            break;
        }

        default:
            return super.onContextItemSelected(item);
        }
        return true;
    }

  

    private MenuItem.OnMenuItemClickListener mContextItemClickListener =
            new MenuItem.OnMenuItemClickListener() {
        public boolean onMenuItemClick(MenuItem item) {
            return onContextItemSelected(item);
        }
    };

    
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.bookmark, menu);
    }

    
    
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

        int count = menu.size();
        for (int i = 0; i < count; i++) {
            menu.getItem(i).setOnMenuItemClickListener(mContextItemClickListener);
        }
    }

 



	/**
     *  Create a new BrowserBookmarksPage.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        setHasOptionsMenu(true);

        Bundle args = getArguments();
        mDisableNewWindow = args == null ? false : args.getBoolean(EXTRA_DISABLE_WINDOW, false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View fragView = inflater.inflate(R.layout.action_bar_tab_content, container, false);

        TextView text = (TextView) fragView.findViewById(R.id.text);
        text.setText(mText);

        return fragView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

 

    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        // It is possible that the view has been canceled when we get to
        // this point as back has a higher priority
        if (mCanceled) {
 //           android.util.Log.e(LOGTAG, "item clicked when dismissing");
            return;
        }

    }



 




 

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.thumbnail_view:

            return true;
        case R.id.list_view:
  
            return true;
        }
        return super.onOptionsItemSelected(item);
    }









   
  

    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.list_view:
  
            return true;
        case R.id.thumbnail_view:

            return true;
        }
        return false;
    }




    
}


