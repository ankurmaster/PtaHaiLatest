package patahai.digitopper.com.ptahailatestdesign;

import java.io.Serializable;

public class ModelClassForSearch implements Serializable {


    private String categories;
    private String tags;
    private String keys;


    public ModelClassForSearch(String categories, String tags, String keys) {
        this.categories = categories;
        this.tags = tags;
        this.keys = keys;
    }


    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }


}
