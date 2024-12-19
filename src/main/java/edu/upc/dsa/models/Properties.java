package edu.upc.dsa.models;

import edu.upc.dsa.DB.SQLNotInsert;
import edu.upc.dsa.DB.SQLNotSelect;

public class Properties {
    @SQLNotInsert public String NivelID;
    @SQLNotInsert public String ElementID;
    public int x;
    public int y;

    public Properties(){}

    public String getNivelID() {
        return NivelID;
    }

    public void setNivelID(String nivelID) {
        NivelID = nivelID;
    }

    public String getElementID() {
        return ElementID;
    }

    public void setElementID(String elementID) {
        ElementID = elementID;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
