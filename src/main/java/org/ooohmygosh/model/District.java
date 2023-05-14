package org.ooohmygosh.model;

import com.google.gson.annotations.SerializedName;

public class District {
    @SerializedName("name")
    private String name;
    @SerializedName("code")
    private String code;

    public static District builder(){
        return new District();
    }

    public String getName() {
        return name;
    }

    public District setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public District setCode(String code) {
        this.code = code;
        return this;
    }
}
