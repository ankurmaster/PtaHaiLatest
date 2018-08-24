package patahai.digitopper.com.ptahailatestdesign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomSearchAdapter extends BaseAdapter implements Filterable{

    private ArrayList<ModelClassForSearch> searchKeyList = new ArrayList<>();
    private ArrayList<ModelClassForSearch> filteredKeyList = new ArrayList<>();
    private Context context;

    public CustomSearchAdapter(ArrayList<ModelClassForSearch> searchKeyList, Context context) {
        this.searchKeyList = searchKeyList;
        this.context = context;
        filteredKeyList = searchKeyList;
    }

    @Override
    public int getCount() {
        return searchKeyList.size();
    }

    @Override
    public Object getItem(int position) {
        return searchKeyList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ModelClassForSearch modelClassForSearch = searchKeyList.get(position);

        if(convertView==null){

            convertView = LayoutInflater.from(context).inflate(R.layout.simple_dropdown,parent,false);
        }

        TextView factText = convertView.findViewById(R.id.factText);
        TextView categoryText = convertView.findViewById(R.id.categoryText);


        if(modelClassForSearch!=null)
        {

            factText.setText(modelClassForSearch.getTags());
            categoryText.setText(modelClassForSearch.getCategories());
        }



        return convertView;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults filterResults = new FilterResults();

                if(constraint==null || constraint.length()==0){

                    searchKeyList = filteredKeyList;
                }
                else {

                    ArrayList<ModelClassForSearch> newSearchkeyList = new ArrayList<>();

                    for (ModelClassForSearch forSearch : searchKeyList) {
                        if (forSearch.getKeys().toLowerCase().contains(constraint.toString().toLowerCase()) || forSearch.getCategories().toLowerCase().contains(constraint.toString().toLowerCase()) || forSearch.getTags().toLowerCase().contains(constraint.toString().toLowerCase()))
                            newSearchkeyList.add(forSearch);
                    }


                        searchKeyList = newSearchkeyList;




                }

                filterResults.values = searchKeyList;


                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                searchKeyList = (ArrayList<ModelClassForSearch>)results.values;
                notifyDataSetChanged();

            }
        };
    }
}
