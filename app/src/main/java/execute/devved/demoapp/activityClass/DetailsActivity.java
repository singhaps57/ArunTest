package execute.devved.demoapp.activityClass;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

import execute.devved.demoapp.R;
import execute.devved.demoapp.modelClass.SmsEntity;
import execute.devved.demoapp.utils.OnSwipeTouchListener;


/**
 * Hi  Arun r1
 */
public class DetailsActivity extends AppCompatActivity {
    ArrayList<SmsEntity> lang_detail_list;
    int pos=0;
    private ImageView pre_btn;
    private  ImageView next_btn;
    private TextView tvDescription;
    private  TextView tvTitle;
    private  TextView tvsmseNo;
    int new_pos=0;
    private Button copy_btn;
    ImageView share_btn;
    private AdView adView;

    private LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        InitIntentData();
        InitUI();
        InitAction();
    }
    private void InitIntentData() {
        Intent detail=getIntent();
        lang_detail_list=detail.getParcelableArrayListExtra("list");
        pos=detail.getIntExtra("position", 0);
    }

    private void InitUI() {
        linearLayout=(LinearLayout) findViewById(R.id.lsms);
        pre_btn=(ImageView)findViewById(R.id.pre_btn);
        next_btn=(ImageView)findViewById(R.id.next_btn);
        tvDescription=(TextView)findViewById(R.id.tvDescription);
        tvTitle=(TextView)findViewById(R.id.tvTitle);
        tvsmseNo=(TextView)findViewById(R.id.tvsmseNo);
        copy_btn=(Button)findViewById(R.id.copy_btn);
        share_btn=(ImageView)findViewById(R.id.share_btn);


        tvDescription.setText(""+lang_detail_list.get(pos).getTitlName());
        tvDescription.setTypeface(Typeface.DEFAULT);
        tvTitle.setText(""+ListActivity.name);
        tvsmseNo.setText("SHAYARI- "+(pos+1));

        linearLayout.setOnTouchListener(new OnSwipeTouchListener(DetailsActivity.this)
        {
            public void onSwipeLeft() {
                if(pos==0){
                }
                else {
                    pos--;
                }
                Log.d("position", "p"+pos);
                tvDescription.setText(lang_detail_list.get(pos)
                        .getTitlName());
                tvsmseNo.setText("SHAYARI- " + (pos + 1));
            }
            public void onSwipeRight() {
                if(lang_detail_list.size()>pos+1){
                    pos++;
                }
                Log.d("position", "p" + pos);
                tvDescription.setText(lang_detail_list.get(pos)
                        .getTitlName());
                tvsmseNo.setText("SHAYARI- "+(pos+1));
                new_pos=(pos+1);

            }

         });

    }

    private void InitAction() {

        adView = (AdView)this.findViewById(R.id.adView);
        AdRequest request = new AdRequest.Builder().build();
        adView.loadAd(request);
        tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        copy_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", ""+lang_detail_list.get(pos)

                        .getTitlName());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(DetailsActivity.this, "Copy Successfully SMS", Toast.LENGTH_SHORT).show();
            }
        });

        next_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.d("ggg", "g" + lang_detail_list.size());
                if(lang_detail_list.size()>pos+1){
                    pos++;
                }
                Log.d("position", "p"+pos);
                // program_name_title.setText(""+ lang_detail_list.get(pos).getProgram_name() + "\n");

                tvDescription.setText(lang_detail_list.get(pos)

                        .getTitlName());
                tvsmseNo.setText("SHAYARI- "+(pos+1));
                new_pos=(pos+1);

            }
        });
        pre_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if(pos==0){
                }
                else {
                    pos--;
                }
                Log.d("position", "p"+pos);
                tvDescription.setText(lang_detail_list.get(pos)
                        .getTitlName());
                tvsmseNo.setText("SHAYARI- "+(pos+1));

            }
        });

        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, ""+lang_detail_list.get(pos)

                        .getTitlName()+ "\n"+""+lang_detail_list.get(pos).getTitlName());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

    }
}

