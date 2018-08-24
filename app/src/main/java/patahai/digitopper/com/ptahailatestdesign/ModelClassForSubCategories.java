package patahai.digitopper.com.ptahailatestdesign;

import java.io.Serializable;

public class ModelClassForSubCategories implements Serializable {

    private String subCatTitle;
    private Integer subCatIV;

    public ModelClassForSubCategories(String subCatTitle, Integer subCatIV) {
        this.subCatTitle = subCatTitle;
        this.subCatIV = subCatIV;
    }

    public String getSubCatTitle() {
        return subCatTitle;
    }

    public void setSubCatTitle(String subCatTitle) {
        this.subCatTitle = subCatTitle;
    }

    public Integer getSubCatIV() {
        return subCatIV;
    }

    public void setSubCatIV(Integer subCatIV) {
        this.subCatIV = subCatIV;
    }
}
