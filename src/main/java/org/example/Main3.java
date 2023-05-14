package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.ooohmygosh.model.*;
import org.ooohmygosh.utils.AddressIterator;
import org.ooohmygosh.utils.AddressUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main3 {
    public static void main(String[] args) throws IOException {
//        CountryWithChildren<ProvinceWithChildren<CityWithChildren<District>>> tree = new CountryWithChildren<>();
//
//        Gson gson = new Gson();
        read("X:\\temp\\shga_sample_750k\\demo.json");
    }

    public static void read(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Gson gson = new Gson();

        List<Province> result = gson.fromJson(bufferedReader,new TypeToken<ArrayList<Province>>(){}.getType());

        Country country = Country.builder().setName("China").setProvinces(result);
        AddressIterator iterator = new AddressIterator(country);

        while (iterator.hasNext()){
            System.out.println(AddressUtils.GenerateAddressCode(iterator.next()));
        }

        bufferedReader.close();
        fileReader.close();
    }
}
