package com.hitglynorthz.dontstarvebasics;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {
	public static int currentPos;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);

		ActionBar actionBar = getActionBar();

		Tab tabNews = actionBar.newTab();
		tabNews.setText("News");
		TabListener<NewsFragment> tabListenerNews = new TabListener<NewsFragment>(this,"News", NewsFragment.class);
		tabNews.setTabListener(tabListenerNews);
		actionBar.addTab(tabNews);

		Tab tabTools = actionBar.newTab();
		tabTools.setText("Tools");
		TabListener<ToolsFragment> tabListenerTools = new TabListener<ToolsFragment>(this,"Tools",ToolsFragment.class);
		tabTools.setTabListener(tabListenerTools);
		actionBar.addTab(tabTools);

		Tab tabLight = actionBar.newTab();
		tabLight.setText("Light");
		TabListener<LightFragment> tabListenerLight = new TabListener<LightFragment>(this,"Light",LightFragment.class);
		tabLight.setTabListener(tabListenerLight);
		actionBar.addTab(tabLight);

		Tab tabSurvival = actionBar.newTab();
		tabSurvival.setText("Survival");
		TabListener<SurvivalFragment> tabListenerSurvival = new TabListener<SurvivalFragment>(this,"Survival",SurvivalFragment.class);
		tabSurvival.setTabListener(tabListenerSurvival);
		actionBar.addTab(tabSurvival);

		Tab tabFood = actionBar.newTab();
		tabFood.setText("Food");
		TabListener<FoodFragment> tabListenerFood = new TabListener<FoodFragment>(this,"Food",FoodFragment.class);
		tabFood.setTabListener(tabListenerFood);
		actionBar.addTab(tabFood);

		Tab tabScience = actionBar.newTab();
		tabScience.setText("Science");
		TabListener<ScienceFragment> tabListenerScience = new TabListener<ScienceFragment>(this,"Science",ScienceFragment.class);
		tabScience.setTabListener(tabListenerScience);
		actionBar.addTab(tabScience);

		Tab tabFight = actionBar.newTab();
		tabFight.setText("Fight");
		TabListener<FightFragment> tabListenerFight = new TabListener<FightFragment>(this,"Fight",FightFragment.class);
		tabFight.setTabListener(tabListenerFight);
		actionBar.addTab(tabFight);

		Tab tabStruct = actionBar.newTab();
		tabStruct.setText("Structures");
		TabListener<StructFragment> tabListenerStruct = new TabListener<StructFragment>(this,"Structures",StructFragment.class);
		tabStruct.setTabListener(tabListenerStruct);
		actionBar.addTab(tabStruct);

		Tab tabRefine = actionBar.newTab();
		tabRefine.setText("Refine");
		TabListener<RefineFragment> tabListenerRefine = new TabListener<RefineFragment>(this,"Refine",RefineFragment.class);
		tabRefine.setTabListener(tabListenerRefine);
		actionBar.addTab(tabRefine);

		Tab tabMagic = actionBar.newTab();
		tabMagic.setText("Magic");
		TabListener<MagicFragment> tabListenerMagic = new TabListener<MagicFragment>(this,"Magic",MagicFragment.class);
		tabMagic.setTabListener(tabListenerMagic);
		actionBar.addTab(tabMagic);

		Tab tabDress = actionBar.newTab();
		tabDress.setText("Dress");
		TabListener<DressFragment> tabListenerDress = new TabListener<DressFragment>(this,"Dress",DressFragment.class);
		tabDress.setTabListener(tabListenerDress);
		actionBar.addTab(tabDress);


		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);	
		actionBar.setDisplayShowHomeEnabled(true);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setDisplayShowCustomEnabled(false);

		 if( savedInstanceState != null ){
	         actionBar.setSelectedNavigationItem(savedInstanceState.getInt("tabState"));
	     }
	}

	private class TabListener<T extends Fragment> implements ActionBar.TabListener
	{
		private Fragment mFragment;
		private final Activity mActivity;
		private final String mTag;
		private final Class<T> mClass;


		 public TabListener(Activity activity,String tag,Class<T> clz)
		 {
			 mActivity = activity;
			 mTag = tag;
			 mClass = clz; 
		 }

		 @Override
		 public void onTabSelected(Tab tab, FragmentTransaction ft) 
		 {

		   currentPos = tab.getPosition();

			Fragment prevFragment;
	        FragmentManager fm = mActivity.getFragmentManager();
	        prevFragment = fm.findFragmentByTag(mTag); 
	        if (prevFragment != null) { 
	            mFragment = prevFragment; 
	        } // \previous Fragment management

			// Check if the fragment is already initialized
			if(mFragment == null){
				// If not, instantiate and add it to the activity:
				mFragment = Fragment.instantiate(mActivity, mClass.getName());
				ft.add(android.R.id.content, mFragment,mTag);
			}else{
				// If it exists, simply attach it in order to show it:
				ft.attach(mFragment);
			}	
		 }

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) 
		{
			currentPos = tab.getPosition();
			if(mFragment != null){
				 // Detach the fragment, because another one is being attached:
				ft.detach(mFragment);
			}else{
				// If not, instantiate and add it to the activity:
				mFragment = Fragment.instantiate(mActivity, mClass.getName());
				ft.add(android.R.id.content, mFragment,mTag);

			}
		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) 
		{
			 // User selected the already selected tab. Usually do nothing.	
		}	
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
	    super.onSaveInstanceState(outState);
	    outState.putInt("tabState", currentPos);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
