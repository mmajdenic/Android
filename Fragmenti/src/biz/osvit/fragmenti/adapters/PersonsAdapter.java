package biz.osvit.fragmenti.adapters;

import java.util.ArrayList;

import biz.osvit.fragmenti.R;
import biz.osvit.fragmenti.models.PersonModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PersonsAdapter extends BaseAdapter {

	private Context mContext;
	private ArrayList<PersonModel> mPersonsList;
	private ViewHolder mViewHolder;

	public PersonsAdapter(Context context, ArrayList<PersonModel> items) {
		mContext = context;
		mPersonsList = items;

	}

	@Override
	public int getCount() {
		return mPersonsList.size();
	}

	@Override
	public PersonModel getItem(int position) {
		return mPersonsList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.item_persons_list, parent);

			mViewHolder = new ViewHolder();

			mViewHolder.mFirstNameTextView = (TextView) convertView
					.findViewById(R.id.item_persons_list_ime);
			mViewHolder.mLastNameTextView = (TextView) convertView
					.findViewById(R.id.item_persons_list_prezime);

			convertView.setTag(mViewHolder);

		} else {

			mViewHolder = (ViewHolder) convertView.getTag();

		}
		PersonModel person = getItem(position);

		mViewHolder.mFirstNameTextView.setText(person.getFirstName());
		mViewHolder.mLastNameTextView.setText(person.getLastName());

		return convertView;
	}

	private static class ViewHolder {
		private TextView mFirstNameTextView;
		private TextView mLastNameTextView;
	}

}
