package execute.devved.demoapp.activityClass;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import execute.devved.demoapp.R;
import execute.devved.demoapp.fragmentClass.EnglishFragment;
import execute.devved.demoapp.fragmentClass.HquatesFragment;
import execute.devved.demoapp.fragmentClass.HindiFragment;
import execute.devved.demoapp.fragmentClass.TabFragment;

public class MainActivity extends AppCompatActivity {
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    Fragment fragment;
    private final static String TAG_FRAGMENT = "TAG_FRAGMENT";
    EnglishFragment fragment_one = null;
    HquatesFragment fragment_two = null;
    HindiFragment fragment_three=null;
    private int backcounter=0;
    ViewPager viewpager = null;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         *Setup the DrawerLayout and NavigationView
         */
             mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
             mNavigationView = (NavigationView) findViewById(R.id.shitstuff) ;
        /**
         * Lets inflate the very first fragment
         * Here , we are inflating the TabFragment as the first Fragment
         */
             mFragmentManager = getSupportFragmentManager();
             mFragmentTransaction = mFragmentManager.beginTransaction();
             mFragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();
        /**
         * Setup click events on the Navigation View Items.
         */
             mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();
                 if (menuItem.getItemId() == R.id.nav_item_sent) {
                     FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                     fragmentTransaction.replace(R.id.containerView,new HquatesFragment()).commit();
                 }
                 if (menuItem.getItemId() == R.id.nav_item_draft) {
                     FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                     fragmentTransaction.replace(R.id.containerView,new HquatesFragment()).commit();
                 }
                if (menuItem.getItemId() == R.id.nav_item_inbox) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();
                }
                 return false;
            }

        });

        /**
         * Setup Drawer Toggle of the Toolbar
         */
                android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
                ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, toolbar,R.string.app_name,
                R.string.app_name);
                mDrawerLayout.setDrawerListener(mDrawerToggle);
                mDrawerToggle.syncState();
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(Context _contaxt, FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment f = new Fragment();

            switch (position) {
                case 0:
                    fragment_one = new EnglishFragment();
                    f = fragment_one;
                    break;
                case 1:
                    fragment_two = new HquatesFragment();
                    f = fragment_two;
                    break;
                case 2: fragment_three=new HindiFragment();
                    f=fragment_three;
                    break;
            }
            return f;
        }
        @Override
        public int getCount() {
            return 3;
        }
    }

    @Override
    public void onBackPressed() {
        fragment = ((Fragment) getSupportFragmentManager().findFragmentById(R.id.containerView));

        if(fragment !=null)
        {

            if(fragment.getClass().getName().equals("execute.devved.demoapp.fragmentClass.HquatesFragment"))
            {
                if(mDrawerLayout.isDrawerOpen(GravityCompat.START))
                {
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                }
                else
                {
                    goHome();
                }
            }
            else if (fragment.getClass().getName().equals("execute.devved.demoapp.fragmentClass.TabFragment"))
            {
                if(mDrawerLayout.isDrawerOpen(GravityCompat.START))
                {
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                }
                if (backcounter == 2) {
                    AlertDialog.Builder alert ;
                    if (Build.VERSION.SDK_INT >= 11 ) {
                        alert = new AlertDialog.Builder(MainActivity.this, AlertDialog.THEME_HOLO_LIGHT);
                    }
                    else {
                        alert = new AlertDialog.Builder(MainActivity.this);
                    }
                    alert.setTitle("");
                    alert.setMessage("Do you want to exit this application?");
                    alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                            dialog.dismiss();
                        }
                    });
                    alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog alertDialog = alert.create();
                    alertDialog.show();
                }
                else if (backcounter == 1)
                {
                    Toast.makeText(getApplicationContext(), "Press again to exit", Toast.LENGTH_SHORT).show();
                }
                backcounter++;
                if (backcounter > 2)
                    backcounter = 0;
            }
        }
        else
        {
            super.onBackPressed();
        }
        }
    private void goHome()
    {
        FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
        xfragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();
    }
}