package org.ooohmygosh.utils;

import org.ooohmygosh.model.*;

import java.util.Iterator;
import java.util.List;

public class AddressIterator implements Iterator<Address>,Cloneable {
    private Country tree;

    private int currentProvinceIndex;
    private int currentCityIndex;
    private int currentDistrictIndex;

    public AddressIterator(Country country){
        this.tree = country;
        this.currentProvinceIndex = 0;
        this.currentCityIndex = 0;
        this.currentDistrictIndex = 0;
    }

    @Override
    public boolean hasNext() {
        if(this.tree == null || this.tree.getProvinces() == null)
            return false;

        List<Province> provinces = this.tree.getProvinces();

        while (this.currentProvinceIndex < provinces.size()){
            Province province = provinces.get(this.currentProvinceIndex);
            List<City> cities = province.getCities();
            List<District> districts = null;
            City city = null;

            if(
               cities != null &&
               cities.size() > 0 &&
               (city = cities.get(this.currentCityIndex)) != null &&
               (districts = city.getDistricts()) != null &&
               this.currentDistrictIndex < districts.size()
            ){
                return true;
            }else{
                this.currentProvinceIndex++;
            }

        }

        return false;
    }

    @Override
    public Address next() {
        if(!hasNext()){
            return null;
        }

        Country country = Country.builder().setName(this.tree.getName());
        Province province = this.tree.getProvinces().get(this.currentProvinceIndex);
        City city = province.getCities().get(this.currentCityIndex);
        District district = city.getDistricts().get(this.currentDistrictIndex);

        this.currentDistrictIndex++;

        if(this.currentDistrictIndex >= city.getDistricts().size()){
            this.currentDistrictIndex = 0;
            this.currentCityIndex++;
        }

        if(this.currentCityIndex >= province.getCities().size()){
            this.currentCityIndex = 0;
            this.currentProvinceIndex++;
        }
        return Address.of(country,province,city,district);
    }

    @Override
    public AddressIterator clone() {
        return new AddressIterator(this.tree);
    }
}
