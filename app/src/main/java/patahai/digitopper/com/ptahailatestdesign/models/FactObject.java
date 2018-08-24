package patahai.digitopper.com.ptahailatestdesign.models;

import java.io.Serializable;

public class FactObject implements Serializable {

    String title;
    String image;
    String link;
    String category;
    String language;
    String parent;

    public FactObject(String title, String language, String image, String link, String category, String parent) {
        this.title = title;
        this.language = language;
        this.image = image;
        this.link = link;
        this.category = category;
        this.parent = parent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "FactObject{" +
                "title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", link='" + link + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCategory() {
        String s  = category.split(",")[0];
        return s;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String titleHindi) {
        this.language = titleHindi;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
