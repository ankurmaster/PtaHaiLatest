package patahai.digitopper.com.ptahailatestdesign;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import java.util.ArrayList;

import patahai.digitopper.com.ptahailatestdesign.managers.CachingManager;
import patahai.digitopper.com.ptahailatestdesign.models.FactObject;

public class SearchActivity extends AppCompatActivity{

    private ArrayList<ModelClass> SearchResults = new ArrayList<>();
    private ArrayList<ModelClassForSearch> searchList = new ArrayList<>();
    private SearchView searchView;
    private SearchView.SearchAutoComplete searchAutoComplete;
    private SearchResultAdapter searchResultAdapter;
    private RecyclerView searchResultsRecyclerView;
    ArrayList<FactObject> SearchResultsToDisplay = new ArrayList<>();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initViews();






    }


    private void initViews() {

        searchView = findViewById(R.id.searchView);
        searchResultsRecyclerView = findViewById(R.id.searchResultsRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        searchResultsRecyclerView.setLayoutManager(layoutManager);

        searchResultAdapter = new SearchResultAdapter(getApplicationContext(),SearchResultsToDisplay,this);
        searchResultsRecyclerView.setAdapter(searchResultAdapter);




        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {


                SearchResultsToDisplay.clear();


                for (FactObject modelClass : CachingManager.getEnglishFactList()){

                    if(modelClass.getTitle().toLowerCase().contains(newText.toLowerCase())){

                        SearchResultsToDisplay.add(modelClass);

                    }

                }

                searchResultAdapter.notifyDataSetChanged();


                return true;
            }
        });


    }


    public void activateSearchOnClick(View view) {
        searchView.onActionViewExpanded();

    }


}
