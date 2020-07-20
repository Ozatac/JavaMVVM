package com.tunahanozatac.javamvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GeoModel {

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("lat")
    @Expose
    public String lat;

    @SerializedName("lng")
    @Expose
    public String lng;
}
