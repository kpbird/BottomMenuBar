package com.kpbird.bottommenubar;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity implements OnScrollListener{

	private String TAG = this.getClass().getSimpleName();
	private ListView listview;
	private BottomMenuFragment bmfragment;
	private int lastposition;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listview = (ListView) findViewById(R.id.listview);
		String[] countries = getResources().getStringArray(R.array.countries_array);
		ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
		listview.setAdapter(aa);
		listview.setOnScrollListener(this);
		
		bmfragment = (BottomMenuFragment) getFragmentManager().findFragmentById(R.id.fragment_bottom_menu);
		
	}
	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,int visibleItemCount, int totalItemCount) {
		 int currentPosition = view.getFirstVisiblePosition();
	        if(currentPosition > lastposition) {
	            //scroll down
	        	Log.i(TAG,"on Scroll Down");
	        	FragmentTransaction ft = getFragmentManager().beginTransaction();
	        	ft.setCustomAnimations(R.animator.enter, R.animator.exit);
	    		ft.hide(bmfragment);
	    		ft.commit();
	        }
	        if(currentPosition < lastposition) {
	            //scroll up
	        	Log.i(TAG,"on Scroll Up");
	        	FragmentTransaction ft = getFragmentManager().beginTransaction();
	        	ft.setCustomAnimations(R.animator.enter, R.animator.exit);
	    		ft.show(bmfragment);
	    		ft.commit();
	        }
	        lastposition = currentPosition;
	}
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		
	}
}
