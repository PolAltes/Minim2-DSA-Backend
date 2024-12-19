package edu.upc.dsa.models;

import edu.upc.dsa.DB.SQLNotInsert;

public class Message {

    @SQLNotInsert
    public String id;
    public String info;

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public Message(){}

    public Message(String I) {
        this.setInfo(I);
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
