package biz.osvit.fragmenti.activities;

import android.app.Activity;

public abstract class BaseActivity extends Activity {

	protected abstract void initUi();
	protected abstract void initListeners();
	protected abstract void initData();
	
	
	
}
