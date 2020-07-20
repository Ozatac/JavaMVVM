package com.tunahanozatac.javamvvm.model;


import java.io.Serializable;

public class UserModel implements Serializable {

    public String name;


    public UserModel(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
