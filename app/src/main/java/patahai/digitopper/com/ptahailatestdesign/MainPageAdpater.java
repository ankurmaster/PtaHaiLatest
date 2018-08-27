package patahai.digitopper.com.ptahailatestdesign;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import patahai.digitopper.com.ptahailatestdesign.models.FactObject;

public class MainPageAdpater extends FragmentStatePagerAdapter {

    public ArrayList<FactObject> FlashCardList = new ArrayList();
    public HashMap<Integer,SlideFragment> fragList = new HashMap<>();


    public MainPageAdpater(FragmentManager fm) {
        super(fm);

        }

    public void AddFlashCard(ArrayList<FactObject> factsList)
    {
        this.FlashCardList.clear();
        FlashCardList.addAll(factsList);
    }

    @Override
    public Fragment getItem(int position) {
        return getNewFragment(position);
    }

    @Override
    public int getCount() {
        return FlashCardList.size();


    }


    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    private Fragment getNewFragment(int position){

        Bundle bundle = new Bundle();
        bundle.putSerializable("FragObj",FlashCardList.get(position));
        SlideFragment slideFragment = new SlideFragment();
        slideFragment.setArguments(bundle);
        fragList.put(position,slideFragment);


        return slideFragment;
    }

}
