package patahai.digitopper.com.ptahailatestdesign;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.ArrayList;

public class CategoryEntertainment extends Fragment implements View.OnClickListener,GridView.OnItemClickListener {

    private MainActivity activity;
    private GridView entertainmentSubCatGrid;
    private ArrayList<String> subCategoryTitles = new ArrayList<>();
    private ArrayList<Integer> subCategoryIcons = new ArrayList<>();
    private ArrayList<ModelClassForSubCategories> subCategoriesList = new ArrayList<>();



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_entertainment, container, false);

        initDataSet();
        initViews(rootView);


        activity = (MainActivity)getActivity();


        return rootView;
    }

    private void initDataSet() {

        subCategoriesList.add(new ModelClassForSubCategories("Bollywood",R.drawable.bollywood));
        subCategoriesList.add(new ModelClassForSubCategories("Hollywood",R.drawable.hollywood));
        subCategoriesList.add(new ModelClassForSubCategories("Tollywood",R.drawable.tollywood));

    }

    private void initViews(View rootView) {

       // rootView.findViewById(R.id.Bollywood).setOnClickListener(this);
       // rootView.findViewById(R.id.Hollywood).setOnClickListener(this);
      //  entertainmentSubCatGrid = rootView.findViewById(R.id.entertainmentSubCatGrid);
        entertainmentSubCatGrid.setOnItemClickListener(this);
        entertainmentSubCatGrid.setAdapter(new CategoriesGridAdapter(getContext(),subCategoriesList));
    }

    @Override
    public void onClick(View v) {

      /*  switch (v.getId()){

            case R.id.Bollywood:


                activity.addBollywoodFacts();
                activity.sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

                break;

            case R.id.Hollywood:


                activity.addHollywoodfacts();
                activity.sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

                break;

        }*/

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        switch (position){

            case 0:

                activity.addBollywoodFacts();
              //  activity.sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

                break;

            case 1:


               // activity.sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

                break;


        }
    }
}
