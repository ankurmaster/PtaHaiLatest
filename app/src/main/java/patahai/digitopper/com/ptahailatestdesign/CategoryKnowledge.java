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

public class CategoryKnowledge extends Fragment implements View.OnClickListener, GridView.OnItemClickListener{

    private MainActivity activity;
    private GridView knowledgeSubCatGrid;
    private ArrayList<String> subCategoryTitles = new ArrayList<>();
    private ArrayList<Integer> subCategoryIcons = new ArrayList<>();
    private ArrayList<ModelClassForSubCategories> subCategoriesList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_knowledge, container, false);

        activity = (MainActivity)getActivity();

        initViews(rootView);

        initDataSet();

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
        knowledgeSubCatGrid = rootView.findViewById(R.id.knowledgeSubCatGrid);
        knowledgeSubCatGrid.setOnItemClickListener(this);
        knowledgeSubCatGrid.setAdapter(new CategoriesGridAdapter(getContext(),subCategoriesList));
    }


    @Override
    public void onClick(View v) {

       /* switch (v.getId()){

            case R.id.current_affairs_IV:

                activity.addCurrentAffairs();
                activity.sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

                break;

            case R.id.nature_IV:

                activity.addNatureFacts();
                activity.sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

                break;

            case R.id.science_IV:

                activity.addScienceFacts();
                activity.sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

                break;

        }*/

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        switch (position){

            case 0:

               // activity.addScienceFacts();
               // activity.sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

                break;

            case 1:

               // activity.sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

                break;

            case 2:

                //activity.sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

                break;

        }
    }
}
