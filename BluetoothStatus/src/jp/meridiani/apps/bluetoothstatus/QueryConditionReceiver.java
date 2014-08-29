package jp.meridiani.apps.bluetoothstatus;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class QueryConditionReceiver extends BroadcastReceiver {
	
	@Override
	public void onReceive(Context context, Intent intent) {
    	if (!com.twofortyfouram.locale.Intent.ACTION_QUERY_CONDITION.equals(intent.getAction())) {
        	return;
        }
		BundleUtil bundle;
		try {
			bundle = new BundleUtil(intent.getBundleExtra(com.twofortyfouram.locale.Intent.EXTRA_BUNDLE));
		} catch (InvalidBundleException e) {
			return;
		}
		Profile profile = bundle.getProfile();
		BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
		BluetoothManager manager = context.getApplicationContext().getSystemService(name)
		if (adapter == null) {
			return;
		}
		if (profile == Profile.ANY) {
			for (BluetoothDevice device : adapter.getBondedDevices()) {
				device.getAddress();
			}
		}
    }


	private boolean isDeviceConnected(String macAddr) {
		BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
		if (adapter == null) {
			return false;
		}
		if (! adapter.isEnabled()) {
			return false;
		}
		for (BluetoothDevice device : adapter.getBondedDevices()) {
			device.
		}
	}
}
