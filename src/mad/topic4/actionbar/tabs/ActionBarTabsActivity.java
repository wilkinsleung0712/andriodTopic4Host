package mad.topic4.actionbar.tabs;


import com.example.topic4_test.R;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

@SuppressWarnings("deprecation")
@SuppressLint("NewApi")
public class ActionBarTabsActivity extends Activity{
	private static final String LOG_TAG = ActionBarTabsActivity.class.getName();
	   
	   /** Called when the activity is first created. */
	   @SuppressWarnings("deprecation")
	@SuppressLint("NewApi")
	@Override
	   public void onCreate(Bundle savedInstanceState)
	   {
		   super.onCreate(savedInstanceState);
		   this.setContentView(R.layout.actionbar_tab);
		   ActionBar bar = this.getActionBar();
		   
		   
		   bar.addTab(bar.newTab().setText("Artists")
				   .setTabListener(new MusicTabListener(new ArtistsFragment(),"Artists")));
	   
		   bar.addTab(bar.newTab().setText("Albums")
		            .setTabListener(new MusicTabListener(new AlbumsFragment(), "Albums")));
		      
		      bar.addTab(bar.newTab().setText("Songs")
		            .setTabListener(new MusicTabListener(new SongsFragment(), "Songs")));
		      
		      bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		      bar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
	   }
	   
	   public class MusicTabListener implements ActionBar.TabListener{
		private Fragment tabFragment;
		private String tabName;
		
		public MusicTabListener(Fragment artistsFragment, String tabName) {
			// TODO Auto-generated constructor stub
			super();
			this.tabFragment=artistsFragment;
			this.tabName=tabName;
		}
		
		

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			 Log.i(LOG_TAG, "Tab selected: " + tabName);
	         
	         ft.add(R.id.realtabcontent, tabFragment, tabName);
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			 ft.remove(tabFragment);
		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
		}
		
		
		   
	   }
	   
	   @Override
	   public boolean onCreateOptionsMenu(Menu menu) {
	       // Inflate the menu items for use in the action bar
	       MenuInflater inflater = getMenuInflater();
	       inflater.inflate(R.menu.action_bar_menu_items, menu);
	       return super.onCreateOptionsMenu(menu);
	   }
	   
	   

}
