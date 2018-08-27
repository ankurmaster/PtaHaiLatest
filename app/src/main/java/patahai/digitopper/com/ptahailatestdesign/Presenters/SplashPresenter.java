package patahai.digitopper.com.ptahailatestdesign.Presenters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import patahai.digitopper.com.ptahailatestdesign.DataLoader;
import patahai.digitopper.com.ptahailatestdesign.LanguageSelectorActivity;
import patahai.digitopper.com.ptahailatestdesign.MainActivity;
import patahai.digitopper.com.ptahailatestdesign.Splash;
import patahai.digitopper.com.ptahailatestdesign.Utills.Constant;
import patahai.digitopper.com.ptahailatestdesign.apiclient.BConnectAPICallback;
import patahai.digitopper.com.ptahailatestdesign.apiclient.BConnectAPIClient;
import patahai.digitopper.com.ptahailatestdesign.interfaces.ConnectionInterface;
import patahai.digitopper.com.ptahailatestdesign.managers.CachingManager;
import patahai.digitopper.com.ptahailatestdesign.managers.PersistentManager;
import patahai.digitopper.com.ptahailatestdesign.models.FactObject;
import patahai.digitopper.com.ptahailatestdesign.models.Facts;
import retrofit2.Call;

public class SplashPresenter implements ConnectionInterface {
    private Context context;

    public SplashPresenter(Context context)
    {
        this.context = context;
    }
    @Override
    public void getFactsFromServer() {
        try
        {
            userCreateAPI();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void userCreateAPI() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Call<Facts> request = BConnectAPIClient.getRequest().factList();
        request.enqueue(new BConnectAPICallback<Facts>() {
            @Override
            public void onSuccess(Facts object) {
                ArrayList<FactObject> list = object.getFacts();
                prepareFactsMap(list);
                if(PersistentManager.getIsFirstTime()==1)
                {
                    context.startActivity(new Intent(context.getApplicationContext(),MainActivity.class));
                }
                else {
                    context.startActivity(new Intent(context.getApplicationContext(), LanguageSelectorActivity.class));
                    PersistentManager.setIsFirstTime(1);
                }
                ((Splash)context).finish();


              /*  for (int i=0;i<list.size();i++) {



                    String language = list.get(i).getLanguage();
                    String parent  = list.get(i).getParent();

                    if(language.equalsIgnoreCase("hindi"))
                    {

                        DataLoader.HundredFacsListHindi.add(list.get(i));

                        if(parent.equalsIgnoreCase("News"))
                        {

                            DataLoader.NewsListHindi.add(list.get(i));

                        }
                        else if(parent.equalsIgnoreCase("Entertainment")){

                            DataLoader.EntertainmentListHindi.add(list.get(i));
                        }
                        else if(parent.equalsIgnoreCase("Knowledge")){

                            DataLoader.KnowledgeListHindi.add(list.get(i));
                        }
                    }
                    else
                    {

                        DataLoader.HundredFacsList.add(list.get(i));

                            if(parent.equalsIgnoreCase("News")){

                            DataLoader.NewsList.add(list.get(i));

                        }else if(parent.equalsIgnoreCase("Entertainment")){

                            DataLoader.EntertainmentList.add(list.get(i));
                        }
                        else if(parent.equalsIgnoreCase("Knowledge")){

                            DataLoader.KnowledgeList.add(list.get(i));
                        }

                    }

                }
*/
            }

            @Override
            public void onError(String errorMessage) {
                Log.d("Error", "onError() called with: errors = [" + errorMessage + "]");

            }
        });
    }

    private void prepareFactsMap(ArrayList<FactObject> list)
    {
        for(FactObject factObject: list)
        {
            switch (factObject.getLanguage())
            {
                case Constant.KEY_HINDI:
                    CachingManager.setHundredFacsListHindi(factObject);
                    switch (factObject.getParent())
                    {
                        case Constant.KEY_ENTERTAINMENT:
                            CachingManager.setEntertainmentListHindiObject(factObject);
                            break;
                        case Constant.KEY_KNOWLEDGE:
                            CachingManager.setKnowledgeListHindiObject(factObject);
                            break;
                        case Constant.KEY_NEWS:
                            CachingManager.setNewsListHindiObject(factObject);
                            break;
                    }
                    break;
                case Constant.KEY_ENGLISH:
                    CachingManager.setHundredFacsList(factObject);
                    switch (factObject.getParent())
                    {
                        case Constant.KEY_ENTERTAINMENT:
                            CachingManager.setEntertainmentListObject(factObject);
                            break;
                        case Constant.KEY_KNOWLEDGE:
                            CachingManager.setKnowledgeListObject(factObject);
                            break;
                        case Constant.KEY_NEWS:
                            CachingManager.setNewsListObject(factObject);
                            break;
                    }
                    break;
            }
        }

    }
}
