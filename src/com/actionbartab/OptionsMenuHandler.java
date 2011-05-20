package com.actionbartab;

import android.view.Menu;
import android.view.MenuItem;

public interface OptionsMenuHandler {

    boolean onCreateOptionsMenu(Menu menu);
    boolean onPrepareOptionsMenu(Menu menu);
    boolean onOptionsItemSelected(MenuItem item);
}
