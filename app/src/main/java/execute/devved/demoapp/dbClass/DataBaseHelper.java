package execute.devved.demoapp.dbClass;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DataBaseHelper extends SQLiteOpenHelper
{
      private static String TAG = "DBHelper";
      private static boolean DEBUG =  true;
      private static String PKG;
      private static final String DB_NAME="lang.sqlite";
      private Context mContext;
      private static DataBaseHelper instance;
      
      public static DataBaseHelper getInstance(Context ctx)
      {
              if(instance == null || !ctx.equals(instance.mContext))
              {
                      instance = new DataBaseHelper(ctx);
              }
              return instance;
              
      }
      
      private DataBaseHelper(Context context)
      {
              
              super(context, DB_NAME, null,2);
              mContext = context;
              PKG= "execute.devved.demoapp";
              InputStream iStream;
              FileOutputStream fos;
              File file=new File("/data/data/"+PKG+"/databases/"+DB_NAME);
              if(!file.exists())
              {
                      if(DEBUG) Log.i(TAG, "COPYING DATABASE TO PRIVATE FOLDER");
                      try 
                      {
                              iStream=context.getAssets().open(DB_NAME);
                              new File("/data/data/"+PKG+"/databases").mkdirs();
                              fos=new FileOutputStream(file);
                              byte[] bte =new byte[1024];
                              while(iStream.read(bte)!=-1)
                              {
                                      fos.write(bte);
                              }
                              iStream.close();
                              fos.close();
                              if(DEBUG) Log.i(TAG, "DATABASE SUCCESSFULLY COPIED TO PRIVATE FOLDER");
                      } 
                      catch (IOException e)
                      {
                              if(DEBUG) Log.i(TAG, "ERROR COPYING THE DATABASE");
                              
                      }
              
              }
              
      }

      @Override
      public void onCreate(SQLiteDatabase db)
      {
              
      }

      @Override
      public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
      {
              
      }
    




}
