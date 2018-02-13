package execute.devved.demoapp.activityClass;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.SQLException;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import execute.devved.demoapp.R;
import execute.devved.demoapp.adapterClass.SmsListItemAdapter;
import execute.devved.demoapp.dbClass.DatabaseHandler;
import execute.devved.demoapp.modelClass.SmsEntity;
import execute.devved.demoapp.utils.BMSPrefs;

public class ListActivity extends AppCompatActivity {
    private ProgressDialog progress_dialog;
    private String progress_dialog_msg = "";
    private final int LOAD_CHAPTER_NUMBER_SUCCESS = 2;
    private AsyncLoadFlashcard asyncLoadflashcard;
    private DatabaseHandler databaseHandler;
    ListView favoriten_list;
    TextView backk;
    ArrayList<SmsEntity>entity;
    ArrayList<Object>objectentity;
    private AdView adView;
    String titlename;
    public  static  String name;


    ArrayList<HashMap<String, String>> maplist = new ArrayList<HashMap<String, String>>();
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        titlename= BMSPrefs.getString(getApplicationContext(),"col_name");

        setContentView(R.layout.activity_list);
        entity= new ArrayList<SmsEntity>();
        entity.clear();;
        InitUI();
        InitAction();
    }

    private void InitUI() {
        name=BMSPrefs.getString(getApplicationContext(),"titlename");
        favoriten_list=(ListView)findViewById(R.id.list);
        backk=(TextView) findViewById(R.id.txtback);
        objectentity=new ArrayList<Object>();
//			adView = (AdView)this.findViewById(R.id.adView);
//			 AdRequest request = new AdRequest.Builder().build();
//			 adView.loadAd(request);

        backk.setText(""+name);

    }

    private void InitAction() {
        adView = (AdView)this.findViewById(R.id.adView);
        AdRequest request = new AdRequest.Builder().build();
        adView.loadAd(request);
        load();
        backk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
    private void load() {
        if (asyncLoadflashcard == null
                || asyncLoadflashcard.getStatus() != AsyncTask.Status.RUNNING) {
            asyncLoadflashcard = new AsyncLoadFlashcard();
            asyncLoadflashcard.execute();
        }
    }
    class AsyncLoadFlashcard extends AsyncTask<Void, Void, Void> {
        boolean flag = false;

        @Override
        protected Void doInBackground(Void... params) {
            progress_dialog_msg = "loading";
            mHandler.sendEmptyMessage(SHOW_PROG_DIALOG);

            try {
                databaseHandler = new DatabaseHandler(ListActivity.this);
                databaseHandler.createdatabase();

            } catch (IOException ioe) {
                throw new Error("Unable to create database");
            }
            try {
                databaseHandler.opendatabase();
            } catch (SQLException sqle) {
                throw sqle;
            }

            //entity=databaseHandler.GetAllJavaProgramsList();
            entity=databaseHandler.GetAllList(titlename);
//				for (int i = 0; i < entity.size(); i++) {
//				      objectentity.add(entity.get(i));
//				   }
////
            for (int i = 0; i < maplist.size(); i++) {
//				      objectentity.add(entity.get(i));

                String ss=maplist.get(i).get("count");
                Log.d("shahsai", "" + ss);
            }


            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            mHandler.sendEmptyMessage(HIDE_PROG_DIALOG);
            mHandler.sendEmptyMessage(LOAD_CHAPTER_NUMBER_SUCCESS);
            try{
                SmsListItemAdapter adapter =new SmsListItemAdapter(ListActivity.this,entity);
                favoriten_list.setAdapter(adapter);
                adapter.notifyDataSetChanged();


            }
            catch (Exception e) {
                // TODO: handle exception
            }
        }

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }





    private void showProgDialog() {
//        progress_dialog = null;
//        progress_dialog = new ProgressDialog(ListActivity.this);
//        progress_dialog.setMessage(progress_dialog_msg);
//        progress_dialog.setCancelable(false);
//        progress_dialog.show();
    }

//    private void hideProgDialog() {
//        if (progress_dialog != null && progress_dialog.isShowing())
//            progress_dialog.dismiss();
//    }

    private final int SHOW_PROG_DIALOG = 0;
    private final int HIDE_PROG_DIALOG = 1;
    Handler mHandler = new Handler(new Handler.Callback() {

        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case SHOW_PROG_DIALOG:
                    showProgDialog();
                    break;

                case HIDE_PROG_DIALOG:
                    //hideProgDialog();
                    break;

                case LOAD_CHAPTER_NUMBER_SUCCESS:
                    databaseHandler.close();
                    break;



                default:
                    break;
            }

            return false;
        }
    });



}