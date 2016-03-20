package biz.osvit.fragmenti.activities;

import java.util.ArrayList;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import biz.osvit.fragmenti.R;
import biz.osvit.fragmenti.fragments.AddUserFragment;
import biz.osvit.fragmenti.fragments.PersonListFragment;
import biz.osvit.fragmenti.listeners.OnUsersAddedListener;
import biz.osvit.fragmenti.models.PersonModel;

public class MainActivity extends BaseActivity implements OnUsersAddedListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void initUi() {

		AddUserFragment userFragment = new AddUserFragment();
		FragmentManager manager = getFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.replace(R.id.activity_main_fragment_holder, userFragment);
		transaction.commit();
		
	}

	@Override
	protected void initListeners() {

	}

	@Override
	protected void initData() {

	}

	@Override
	public void onUsersAdded(ArrayList<PersonModel> users) {

		PersonListFragment personListFragment = new PersonListFragment();
		OnUsersAddedListener usersAddedListener = (OnUsersAddedListener) personListFragment;
		usersAddedListener.onUsersAdded(users);

		FragmentManager manager = getFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.replace(R.id.activity_main_fragment_holder, personListFragment);
		transaction.commit();

	}
}
