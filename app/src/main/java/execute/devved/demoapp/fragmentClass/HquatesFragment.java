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

/**
 * Created by Ratan on 7/29/2015.
 */
public class HquatesFragment extends Fragment implements View.OnClickListener{
    String fontPath = "fonts/CircleD_Font_by_CrazyForMusic.ttf";
    private TextView txt_title,txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10;
    private Intent intent;
    public static final String ARG_ITEM_ID = "sent_fragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.sent_layout,null);

        txt_title=(TextView) view.findViewById(R.id.tx_title);
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), fontPath);
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
        txt10=(TextView) view.findViewById(R.id.tx10);

        txt1.setOnClickListener(this);
        txt2.setOnClickListener(this);
        txt3.setOnClickListener(this);
        txt4.setOnClickListener(this);
        txt5.setOnClickListener(this);
        txt6.setOnClickListener(this);
        txt7.setOnClickListener(this);
        txt8.setOnClickListener(this);
        txt9.setOnClickListener(this);
        txt10.setOnClickListener(this);

        return view;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.tx1:
            {
                intent=new Intent(getActivity(), ListActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.tx2:
            {
                intent=new Intent(getActivity(), ListActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.tx3:
            {
                break;
            }
            case R.id.tx4:
            {
                break;
            }
            case R.id.tx5:
            {
                break;
            }
            case R.id.tx6:
            {
                break;
            }
            case R.id.tx7:
            {
                break;
            }
            case R.id.tx8:
            {
                break;
            }
            case R.id.tx9:
            {
                break;
            }
            case R.id.tx10:
            {
                break;
            }
        }
    }
}