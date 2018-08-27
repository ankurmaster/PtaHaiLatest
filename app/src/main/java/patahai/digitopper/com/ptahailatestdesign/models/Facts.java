package patahai.digitopper.com.ptahailatestdesign.models;

import java.util.ArrayList;

public class Facts {

    ArrayList<FactObject> facts;

    public ArrayList<FactObject> getFacts() {
        return facts;
    }

    public void setFacts(ArrayList<FactObject> facts) {
        this.facts = facts;
    }

    @Override
    public String toString() {
        return "Facts{" +
                "facts=" + facts +
                "}";
    }
}
