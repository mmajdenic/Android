package biz.osvit.fragmenti.fragments;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import biz.osvit.fragmenti.R;
import biz.osvit.fragmenti.listeners.OnUsersAddedListener;
import biz.osvit.fragmenti.models.PersonModel;

public class AddUserFragment extends BaseFragment {

	public final ArrayList<PersonModel> mPersons = new ArrayList<PersonModel>();
	
	private EditText mFirstNameEditText;
	private EditText mLastNameEditText;

	private Button mAddBtn;
	private Button mSubmitBtn;
	
	private OnUsersAddedListener mUsersAddedListener;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		mUsersAddedListener = (OnUsersAddedListener) activity;
	}

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View parentView = inflater.inflate(R.layout.fragment_add_user,
				container, false);
		initUi(parentView);
		initListeners();
		return parentView;

	}

	@Override
	public void initUi(View parent) {
		
		mFirstNameEditText = (EditText) parent.findViewById(R.id.fragment_add_user_first_txt1);
		mLastNameEditText = (EditText) parent.findViewById(R.id.fragment_add_user_last_txt2);
		
		mAddBtn = (Button) parent.findViewById(R.id.fragment_add_user_add_btn1);
		mSubmitBtn = (Button) parent.findViewById(R.id.fragment_add_user_submit_btn2);
		
	}

	@Override
	public void initListeners() {
		
		mAddBtn.setOnClickListener(mOnClickListener);
		mSubmitBtn.setOnClickListener(mOnClickListener);
	}
	
		private OnClickListener mOnClickListener=new OnClickListener(){
			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.fragment_add_user_add_btn1:
					
					String firstName=mFirstNameEditText.getText().toString();
					String lastName=mLastNameEditText.getText().toString();
					
					PersonModel person = createUser(firstName, lastName);
					mPersons.add(person);
					
					
					break;
				case R.id.fragment_add_user_submit_btn2:
					mUsersAddedListener.onUsersAdded(mPersons);
					break;
				}
				
			}
		};
		
		private PersonModel createUser(String firstName, String lastName) {
			PersonModel person = new PersonModel();
			person.setFirstName(firstName);
			person.setLastName(lastName);
			return person;
		}
}


