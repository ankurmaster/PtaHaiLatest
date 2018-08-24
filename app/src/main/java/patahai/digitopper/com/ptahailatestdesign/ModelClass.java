package patahai.digitopper.com.ptahailatestdesign;

import java.io.Serializable;

public class ModelClass implements Serializable {


    private String shortDescription;
    private String longDescription;
    private String artworkURL;
    private String factSubCategory;
    private String factParentCategory;
    private String tags;
    private String keys;


    public ModelClass(String shortDescription, String longDescription, String artworkURL, String subCategory, String parentCategory, String tags, String keys) {
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.artworkURL = artworkURL;
        this.factSubCategory = subCategory;
        this.factParentCategory = parentCategory;
        this.tags = tags;
        this.keys = keys;
    }


    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getArtworkURL() {
        return artworkURL;
    }

    public void setArtworkURL(String artworkURL) {
        this.artworkURL = artworkURL;
    }



    public void setFactCategory(String factCategory) {
        this.factSubCategory = factCategory;
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

    public String getFactSubCategory() {
        return factSubCategory;
    }

    public void setFactSubCategory(String factSubCategory) {
        this.factSubCategory = factSubCategory;
    }

    public String getFactParentCategory() {
        return factParentCategory;
    }

    public void setFactParentCategory(String factParentCategory) {
        this.factParentCategory = factParentCategory;
    }
}
