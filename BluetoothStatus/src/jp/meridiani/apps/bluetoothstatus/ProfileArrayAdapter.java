package jp.meridiani.apps.bluetoothstatus;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ProfileArrayAdapter extends ArrayAdapter<Profile> {

	public ProfileArrayAdapter(Context context, Profile[] objects) {
		super(context, android.R.layout.simple_dropdown_item_1line, objects);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = super.getView(position, convertView, parent);
		if (view instanceof TextView) {
			((TextView)view).setText(getItem(position).getProfileNameResId());
		}
		return view;
	}
}
