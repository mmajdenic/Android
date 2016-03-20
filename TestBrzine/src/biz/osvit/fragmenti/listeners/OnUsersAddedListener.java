// Interface 
// -prima samo abstraktne metode

package biz.osvit.fragmenti.listeners;

import java.util.ArrayList;

import biz.osvit.fragmenti.models.PersonModel;

public interface OnUsersAddedListener {

	public void onUsersAdded(ArrayList<PersonModel> users);
	
}
