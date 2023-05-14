package org.ooohmygosh.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Province {
    @SerializedName("name")
    private String name;
    @SerializedName("code")
    private String code;

    @SerializedName("cities")
    private List<City> cities;

    public static Province builder(){
        return new Province();
    }

    public Province(){

    }

    public String getName() {
        return name;
    }

    public Province setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Province setCode(String code) {
        this.code = code;
        return this;
    }

    public List<City> getCities() {
        return cities;
    }

    public Province setCities(List<City> cities) {
        this.cities = cities;
        return this;
    }
}
