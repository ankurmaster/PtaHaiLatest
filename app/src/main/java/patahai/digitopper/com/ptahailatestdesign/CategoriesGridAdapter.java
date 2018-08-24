package patahai.digitopper.com.ptahailatestdesign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CategoriesGridAdapter extends BaseAdapter {


    private Context context;
    private ArrayList<ModelClassForSubCategories> subCategoryList = new ArrayList<>();

    public CategoriesGridAdapter(Context context,ArrayList<ModelClassForSubCategories> subCategoryList ) {
        this.context = context;
        this.subCategoryList = subCategoryList;
    }

    @Override
    public int getCount() {
        return subCategoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return subCategoryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        if(convertView==null){

            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.categories_grid_layout,parent,false);
        }

        ImageView subCategoryIV = convertView.findViewById(R.id.subCategoryIV);
        TextView subCategoryTV = convertView.findViewById(R.id.subCategoryTV);

        ModelClassForSubCategories modelClassForSubCategories = subCategoryList.get(position);

        subCategoryTV.setText(modelClassForSubCategories.getSubCatTitle());
        Glide.with(context).load(modelClassForSubCategories.getSubCatIV()).apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE)).into(subCategoryIV);

        return convertView;
    }
}
