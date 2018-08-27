package patahai.digitopper.com.ptahailatestdesign.managers;

import java.util.ArrayList;
import java.util.HashMap;

import patahai.digitopper.com.ptahailatestdesign.cache.ApplicationCache;
import patahai.digitopper.com.ptahailatestdesign.models.FactObject;

public class CachingManager {

    public static ArrayList<FactObject> getFactList(String category)
    {
       return ApplicationCache.getInstance().getFactListMap().get(category);
    }

    public static void setFactInMap(String category,ArrayList<FactObject> factObjects)
    {
        ApplicationCache.getInstance().setFactListMap(category,factObjects);
    }
    public static void setNewsListObject(FactObject object)
    {
        ApplicationCache.getInstance().setNewsListObject(object);

    }
    public static void setNewsListHindiObject(FactObject object)
    {
        ApplicationCache.getInstance().setNewsListHindiObject(object);

    }
    public static void setEntertainmentListObject(FactObject object)
    {
        ApplicationCache.getInstance().setEntertainmentListObject(object);
    }
    public static void setEntertainmentListHindiObject(FactObject object)
    {
        ApplicationCache.getInstance().setEntertainmentListHindiObject(object);

    }
    public static void setKnowledgeListObject(FactObject object)
    {
        ApplicationCache.getInstance().setKnowledgeListObject(object);
    }
    public static void setKnowledgeListHindiObject(FactObject object)
    {
        ApplicationCache.getInstance().setKnowledgeListHindiObject(object);

    }
    public static void setHundredFacsList(FactObject object)
    {
        ApplicationCache.getInstance().setHundredFacsList(object);
    }
    public static void setHundredFacsListHindi(FactObject object)
    {
        ApplicationCache.getInstance().setHundredFacsListHindi(object);

    }

    public static void setCurrentINteraction(String title, Integer interaction){

        ApplicationCache.getInstance().setStringsOfFactInHashMap(title,interaction);
    }

    public static ArrayList<FactObject> getEnglishFactList()
    {
        return ApplicationCache.getInstance().getHundredFacsList();
    }

    public static ArrayList<FactObject> getHindiFactList()
    {
        return ApplicationCache.getInstance().getHundredFacsListHindi();
    }
    public static ArrayList<FactObject> getEntertainmentList()
    {
        return ApplicationCache.getInstance().getEntertainmentList();
    }
    public static ArrayList<FactObject> getEntertainmentHindiList()
    {
        return ApplicationCache.getInstance().getEntertainmentListHindi();
    }
    public static ArrayList<FactObject> getKnowledgeList()
    {
        return ApplicationCache.getInstance().getKnowledgeList();
    }
    public static ArrayList<FactObject> getKnowledgeListHindi()
    {
        return ApplicationCache.getInstance().getKnowledgeListHindi();
    }
    public static ArrayList<FactObject> getNewsList()
    {
        return ApplicationCache.getInstance().getNewsList();
    }
    public static ArrayList<FactObject> getNewsHindiList()
    {
        return ApplicationCache.getInstance().getNewsListHindi();
    }
    public static HashMap<String,Integer> getCurrentInteraction(){

        return ApplicationCache.getInstance().getTitleInteractionList();
    }

}
