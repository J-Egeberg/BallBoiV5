package oakberg.dk.mytemplate.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import oakberg.dk.mytemplate.R;
import oakberg.dk.mytemplate.fragment.Exit;
import oakberg.dk.mytemplate.fragment.AddFood;
import oakberg.dk.mytemplate.fragment.Menu;
import oakberg.dk.mytemplate.fragment.DeliciousFood;
import oakberg.dk.mytemplate.fragment.VegetarianFood;
import oakberg.dk.mytemplate.fragment.QuickFood;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    private static SectionStatePagerAdapter sectionStatePagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started.");

        sectionStatePagerAdapter = new SectionStatePagerAdapter(getSupportFragmentManager());

        //klargører
        viewPager = (ViewPager) findViewById(R.id.containter);

        setUpViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager){
        SectionStatePagerAdapter adapter = new SectionStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Menu(), "Menu");
        adapter.addFragment(new QuickFood(), "QuickFood");
        adapter.addFragment(new DeliciousFood(), "DeliciousFood");
        adapter.addFragment(new VegetarianFood(), "VegetarianFood Score");
        adapter.addFragment(new AddFood(), "AddFood Score");
        adapter.addFragment(new Exit(), "Exit");
        viewPager.setAdapter(adapter);
    }

    public void setViewPager(int fragmentNumber){
        viewPager.setCurrentItem(fragmentNumber);
    }

    @Override
    public void onBackPressed() {
        viewPager.setCurrentItem(0);
    }
}
//