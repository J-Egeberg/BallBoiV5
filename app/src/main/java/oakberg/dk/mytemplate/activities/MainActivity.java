package oakberg.dk.mytemplate.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import oakberg.dk.mytemplate.R;
import oakberg.dk.mytemplate.fragment.Menu;

public class MainActivity extends AppCompatActivity {

    private static SectionStatePagerAdapter sectionStatePagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_fragment_layout);

        sectionStatePagerAdapter = new SectionStatePagerAdapter(getSupportFragmentManager());

        //klargører
        viewPager = (ViewPager) findViewById(R.id.containter);
    }

    private void setUpViewPager(ViewPager viewPager){
        SectionStatePagerAdapter adapter = new SectionStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Menu(), "Menu");
    }

    public void setViewPager(int fragmentNumber){
        viewPager.setCurrentItem(fragmentNumber);
    }
}
//