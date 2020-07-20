package com.tunahanozatac.javamvvm.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddressModel {

    @SerializedName("street")
    @Expose
    public String street;

    @SerializedName("geo")
    @Expose
    public GeoModel geo;

}
