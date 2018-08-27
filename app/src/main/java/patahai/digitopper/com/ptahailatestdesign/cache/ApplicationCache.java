package patahai.digitopper.com.ptahailatestdesign.cache;

import java.util.ArrayList;
import java.util.HashMap;

import patahai.digitopper.com.ptahailatestdesign.models.FactObject;

public class ApplicationCache {

    private static ApplicationCache applicationCache = null;
    private  HashMap<String,ArrayList<FactObject>> factListMap = new HashMap<>();
    public ArrayList<FactObject>  NewsList = new ArrayList<>();
    public ArrayList<FactObject>  EntertainmentList = new ArrayList<>();
    public ArrayList<FactObject>  KnowledgeList = new ArrayList<>();
    public ArrayList<FactObject>  NewsListHindi = new ArrayList<>();
    public ArrayList<FactObject>  EntertainmentListHindi = new ArrayList<>();
    public ArrayList<FactObject>  KnowledgeListHindi = new ArrayList<>();
    public ArrayList<FactObject> HundredFacsList = new ArrayList<>();
    public ArrayList<FactObject> HundredFacsListHindi = new ArrayList<>();
    public HashMap<String,Integer> TitleInteractionList = new HashMap<>();


    public ArrayList<FactObject> getNewsList() {
        return NewsList;
    }

    public ArrayList<FactObject> getEntertainmentList() {
        return EntertainmentList;
    }

    public ArrayList<FactObject> getKnowledgeList() {
        return KnowledgeList;
    }

    public ArrayList<FactObject> getNewsListHindi() {
        return NewsListHindi;
    }

    public ArrayList<FactObject> getEntertainmentListHindi() {
        return EntertainmentListHindi;
    }

    public ArrayList<FactObject> getKnowledgeListHindi() {
        return KnowledgeListHindi;
    }

    public ArrayList<FactObject> getHundredFacsList() {
        return HundredFacsList;
    }

    public ArrayList<FactObject> getHundredFacsListHindi() {
        return HundredFacsListHindi;
    }

    public HashMap<String, Integer> getTitleInteractionList() {
        return TitleInteractionList;
    }

    private ApplicationCache()
    {


    }
    public static synchronized ApplicationCache getInstance()
    {
        if(applicationCache == null)
        {
            applicationCache = new ApplicationCache();
        }
        return applicationCache;
    }

    public  HashMap<String, ArrayList<FactObject>> getFactListMap() {
        return factListMap;
    }

    public void setFactListMap( String category, ArrayList<FactObject>factList) {
        this.factListMap.put(category,factList);
    }
    public void removeApplicationCache()
    {

        applicationCache = null;
    }
    public void setNewsListObject(FactObject object)
    {
        this.NewsList.add(object);

    }
    public void setNewsListHindiObject(FactObject object)
    {
        this.NewsListHindi.add(object);

    }
    public void setEntertainmentListObject(FactObject object)
    {
        this.EntertainmentList.add(object);
    }
    public void setEntertainmentListHindiObject(FactObject object)
    {
        this.EntertainmentListHindi.add(object);

    }
    public void setKnowledgeListObject(FactObject object)
    {
        this.KnowledgeList.add(object);
    }
    public void setKnowledgeListHindiObject(FactObject object)
    {
        this.KnowledgeListHindi.add(object);
    }
    public void setHundredFacsList(FactObject object)
    {
        this.HundredFacsList.add(object);
    }
    public void setHundredFacsListHindi(FactObject object)
    {
        this.HundredFacsListHindi.add(object);
    }

    public void setStringsOfFactInHashMap(String title, Integer interactions){


        TitleInteractionList.put(title,interactions);

    }
}
