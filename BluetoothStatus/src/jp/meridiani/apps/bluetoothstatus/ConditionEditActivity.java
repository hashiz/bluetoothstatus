package jp.meridiani.apps.bluetoothstatus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Spinner;

public class ConditionEditActivity extends Activity {

	// data
	private Profile mSelectedProfile;

	// UI Widgets
	private ProfileArrayAdapter mProfileListAdapter;
	private Spinner mProfileSelectSpinner;
	private Button mButtonPositive;
	private Button mButtonNegative;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		try {
			BundleUtil bundle;
			if (savedInstanceState != null) {
				bundle = new BundleUtil(savedInstanceState);
			}
			else {
				// receive intent and extra data
				Intent intent = getIntent();
				if (!com.twofortyfouram.locale.Intent.ACTION_EDIT_CONDITION.equals(intent.getAction())) {
					super.finish();
					return;
				}
		
				bundle = new BundleUtil(getIntent().getBundleExtra(com.twofortyfouram.locale.Intent.EXTRA_BUNDLE));
			}
			mSelectedProfile = bundle.getProfile();
		}
		catch (InvalidBundleException e) {
			// new configuration, set default value
			mSelectedProfile = Profile.ANY;
		}

		// set view
		setContentView(R.layout.activity_edit_condition);

		// profile list
		mProfileSelectSpinner = (Spinner)findViewById(R.id.profile_select_spinner);
		mProfileListAdapter = new ProfileArrayAdapter(this, Profile.values());
		mProfileSelectSpinner.setAdapter(mProfileListAdapter);

		mProfileSelectSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				mSelectedProfile = (Profile)parent.getAdapter().getItem(position);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});

		// button
		mButtonPositive = (Button)findViewById(R.id.profile_select_positive);
		mButtonNegative = (Button)findViewById(R.id.profile_select_negative);

		mButtonPositive.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				saveProfile();
			}
		});
		mButtonNegative.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				cancelEdit();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_condition, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_save_profile:
			saveProfile();
			return true;
		case R.id.action_cancel_edit_condition:
			cancelEdit();
			return true;
		}
		return false;
	}

	@Override
	public void onResume() {
		super.onResume();
		mProfileSelectSpinner.setSelection(mSelectedProfile.ordinal());
	}

	private void saveProfile() {
        Intent resultIntent = new Intent();

		BundleUtil resultBundle = new BundleUtil();
		int pos = mProfileSelectSpinner.getSelectedItemPosition();
		Profile selectedProfile = mProfileListAdapter.getItem(pos);

		resultBundle.setProfile(selectedProfile);
        
        resultIntent.putExtra(com.twofortyfouram.locale.Intent.EXTRA_STRING_BLURB, getString(selectedProfile.getProfileNameResId()));
        resultIntent.putExtra(com.twofortyfouram.locale.Intent.EXTRA_BUNDLE, resultBundle.getBundle());

        setResult(RESULT_OK, resultIntent);
        finish();
        return;
	}

	private void cancelEdit() {
        setResult(RESULT_CANCELED, new Intent());
        finish();
        return;
	}

}
