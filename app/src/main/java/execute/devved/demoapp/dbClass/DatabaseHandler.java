package execute.devved.demoapp.dbClass;

import android.app.Activity;
import android.content.ContentValues;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import execute.devved.demoapp.entityClass.MultiLanguageEntity;
import execute.devved.demoapp.modelClass.SmsEntity;

public class DatabaseHandler extends SQLiteOpenHelper {

	public static final String TAG = "DatabaseHandler";

	private SQLiteDatabase db;
	// private boolean isOpened = false;
	private Activity activity;
	String mydate;

	String iname="no";
     private String DB_PATH = "/data/data/execute.devved.demoapp" + "/databases/";
	//private static String DB_NAME = "pmpro.sqlite";
	private static String DB_NAME = "ShayariDb.db";
	

	public DatabaseHandler(Activity activity ) throws IOException {
		super(activity, DB_NAME, null, 1);
		this.activity = activity;
		iname="no";
		boolean dbexist = checkdatabase();
		if (dbexist) {
			Log.d("Trong", "Database exists");
			opendatabase();
		} else {
			System.out.println("Database doesn't exist");
			createdatabase();
		}
	}
	
	public DatabaseHandler(Activity mActivity, String idns)throws IOException {
		// TODO Auto-generated constructor stub
		super(mActivity, DB_NAME, null, 1);
		this.iname = idns;
		this.activity = mActivity;
		boolean dbexist = checkdatabase();
		if (dbexist) {
			Log.d("Trong", "Database exists");
			opendatabase();
		} else {
			System.out.println("Database doesn't exist");
			createdatabase();
		}
	}

	public void createdatabase() throws IOException {
		boolean dbexist = checkdatabase();
		if (dbexist) {
			// System.out.println(" Database exists.");
		} else {
			this.getReadableDatabase();
			try {
				if (iname.equals("no")) {
					copydatabase();	
				}
				else {
					//copydatabasebackup();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private boolean checkdatabase() {
		// SQLiteDatabase checkdb = null;
		boolean checkdb = false;
		try {
			String myPath = DB_PATH + DB_NAME;
			Log.d("Trong", "DB_PATH + DB_NAME " + DB_PATH + DB_NAME);
			File dbfile = new File(myPath);
			// checkdb =
			// SQLiteDatabase.openDatabase(myPath,null,SQLiteDatabase.OPEN_READWRITE);
			checkdb = dbfile.exists();
		} catch (SQLiteException e) {
			Log.d("Trong", "Database doesn't exist");
		}
		return checkdb;
	}

	private void copydatabase() throws IOException {
        AssetManager am = activity.getAssets();
        OutputStream os = new FileOutputStream(DB_PATH + DB_NAME);
        byte[] b = new byte[1024];
        String[] files = am.list("");
        Arrays.sort(files);
        int r;
        for (int i = 1; i <= 1; i++) {
            InputStream is = am.open("ShayariDb.db");
            while ((r = is.read(b)) != -1) {
                os.write(b, 0, r);
            }
            Log.i("BABY_DATABASE_HELPER", "Copying the database (part " + i
                    + " of 9)");
            is.close();
        }
        os.close();
    }

	public void opendatabase() throws SQLException {
		// Open the database
		String mypath = DB_PATH + DB_NAME;
		db = SQLiteDatabase.openDatabase(mypath, null,
                SQLiteDatabase.OPEN_READWRITE);
	}

	public synchronized void close() {
		if (db != null) {
			db.close();
		}
		super.close();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}


	public ArrayList<SmsEntity> GetAllList(String titlename) {
		ArrayList<SmsEntity> faventity = new ArrayList<SmsEntity>();
		String selectQuery = "Select " + titlename + " From ENGLISH_S" + " where " + titlename + " IS NOT NULL";
		Log.d("selectQuery", "" + selectQuery);

		Cursor cursor = db.rawQuery(selectQuery, null);
		Log.d("saved exam question(1", "K" + cursor.getCount());

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				SmsEntity entity = new SmsEntity();
				entity.setTitlName(cursor.getString(0));
//		    entity.setProgram_name(cursor.getString(1));
//		    entity.setId(cursor.getString(2));
//		    entity.setFavorite(cursor.getString(3));

				faventity.add(entity);
			} while (cursor.moveToNext());
		}
		return faventity;

	}


}
