package patahai.digitopper.com.ptahailatestdesign.Presenters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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



        if(PersistentManager.getIsFirstTime()==1)
        {

          //  ArrayList<FactObject> list = readFactsFromFile().getFacts();
          //  prepareFactsMap(list);
          //  context.startActivity(new Intent(context.getApplicationContext(),MainActivity.class));
            try {
                userCreateAPI();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }


        }
        else {

            try {
                userCreateAPI();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

        }


    }

    private Facts readFactsFromFile() {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput("FactsList.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {

        } catch (IOException e) {

        }

        Log.e("F",ret);

        Gson gson = new Gson();
        return gson.fromJson(ret, Facts.class);

        }

    private void writeFactsToFile(Facts object) {


        try {

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("FactsList.txt",Context.MODE_PRIVATE));
            outputStreamWriter.write(object.toString());
            outputStreamWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void userCreateAPI() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Call<Facts> request = BConnectAPIClient.getRequest().factList();
        request.enqueue(new BConnectAPICallback<Facts>() {
            @Override
            public void onSuccess(Facts object) {
                ArrayList<FactObject> list = object.getFacts();
                writeFactsToFile(object);
                prepareFactsMap(list);
                context.startActivity(new Intent(context.getApplicationContext(), LanguageSelectorActivity.class));
                PersistentManager.setIsFirstTime(1);
                ((Splash)context).finish();


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
