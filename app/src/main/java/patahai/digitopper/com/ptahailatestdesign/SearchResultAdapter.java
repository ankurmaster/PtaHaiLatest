package patahai.digitopper.com.ptahailatestdesign;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import patahai.digitopper.com.ptahailatestdesign.models.FactObject;

public class SearchResultAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context context;
    private ArrayList<FactObject> factsList  = new ArrayList<>();


    public SearchResultAdapter(Context context, ArrayList<FactObject> factsList,SearchActivity searchActivity) {
        this.context = context;
        this.factsList = factsList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(context).inflate(R.layout.search_result,parent,false);

        return new ViewHolderType1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {


        FactObject modelClass = factsList.get(position);
        if(modelClass!=null){


            if(holder instanceof  ViewHolderType1) {

                Glide.with(context).asBitmap().load(modelClass.getImage()).into(((ViewHolderType1) holder).fact_IV_url);
                ((ViewHolderType1) holder).fact_description.setText(modelClass.getTitle());

            }

        }

        ((ViewHolderType1) holder).searchResultParentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context,MainActivity.class);
                intent.putExtra("searchedFactsList",factsList);
                intent.putExtra("listPosi",position);
                context.startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return (factsList==null||factsList.isEmpty())?0:factsList.size();
    }

    public class ViewHolderType1 extends RecyclerView.ViewHolder{

         private ImageView fact_IV_url;
         private TextView fact_description;
         private CardView searchResultParentLayout;

        public ViewHolderType1(View itemView) {
            super(itemView);

            fact_IV_url = itemView.findViewById(R.id.fact_IV);
            fact_description = itemView.findViewById(R.id.fact_description);
            searchResultParentLayout = itemView.findViewById(R.id.searchResultParentLayout);

        }




    }
}
