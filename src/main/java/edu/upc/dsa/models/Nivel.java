package edu.upc.dsa.models;

import edu.upc.dsa.DB.SQLNotInsert;

public class Nivel {
    @SQLNotInsert public String id;
    public String creatorID;
    public String name;

    public Nivel(String creatorid,String Name){
        this.setCreatorID(creatorid);
        this.setName(Name);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(String creatorID) {
        this.creatorID = creatorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
