package jp.meridiani.apps.bluetoothstatus;

import android.os.Bundle;

class BundleUtil {
    public static final String BUNDLE_BT_PROFILE     = "jp.meridiani.apps.bluetoothstatus.extra.STRING_BT_PROFILE";
    public static final String BUNDLE_BT_PROFILENAME = "jp.meridiani.apps.bluetoothstatus.extra.STRING_BT_PROFILENAME";

    private Bundle mBundle;

	public BundleUtil() {
		mBundle = new Bundle();
	}

	public BundleUtil(Bundle bundle) throws InvalidBundleException {
		mBundle = bundle;
		if (mBundle == null) {
			throw new InvalidBundleException();
		}
		if (mBundle.containsKey(null)) {
			throw new InvalidBundleException();
		}
	}

	public void setProfile(Profile profile) {
		mBundle.putString(BUNDLE_BT_PROFILE, profile.name());
	}

	public void setProfileName(String name) {
		mBundle.putString(BUNDLE_BT_PROFILENAME, name);
	}

	public Profile getProfile() {
		try {
			String s = mBundle.getString(BUNDLE_BT_PROFILE);
			return Profile.valueOf(s);
		}
		catch (NullPointerException | IllegalArgumentException e) {
			return Profile.ANY;
		}
	}

	public String getProfileName () {
		return mBundle.getString(BUNDLE_BT_PROFILENAME);
	}

	public void clear() {
		mBundle.clear();
	}

	public Bundle getBundle() {
		return mBundle;
	}
}
