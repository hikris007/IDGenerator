package org.example;

import org.ooohmygosh.model.Address;
import org.ooohmygosh.model.City;
import org.ooohmygosh.model.District;
import org.ooohmygosh.model.Province;
import org.ooohmygosh.utils.AddressUtils;

public class Main {
    private static int i1 = 0;
    private static int i2 = 0;
    private static int i3 = 0;

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Integer[] arr = new Integer[3];
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

        Province province = new Province().setCode("01")
                                          .setName("北京");

        City city = new City().setName("宁波")
                              .setCode("02");

        District district = new District().setName("鄞州")
                                          .setCode("03");

        Address address = new Address()
                .setProvince(province)
                .setCity(city)
                .setDistrict(district);

        System.out.println(
                AddressUtils.GenerateAddressCode(address)
        );


    }

    public static void next(){
        i3++;
        if(i3 >= 9){
            i3 = 0;
            i2++;
        }

        if(i2 >= 9){
            i2 = 0;
            i1++;
        }

        if(i1 >= 9){

        }
    }
}