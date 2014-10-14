package com.kemallette.fabulous;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if (savedInstanceState == null)
			getSupportFragmentManager()
				.beginTransaction()
				.add(R.id.container, new FabListFrag())
				.commit();
	}

	public static class FabListFrag extends Fragment{

		private static final String[] CITIES = new String[]{"Dallas", 
		                                                    "New York", 
		                                                    "San Fransisco", 
		                                                    "Seattle", 
		                                                    "Portland", 
		                                                    "Miami", 
		                                                    "Paris", 
		                                                    "Rome", 
		                                                    "Moscow", 
		                                                    "Seoul",
		                                                    "San Paolo",
		                                                    "Houston",
		                                                    "Boston"};
		private ArrayAdapter<String> mAdapter;
		private ListView mList;
		private FloatingActionButton mFab;
		
		public FabListFrag(){}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

			View rootView = inflater.inflate(R.layout.fragment_main, null);
			
			mList = (ListView) rootView.findViewById(R.id.list);
			
			mFab = (FloatingActionButton) rootView.findViewById(R.id.fab);
			mFab.respondTo(mList);
			mFab.setOnClickListener(new OnClickListener(){
				
				@Override
				public void onClick(View v){
				
					Toast.makeText(getActivity(), "FABulously clicked!  :D", Toast.LENGTH_SHORT)
						 .show();
				}
			});
			
			return rootView;
		}

		@Override
        public void onResume(){
			super.onResume();
			
			mAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, CITIES);
			mList.setAdapter(mAdapter);
			
        }
		
		
	}
}
