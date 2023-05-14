package org.example;

import org.ooohmygosh.model.*;

public class Test {
    public static void main(String[] args) {
        Country country = Country.builder().setName("China");
        Province province = Province.builder().setName("广西").setCode("45");
        City city = City.builder().setName("崇左").setCode("14");
        District district = District.builder().setName("天等县").setCode("25");

        Address address = Address.builder()
                .setCountry(country)
                .setProvince(province)
                .setCity(city)
                .setDistrict(district);

        Birthday birthday = Birthday.builder()
                .setYear(2001)
                .setMonth(12)
                .setDay(16);

        SequenceCode sequenceCode = SequenceCode.builder()
                .setSequenceCode(9)
                .setGenderCode(1);

        ID id = ID.builder()
                .setAddress(address)
                .setBirthday(birthday)
                .setSequenceCode(sequenceCode);

        System.out.println(id.getCheckDigit());
    }
}
