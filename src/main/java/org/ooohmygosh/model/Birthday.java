package org.ooohmygosh.model;

import java.time.LocalDate;

public class Birthday {
    private Integer year;
    private Integer month;
    private Integer day;

    public Birthday(){

    }

    public Birthday(Integer year, Integer month, Integer day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static Birthday builder(){
        return new Birthday();
    }

    public static Birthday ofLocalDate(LocalDate date) {
        return builder()
                .setYear(date.getYear())
                .setMonth(date.getMonthValue())
                .setDay(date.getDayOfMonth());
    }

    public LocalDate toLocalDate(){
        return LocalDate.of(
          this.getYear(),
          this.getMonth(),
          this.getDay()
        );
    }

    public Integer getYear() {
        return year;
    }

    public Birthday setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Integer getMonth() {
        return month;
    }

    public Birthday setMonth(Integer month) {
        this.month = month;
        return this;
    }

    public Integer getDay() {
        return day;
    }

    public Birthday setDay(Integer day) {
        this.day = day;
        return this;
    }
}
