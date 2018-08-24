package patahai.digitopper.com.ptahailatestdesign;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class CategoriesViewpagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> categoriesList = new ArrayList<>();
    private ArrayList<String> categoryTitle = new ArrayList<>();


    public CategoriesViewpagerAdapter(FragmentManager fm) {
        super(fm);

    }

    public void addCategory(Fragment category, String title){

        categoriesList.add(category);
        categoryTitle.add(title);
    }


    @Override
    public Fragment getItem(int position) {
        return categoriesList.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

      return categoryTitle.get(position);
    }

    @Override
    public int getCount() {
        return categoriesList.size();
    }
}
