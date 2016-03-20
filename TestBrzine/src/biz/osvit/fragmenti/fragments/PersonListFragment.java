package biz.osvit.fragmenti.fragments;


import java.util.ArrayList;

import biz.osvit.fragmenti.R;
import biz.osvit.fragmenti.adapters.PersonsAdapter;
import biz.osvit.fragmenti.listeners.OnUsersAddedListener;
import biz.osvit.fragmenti.models.PersonModel;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class PersonListFragment extends BaseFragment implements OnUsersAddedListener {

	private ListView mPersonsListView;
	private PersonsAdapter mPersonsAdapter;
	
	private ArrayList<PersonModel> mPersons;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	View parent = inflater.inflate(R.layout.fragment_persons_list, container, false);
	initUi(parent);
	initListeners();
	return parent;
	
	}
	
	@Override
	public void initUi(View parent) {
		mPersonsListView = (ListView) parent.findViewById(R.id.fragment_persons_list);
		mPersonsAdapter = new PersonsAdapter(getActivity(), mPersons);
		mPersonsListView.setAdapter(mPersonsAdapter);
		
	}

	@Override
	public void initListeners() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUsersAdded(ArrayList<PersonModel> users) {
		mPersons = users;
		
	}

	public static PersonListFragment newInstance(){
		return new PersonListFragment();
	}
	
}
