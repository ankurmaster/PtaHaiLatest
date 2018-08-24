package patahai.digitopper.com.ptahailatestdesign;

import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import patahai.digitopper.com.ptahailatestdesign.models.FactObject;

public class DataLoader {



  /*  public static ArrayList<FactObject>  NewsList = new ArrayList<>();
    public static ArrayList<FactObject>  EntertainmentList = new ArrayList<>();
    public static ArrayList<FactObject>  KnowledgeList = new ArrayList<>();
    public static ArrayList<FactObject>  NewsListHindi = new ArrayList<>();
    public static ArrayList<FactObject>  EntertainmentListHindi = new ArrayList<>();
    public static ArrayList<FactObject>  KnowledgeListHindi = new ArrayList<>();*/
    private static ArrayList<ModelClassForNavDrawer> drawerItemList = new ArrayList<>();
   // public static ArrayList<FactObject> HundredFacsList = new ArrayList<>();
  //  public static ArrayList<FactObject> HundredFacsListHindi = new ArrayList<>();
    public static ArrayList<FactObject> HundredFacsListCopy = new ArrayList<>();
    public static ArrayList<FactObject> SubCatgoryFacts = new ArrayList<>();




   /* public static ArrayList getNewsList(){

        return NewsList;

    }

    public static ArrayList getEntertainmentList(){

        return EntertainmentList;

    }

    public static ArrayList getNewsListHindi(){

        return NewsListHindi;

    }

    public static ArrayList getEntertainmentListHindi(){

        return EntertainmentListHindi;

    }*/


    public static ArrayList getDrawerItemList(){

        drawerItemList.add(new ModelClassForNavDrawer("View Profile",R.drawable.view_profile));
        drawerItemList.add(new ModelClassForNavDrawer("Add Fact",R.drawable.add_fact));
        drawerItemList.add(new ModelClassForNavDrawer("Language",R.drawable.language));
        drawerItemList.add(new ModelClassForNavDrawer("Settings",R.drawable.setting));
        drawerItemList.add(new ModelClassForNavDrawer("Report Errors",R.drawable.report));
        drawerItemList.add(new ModelClassForNavDrawer("Manage Notifications",R.drawable.notification));
        drawerItemList.add(new ModelClassForNavDrawer("Company",R.drawable.company));
        drawerItemList.add(new ModelClassForNavDrawer("Logout",R.drawable.logout));


        return drawerItemList;

    }

   /* public static ArrayList getHundredFactsList(){

        return HundredFacsList;
    }

    public static ArrayList getHundredFactsListHindi(){

        return HundredFacsListHindi;
    }

    public static ArrayList getKnowledgeList(){

        return KnowledgeList;
    }

 public static ArrayList getKnowledgeListHindi(){

        return KnowledgeListHindi;
    }

    public static void copyFacts(){

        HundredFacsListCopy.addAll(HundredFacsList);
    }*/

    public static ArrayList getSubCategoryFacts(String category){

            SubCatgoryFacts.clear();

            for (FactObject factObject : HundredFacsListCopy){

                if(factObject.getCategory().toLowerCase().contains(category.toLowerCase())){


                    SubCatgoryFacts.add(factObject);
                }

                }


        return SubCatgoryFacts;
    }


}
