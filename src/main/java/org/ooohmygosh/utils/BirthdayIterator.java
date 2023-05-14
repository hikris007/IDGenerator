package org.ooohmygosh.utils;

import org.ooohmygosh.model.Birthday;

import java.time.LocalDate;
import java.util.Iterator;

public class BirthdayIterator implements Iterator<Birthday>,Cloneable {
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate currentDate;

    public BirthdayIterator(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.currentDate = startDate;
    }

    @Override
    public boolean hasNext() {
        return !currentDate.isAfter(endDate);
    }

    @Override
    public Birthday next() {
        if (!hasNext()) {
            return null;
        }

        Birthday result = Birthday.ofLocalDate(currentDate);
        currentDate = currentDate.plusDays(1);
        return result;
    }

    @Override
    public BirthdayIterator clone() {
        BirthdayIterator clone = new BirthdayIterator(this.startDate,this.endDate);
        return clone;
    }
}