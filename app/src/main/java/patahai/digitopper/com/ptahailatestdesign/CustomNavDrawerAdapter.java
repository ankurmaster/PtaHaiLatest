package patahai.digitopper.com.ptahailatestdesign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CustomNavDrawerAdapter extends BaseAdapter {

    private ArrayList<ModelClassForNavDrawer> drawerItemsList = new ArrayList<>();
    private Context context;
    private int viewType=1;
    private int viewNormal;
    private String[] languageSet ={"English","Hindi"};
    private MainActivity activity;

    public CustomNavDrawerAdapter(ArrayList<ModelClassForNavDrawer> drawerItemsList, Context context, MainActivity activity) {
        this.drawerItemsList = drawerItemsList;
        this.context = context;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return drawerItemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return drawerItemsList.get(position);
    }

    @Override
    public int getItemViewType(int position) {

        if(position==2){

            return viewType;
        }

       return viewNormal;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;




        if(getItemViewType(position)==viewNormal) {

            if (view == null) {

                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.nav_drawer_menu_item, parent, false);

                ImageView menu_item_IV = view.findViewById(R.id.menu_item_IV);
                TextView menu_item_TV = view.findViewById(R.id.menu_item_TV);

                ModelClassForNavDrawer modelClassForNavDrawer = drawerItemsList.get(position);

                menu_item_TV.setText(modelClassForNavDrawer.getMenuItemTitle());
                Glide.with(context).load(modelClassForNavDrawer.getMenuItemIcon()).apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE)).into(menu_item_IV);
            }

        }else if(getItemViewType(position)==viewType){


            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.nav_drawer_menu_item_spinner, parent, false);

            ImageView menu_item_IV = view.findViewById(R.id.menu_item_IV);
            TextView menu_item_TV = view.findViewById(R.id.menu_item_TV);
            Spinner language_spinner = view.findViewById(R.id.language_spinner);

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(context,R.layout.spinner_custom_layout,languageSet);
            language_spinner.setAdapter(arrayAdapter);

            if(LanguageSelectorActivity.isEnglish){

                language_spinner.setSelection(0);

            }
            else {


                language_spinner.setSelection(1);
            }

            language_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    if(position==0){

                        activity.addEnglishFacts();
                        activity.navigation_drawer.closeDrawers();
                    }
                    else {

                        activity.addHindiFacts();
                        activity.navigation_drawer.closeDrawers();

                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });


            ModelClassForNavDrawer modelClassForNavDrawer = drawerItemsList.get(position);

            menu_item_TV.setText(modelClassForNavDrawer.getMenuItemTitle());
            Glide.with(context).load(modelClassForNavDrawer.getMenuItemIcon()).apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE)).into(menu_item_IV);


        }

        return view;
    }
}
