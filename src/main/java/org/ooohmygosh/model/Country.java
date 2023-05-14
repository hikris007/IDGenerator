package org.ooohmygosh.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Country {
    @SerializedName("name")
    private String name;

    @SerializedName("provinces")
    private List<Province> provinces;

    public static Country builder(){
        return new Country();
    }

    public Country(){

    }

    public String getName() {
        return name;
    }

    public Country setName(String name) {
        this.name = name;
        return this;
    }

    public List<Province> getProvinces() {
        return provinces;
    }

    public Country setProvinces(List<Province> provinces) {
        this.provinces = provinces;
        return this;
    }
}
