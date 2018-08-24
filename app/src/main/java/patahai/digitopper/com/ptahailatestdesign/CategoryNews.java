package patahai.digitopper.com.ptahailatestdesign;

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

public class CategoryNews extends Fragment implements View.OnClickListener,GridView.OnItemClickListener{

    private MainActivity activity;
    private GridView newsSubCatGrid;
    private ArrayList<String> subCategoryTitles = new ArrayList<>();
    private ArrayList<Integer> subCategoryIcons = new ArrayList<>();
    private ArrayList<ModelClassForSubCategories> subCategoriesList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news, container, false);

        activity = (MainActivity)getActivity();

        initViews(rootView);

        initDataSet();

        return rootView;
    }

    private void initViews(View rootView) {

      //  rootView.findViewById(R.id.Politics).setOnClickListener(this);
      //  rootView.findViewById(R.id.Sports).setOnClickListener(this);
        newsSubCatGrid = rootView.findViewById(R.id.newsSubCatGrid);
        newsSubCatGrid.setOnItemClickListener(this);
        newsSubCatGrid.setAdapter(new CategoriesGridAdapter(getContext(),subCategoriesList));


    }

    private void initDataSet() {

        subCategoriesList.add(new ModelClassForSubCategories("Politics",R.drawable.politics));
        subCategoriesList.add(new ModelClassForSubCategories("Sports",R.drawable.sports));
        subCategoriesList.add(new ModelClassForSubCategories("Business",R.drawable.business));

    }


    @Override
    public void onClick(View v) {

       /* switch (v.getId()){

            case R.id.Politics:

                activity.addPoliticsFacts();
                activity.sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

                break;

            case R.id.Sports:

                activity.addSportsFacts();
                activity.sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

                break;

        }/*/

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        switch (position){

            case 0:

               // activity.sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

                break;

            case 1:


                //activity.sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

                break;

        }

    }
}
