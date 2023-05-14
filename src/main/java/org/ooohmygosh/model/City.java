package org.ooohmygosh.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class City {
    @SerializedName("name")
    private String name;

    @SerializedName("code")
    private String code;

    @SerializedName("districts")

    private List<District> districts;

    public City(){}

    public static City builder(){
        return new City();
    }

    public String getName() {
        return name;
    }

    public City setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public City setCode(String code) {
        this.code = code;
        return this;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public City setDistricts(List<District> districts) {
        this.districts = districts;
        return this;
    }
}
