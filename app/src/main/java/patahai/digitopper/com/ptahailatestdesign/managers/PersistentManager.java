package patahai.digitopper.com.ptahailatestdesign.managers;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import patahai.digitopper.com.ptahailatestdesign.application.MyApplication;

public class PersistentManager {

    public static void writeContentToSharedPreferences(String key, Object value) {
        //Get App Context
        Context context = MyApplication.getAppContext();

        //Get SharedPreferences
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        //Get SharedPreferences Editor
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //Write content to File
        if (value instanceof String) //String value
        {
            editor.putString(key, ((String) value).trim());
        } else if (value instanceof Boolean) //Boolean value
        {
            editor.putBoolean(key, ((Boolean) value));
        } else if (value instanceof Float) //Float value
        {
            editor.putFloat(key, ((Float) value));
        } else if (value instanceof Integer) //Integer value
        {
            editor.putInt(key, ((Integer) value));
        } else if (value instanceof Long) //Long value
        {
            editor.putLong(key, ((Long) value));
        }

        //Commit Preferences Changes
        editor.commit();
    }

    //Get Content from File
    private static Object getContentFromSharedPreferences(String key, Class<? extends Object> classType) {
        Object object;

        //Get App Context
        Context context = MyApplication.getAppContext();

        //Get SharedPreferences
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        //Get Content from File
        if (classType.equals(String.class)) //String value
        {
            object = sharedPreferences.getString(key, "");
        } else if (classType.equals(Boolean.class)) //Boolean value
        {
            object = sharedPreferences.getBoolean(key, false);

        } else if (classType.equals(Integer.class)) //Integer value
        {
            object = sharedPreferences.getInt(key, 0);
        } else if (classType.equals(Float.class)) //Float value
        {
            object = sharedPreferences.getFloat(key, 0.00f);
        } else if (classType.equals(Long.class)) //Long value
        {
            object = sharedPreferences.getLong(key, 0L);
        } else {
            object = null;
        }

        return object;
    }

    public static void setIsFirstTime(int isFirstTime)
    {
        writeContentToSharedPreferences("isFirstTime",isFirstTime);
    }

    public static int getIsFirstTime()
    {
        return (Integer) getContentFromSharedPreferences("isFirstTime",Integer.class);
    }

}
