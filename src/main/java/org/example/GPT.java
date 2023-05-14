//package org.example;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//class District {
//    String name;
//    String code;
//
//    public District(String name, String code) {
//        this.name = name;
//        this.code = code;
//    }
//}
//
//class City {
//    String name;
//    String code;
//    List<District> districts;
//
//    public City(String name, String code, List<District> districts) {
//        this.name = name;
//        this.code = code;
//        this.districts = districts;
//    }
//}
//
//class Province {
//    String name;
//    String code;
//    List<City> cities;
//
//    public Province(String name, String code, List<City> cities) {
//        this.name = name;
//        this.code = code;
//        this.cities = cities;
//    }
//}
//
//class DistrictIterator implements Iterator<List<Object>> {
//    private List<Province> provinces;
//    private int currentProvinceIndex;
//    private int currentCityIndex;
//    private int currentDistrictIndex;
//
//    public DistrictIterator(List<Province> provinces) {
//        this.provinces = provinces;
//        this.currentProvinceIndex = 0;
//        this.currentCityIndex = 0;
//        this.currentDistrictIndex = 0;
//    }
//
//    @Override
//    public boolean hasNext() {
//        while (currentProvinceIndex < provinces.size()) {
//            Province province = provinces.get(currentProvinceIndex);
//            City city = province.cities.get(currentCityIndex);
//
//            if (city != null && currentDistrictIndex < city.districts.size()) {
//                return true;
//            } else {
//                currentProvinceIndex++;
//            }
//        }
//
//        return false;
//    }
//
//    @Override
//    public List<Object> next() {
//        if (!hasNext()) {
//            return null;
//        }
//
//        Province province = provinces.get(currentProvinceIndex);
//        City city = province.cities.get(currentCityIndex);
//        District district = city.districts.get(currentDistrictIndex);
//
//        Province simplifiedProvince = new Province(province.name, province.code, null);
//        City simplifiedCity = new City(city.name, city.code, null);
//        District simplifiedDistrict = new District(district.name, district.code);
//
//        List<Object> result = new ArrayList<>();
//        result.add(simplifiedProvince);
//        result.add(simplifiedCity);
//        result.add(simplifiedDistrict);
//
//        currentDistrictIndex++;
//
//        if (currentDistrictIndex >= city.districts.size()) {
//            currentDistrictIndex = 0;
//            currentCityIndex++;
//        }
//
//        if (currentCityIndex >= province.cities.size()) {
//            currentCityIndex = 0;
//            currentProvinceIndex++;
//        }
//
//        return result;
//    }
//}
//
//public class GPT {
//    public static void main(String[] args) {
//        List<Province> data = new ArrayList<>();
//        // Add your data here
//
//        DistrictIterator iterator = new DistrictIterator(data);
//
//        while (iterator.hasNext()) {
//            List<Object> result = iterator.next();
//            System.out.println(result);
//        }
//
//        System.out.println(data.get(0));
//    }
//}
