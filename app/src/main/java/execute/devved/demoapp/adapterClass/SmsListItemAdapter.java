package execute.devved.demoapp.adapterClass;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

import execute.devved.demoapp.R;
import execute.devved.demoapp.activityClass.DetailsActivity;
import execute.devved.demoapp.modelClass.SmsEntity;

/**
 * Created by anroid on 24/11/16.
 */
public class SmsListItemAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<SmsEntity> productModelArrayList;

    public SmsListItemAdapter(Context context, ArrayList<SmsEntity> productModelArrayList) {
        mContext = context;
        this.productModelArrayList = productModelArrayList;
    }

    @Override
    public int getCount() {
        return productModelArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView( final int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.adaptersmsitem, viewGroup, false);
        TextView tvTitle = (TextView) view.findViewById(R.id.tvSmstitel);
        LinearLayout ln = (LinearLayout) view.findViewById(R.id.layout_ln);
//        TextView tvDesc = (TextView) view.findViewById(R.id.tvDescription);
        ImageView copy_btn = (ImageView) view.findViewById(R.id.copy_btn);
        ImageView whatsapp = (ImageView) view.findViewById(R.id.whatsapp_btn);
        ImageView share_btn = (ImageView) view.findViewById(R.id.share_btn);
        tvTitle.setText(productModelArrayList.get(i).getTitlName());

        copy_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) mContext.getSystemService(mContext.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", "" + productModelArrayList.get(i)

                        .getTitlName());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(mContext, "Copy Successfully SMS", Toast.LENGTH_SHORT).show();
            }
        });

        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, ""+productModelArrayList.get(i)

                        .getTitlName()+ "\n"+""+productModelArrayList.get(i).getTitlName());
                sendIntent.setType("text/plain");
                mContext.startActivity(sendIntent);

            }
        });

        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PackageManager pm=mContext.getPackageManager();
                try {

                    Intent waIntent = new Intent(Intent.ACTION_SEND);
                    waIntent.setType("text/plain");
                   // String text = "YOUR TEXT HERE";

                    PackageInfo info=pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
                    //Check if package exists or not. If not then code
                    //in catch block will be called
                    waIntent.setPackage("com.whatsapp");

                    waIntent.putExtra(Intent.EXTRA_TEXT, ""+productModelArrayList.get(i).getTitlName());
                   mContext. startActivity(Intent.createChooser(waIntent, "Share with"));

                } catch (PackageManager.NameNotFoundException e) {
                    Toast.makeText(mContext, "WhatsApp not Installed", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
        ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pdetail=new Intent(mContext,DetailsActivity.class);
                pdetail.putParcelableArrayListExtra("list", productModelArrayList);
                pdetail.putExtra("position", i);
                mContext.startActivity(pdetail);

            }
        });


        return view;
    }
}
