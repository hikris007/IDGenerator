package org.example;

import org.ooohmygosh.model.*;
import org.ooohmygosh.utils.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FinalTest {
    public static void main(String[] args) throws Exception {

        District district = District.builder()
                .setName("天等县")
                .setCode("25");

        City city = City.builder()
                .setName("崇左")
                .setCode("14")
                .setDistricts(Arrays.asList(district));

        Province province = Province.builder()
                .setName("广西")
                .setCode("45")
                .setCities(Arrays.asList(city));

        Country country = Country.builder()
                .setName("China")
                .setProvinces(Arrays.asList(province));


        AddressIterator addressIterator = new AddressIterator(country);

        BirthdayIterator birthdayIterator = new BirthdayIterator(
                LocalDate.of(2000,1,1),
                LocalDate.of(2023,12,31)
        );

        SequenceCode sequenceCode1 = SequenceCode.builder()
                .setSequenceCode(0)
                .setGenderCode(2);

        SequenceCode sequenceCode2 = SequenceCode.builder()
                .setSequenceCode(1)
                .setGenderCode(2);

        SequenceCode sequenceCode3 = SequenceCode.builder()
                .setSequenceCode(2)
                .setGenderCode(2);

//        List<SequenceCode> sequenceCodes = Arrays.asList(
//                sequenceCode1,
//                sequenceCode2,
//                sequenceCode3
//        );

        List<SequenceCode> sequenceCodes = new ArrayList<>();
        int[] genderCode = new int[]{1,3,5,7,9};
        for(int i=0;i<100;i++){
            for(int j=0;j<genderCode.length;j++){
                sequenceCodes.add(
                        SequenceCode.builder()
                                .setSequenceCode(i)
                                .setGenderCode(genderCode[j])
                );
            }
        }

        SequenceCodeIterator sequenceCodeIterator = new SequenceCodeIterator(sequenceCodes);

        IDIterator idIterator = new IDIterator(addressIterator,birthdayIterator,sequenceCodeIterator);
        int count = 0;
        while (idIterator.hasNext()){
            count++;
            String idNo = IDUtils.formatter(idIterator.next());
            if(!idNo.equals("451425200112160915"))
                continue;

            System.out.println(idNo);
            break;
        }
        System.out.println(count);

        // -----------------------
//        List<String> addr = new ArrayList<>();
//        while (addressIterator.hasNext()){
//            addr.add(AddressUtils.GenerateAddressCode(addressIterator.next()));
//        }
//
//        List<String> birth = new ArrayList<>();
//        while (birthdayIterator.hasNext()){
//            birth.add(DateUtils.formatter(birthdayIterator.next().toLocalDate()));
//        }
//
//        List<String> seqCodes = new ArrayList<>();
//        while (sequenceCodeIterator.hasNext()){
//            seqCodes.add(SequenceCodeUtils.formatter(sequenceCodeIterator.next()));
//        }
//
//        List<String> ids = new ArrayList<>();
//
//        long bts = System.currentTimeMillis();
//
//        for(int i = 0;i < addr.size();i++){
//            for(int j = 0;j < birth.size();j++){
//                for (int k = 0;k < seqCodes.size();k++){
//                    String id = addr.get(i) + birth.get(j) + seqCodes.get(k);
//                    id += IDUtils.calcCheckDigit(id);
//                    ids.add(id);
//                }
//            }
//        }
//
//        long ets = System.currentTimeMillis();
//
//        System.out.println(ids.size());
//        System.out.println((ets - bts) + "ms");
    }
}
