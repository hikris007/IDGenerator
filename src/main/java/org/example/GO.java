package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.ooohmygosh.model.*;
import org.ooohmygosh.utils.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GO {
    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader("X:\\temp\\shga_sample_750k\\aa.json");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Gson gson = new Gson();

        List<Province> provinces = gson.fromJson(bufferedReader,new TypeToken<ArrayList<Province>>(){}.getType());
        bufferedReader.close();
        fileReader.close();

        // ---- 地区 ----
        Country country = Country.builder()
                .setName("China")
                .setProvinces(provinces);

        AddressIterator addressIterator = new AddressIterator(country);

        // ---- 生日 ----
        BirthdayIterator birthdayIterator = new BirthdayIterator(
                LocalDate.of(2000,12,16),
                LocalDate.of(2000,12,16)
        );


        // ---- 顺序码 ----
        SequenceCodeGenerator sequenceCodeGenerator = SequenceCodeGenerator.ofRange(0,99, SequenceCodeGenerator.GENDER.FEMALE);
        SequenceCodeIterator sequenceCodeIterator = sequenceCodeGenerator.iterator();

        IDIterator idIterator = new IDIterator(addressIterator,birthdayIterator,sequenceCodeIterator);
        List<String> idNumbers = new ArrayList<>();

        while (idIterator.hasNext()){
            ID id = idIterator.next();
            String idNumber = IDUtils.formatter(id);

            if(idNumber == null || idNumber.equals(""))
                continue;

            idNumbers.add(idNumber);
        }

        // 写入
//        Gson gson = new Gson();
        String json = gson.toJson(idNumbers);

        FileWriter fileWriter = new FileWriter("X:\\temp\\shga_sample_750k\\guizhou_gen.json");
        fileWriter.write(json);
        fileWriter.close();
    }
}
