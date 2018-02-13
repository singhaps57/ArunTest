package execute.devved.demoapp.fragmentClass;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import execute.devved.demoapp.R;
import execute.devved.demoapp.activityClass.ListActivity;
import execute.devved.demoapp.utils.BMSPrefs;

/**
 * Created by Ratan on 7/29/2015.
 */

public class EnglishFragment extends Fragment implements View.OnClickListener {
    public static final String ARG_ITEM_ID = "home_fragment";
    String fontPath = "fonts/Face Your Fears.ttf";
    private TextView txt_title,txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9;
    private Intent intent;
    private Typeface tf;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.english_layout, null);
        txt_title=(TextView) view.findViewById(R.id.tx_title);
         tf = Typeface.createFromAsset(getActivity().getAssets(), fontPath);
        txt_title.setTypeface(tf);
        txt1=(TextView) view.findViewById(R.id.tx1);
        txt2=(TextView) view.findViewById(R.id.tx2);
        txt3=(TextView) view.findViewById(R.id.tx3);
        txt4=(TextView) view.findViewById(R.id.tx4);
        txt5=(TextView) view.findViewById(R.id.tx5);
        txt6=(TextView) view.findViewById(R.id.tx6);
        txt7=(TextView) view.findViewById(R.id.tx7);
        txt8=(TextView) view.findViewById(R.id.tx8);
        txt9=(TextView) view.findViewById(R.id.tx9);

        txt1.setOnClickListener(this);
        txt2.setOnClickListener(this);
        txt3.setOnClickListener(this);
        txt4.setOnClickListener(this);
        txt5.setOnClickListener(this);
        txt6.setOnClickListener(this);
        txt7.setOnClickListener(this);
        txt8.setOnClickListener(this);
        txt9.setOnClickListener(this);
        txt1.setTypeface(tf);
        txt2.setTypeface(tf);
        txt3.setTypeface(tf);
        txt4.setTypeface(tf);
        txt5.setTypeface(tf);
        txt6.setTypeface(tf);
        txt7.setTypeface(tf);
        txt8.setTypeface(tf);
        txt9.setTypeface(tf);
        return view;
    }
    @Override
    public void onClick(View v) {
         switch (v.getId())
         {
             case R.id.tx1:
             {
                 intent=new Intent(getActivity(), ListActivity.class);
                 BMSPrefs.putString(getActivity(),"col_name","love");
                 BMSPrefs.putString(getActivity(),"titlename","-LOVE-");
                 startActivity(intent);
                 break;
             }
             case R.id.tx2:
             {
                 intent=new Intent(getActivity(), ListActivity.class);
                 BMSPrefs.putString(getActivity(),"col_name","dosti");
                 BMSPrefs.putString(getActivity(),"titlename","-FRIENDSHIP-");
                 startActivity(intent);
                 break;
             }
             case R.id.tx3:
             {
                 intent=new Intent(getActivity(), ListActivity.class);
                 BMSPrefs.putString(getActivity(),"col_name","romantic");
                 BMSPrefs.putString(getActivity(),"titlename","-ROMANTIC-");
                 startActivity(intent);
                 break;
             }
             case R.id.tx4:
             {
                 intent=new Intent(getActivity(), ListActivity.class);
                 BMSPrefs.putString(getActivity(),"col_name","funny");
                 BMSPrefs.putString(getActivity(),"titlename","-FUNNY-");
                 startActivity(intent);
                 break;
             }
             case R.id.tx5:
             {
                 intent=new Intent(getActivity(), ListActivity.class);
                 BMSPrefs.putString(getActivity(),"col_name","bewafa");
                 BMSPrefs.putString(getActivity(),"titlename","-BEWAFA-");
                 startActivity(intent);
                 break;
             }
             case R.id.tx6:
             {
                 intent=new Intent(getActivity(), ListActivity.class);
                 BMSPrefs.putString(getActivity(),"col_name","sharabi");
                 BMSPrefs.putString(getActivity(),"titlename","-SHARABI-");
                 startActivity(intent);
                 break;
             }
             case R.id.tx7:
             {
                 intent=new Intent(getActivity(), ListActivity.class);
                 BMSPrefs.putString(getActivity(),"col_name","morning");
                 BMSPrefs.putString(getActivity(),"titlename","-GOOD MORNING-");
                 startActivity(intent);
                 break;
             }
             case R.id.tx8:
             {
                 intent=new Intent(getActivity(), ListActivity.class);
                 BMSPrefs.putString(getActivity(),"col_name","night");
                 BMSPrefs.putString(getActivity(),"titlename","-GOOD NIGHT-");
                 startActivity(intent);
                 break;
             }
             case R.id.tx9:
             {
                 intent=new Intent(getActivity(), ListActivity.class);
                 BMSPrefs.putString(getActivity(),"col_name","birthday");
                 BMSPrefs.putString(getActivity(),"titlename","-BIRTHDAY-");
                 startActivity(intent);
                 break;
             }

         }
    }
}