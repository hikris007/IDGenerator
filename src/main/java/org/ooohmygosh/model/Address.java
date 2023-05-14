package org.ooohmygosh.model;

public class Address {
    private Country country;
    private Province province;
    private City city;
    private District district;

    public static Address builder(){
        return new Address();
    }

    public static Address of(Country country,Province province,City city,District district){
        return builder()
                .setCountry(country)
                .setProvince(province)
                .setCity(city)
                .setDistrict(district);
    }

    public Country getCountry() {
        return country;
    }

    public Address setCountry(Country country) {
        this.country = country;
        return this;
    }

    public Province getProvince() {
        return province;
    }

    public Address setProvince(Province province) {
        this.province = province;
        return this;
    }

    public City getCity() {
        return city;
    }

    public Address setCity(City city) {
        this.city = city;
        return this;
    }

    public District getDistrict() {
        return district;
    }

    public Address setDistrict(District district) {
        this.district = district;
        return this;
    }
}
