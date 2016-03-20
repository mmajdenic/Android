package biz.osvit.fragmenti.fragments;

import android.app.Fragment;
import android.view.View;
import android.widget.ListView;

public abstract class BaseFragment extends Fragment {

	public abstract void initUi(View parent);
	
	public abstract void initListeners();
	
	
	
}	
	

