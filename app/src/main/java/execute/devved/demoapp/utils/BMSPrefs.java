package execute.devved.demoapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class BMSPrefs {

	private static SharedPreferences sharedPrefs;
	static String PREF_NAME = "SALESZEN";
	
	
	

	private static void getInstance(Context context) {
		if (sharedPrefs == null)
			sharedPrefs = context.getApplicationContext().getSharedPreferences(
					PREF_NAME, Context.MODE_PRIVATE);
	}



	public static void putInt(Context context, String key, int value) {

		getInstance(context);

		SharedPreferences.Editor edit = sharedPrefs.edit();
		edit.putInt(key, value);
		edit.commit();

	}

	public static int getInt(Context context, String key) {
		getInstance(context);

		int value = sharedPrefs.getInt(key, 0);

		return value;
	}


	public static void putString(Context context, String key, String value) {

		getInstance(context);

		SharedPreferences.Editor edit = sharedPrefs.edit();
		edit.putString(key, value);
		edit.commit();

	}

	public static String getString(Context context, String key) {
		getInstance(context);

		String value = sharedPrefs.getString(key, "");

		return value;
	}

	public static void putBoolean(Context context, String key, boolean value) {

		getInstance(context);

		SharedPreferences.Editor edit = sharedPrefs.edit();
		edit.putBoolean(key, value);
		edit.commit();

	}

	public static boolean getBoolean(Context context, String key) {
		getInstance(context);

		boolean value = sharedPrefs.getBoolean(key, false);

		return value;
	}
	
	
	
	public static void putContactList(Context context, String key, String value) {

		getInstance(context);

		SharedPreferences.Editor edit = sharedPrefs.edit();
		edit.putString(key, value);
		edit.commit();

	}

	public static String getContactList(Context context, String key) {
		getInstance(context);

		String value = sharedPrefs.getString(key, null);

		return value;
	}


	public static void putDouble(Context context, String key, long value) {

		getInstance(context);

		SharedPreferences.Editor edit = sharedPrefs.edit();
		edit.putLong(key, value);
		edit.commit();

	}

	public static String getDouble(Context context, String key) {
		getInstance(context);

		String value = sharedPrefs.getString(key, "N");

		return value;
	}
}
