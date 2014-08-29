package jp.meridiani.apps.bluetoothstatus;

import jp.meridiani.apps.bluetoothstatus.R;

public enum Profile {
	ANY,
	AUDIO,
	HEADSET,
	HEALTH,
	GATT,
	GATTSERVER,
	;

	public int getProfileNameResId() {
		switch (this) {
		case ANY:
			return R.string.profile_item_any;
		case AUDIO:
			return R.string.profile_item_audio;
		case HEADSET:
			return R.string.profile_item_headset;
		case HEALTH:
			return R.string.profile_item_health;
		case GATT:
			return R.string.profile_item_gatt;
		case GATTSERVER:
			return R.string.profile_item_gattserver;
		default:
			return R.string.profile_item_any;
		}
	}
}
