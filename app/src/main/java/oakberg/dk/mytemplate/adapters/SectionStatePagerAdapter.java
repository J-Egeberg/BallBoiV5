package oakberg.dk.mytemplate.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oakberg on 06/04/2018.
 */

public class SectionStatePagerAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList<>();

    //det her kan bruges til at holde styr på fragments..
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public SectionStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment (Fragment fragment, String title){
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
