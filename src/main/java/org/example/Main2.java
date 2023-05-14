package org.example;

import org.ooohmygosh.utils.BirthdayIterator;
import org.ooohmygosh.utils.DateUtils;

import java.time.LocalDate;

public class Main2 {
    public static void main(String[] args) {
        BirthdayIterator dateIterator = new BirthdayIterator(
                LocalDate.of(2023,5,12),
                LocalDate.of(2023,5,13)
        );

        while (dateIterator.hasNext()){
            System.out.println(DateUtils.formatter(dateIterator.next().toLocalDate()));
        }
    }
}
