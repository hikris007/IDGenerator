package org.ooohmygosh.utils;

import org.ooohmygosh.model.Address;
import org.ooohmygosh.model.Birthday;
import org.ooohmygosh.model.ID;
import org.ooohmygosh.model.SequenceCode;

import java.util.Iterator;

public class IDIterator implements Iterator<ID> {
    private AddressIterator addressIterator;
    private BirthdayIterator birthdayIterator;
    private SequenceCodeIterator sequenceCodeIterator;

    private AddressIterator currentAddressIterator;
    private BirthdayIterator currentBirthdayIterator;
    private SequenceCodeIterator currentSequenceCodeIterator;

    private Address currentAddress;
    private Birthday currentBirthday;
    private SequenceCode currentSequenceCode;

    private boolean hasNext = false;

    public IDIterator(
            AddressIterator addressIterator,
            BirthdayIterator birthdayIterator,
            SequenceCodeIterator sequenceCodeIterator
    ){
        this.addressIterator = addressIterator;
        this.birthdayIterator = birthdayIterator;
        this.sequenceCodeIterator = sequenceCodeIterator;

        this.resetIterators();

        this.hasNext = true;

        for (int i = 0; i < 3; i++) {
            if(i == 0 && this.currentAddressIterator.hasNext()){
                this.currentAddress = this.currentAddressIterator.next();
            }else if(i == 1 && this.currentBirthdayIterator.hasNext()){
                this.currentBirthday = this.currentBirthdayIterator.next();
            }else if(i == 2 && this.currentSequenceCodeIterator.hasNext()){
                this.currentSequenceCode = this.currentSequenceCodeIterator.next();
            }else{
                this.hasNext = false;
                break;
            }
        }
    }

    private void resetAddressIterator(){
        this.currentAddressIterator = this.addressIterator.clone();
    }

    private void resetBirthdayIterator(){
        this.currentBirthdayIterator = this.birthdayIterator.clone();
    }

    private void resetSequenceCodeIterator(){
        this.currentSequenceCodeIterator = this.sequenceCodeIterator.clone();
    }

    private void resetIterators(){
        this.resetAddressIterator();
        this.resetBirthdayIterator();
        this.resetSequenceCodeIterator();
    }
    @Override
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override
    public ID next() {
        if(!this.hasNext())
            return null;

        ID id = ID.builder()
                .setAddress(this.currentAddress)
                .setBirthday(this.currentBirthday)
                .setSequenceCode(this.currentSequenceCode)
                .calcCheckDigit();

        for(int i = 2;i >= 0;i--){
            if(i == 2 && this.currentSequenceCodeIterator.hasNext()){
                this.currentSequenceCode = this.currentSequenceCodeIterator.next();
                break;
            }else if(i == 1 && this.currentBirthdayIterator.hasNext()){
                this.currentBirthday = this.currentBirthdayIterator.next();
                break;
            }else if(i == 0 && this.currentAddressIterator.hasNext()){
                this.currentSequenceCode = this.currentSequenceCodeIterator.next();
                break;
            }else{
                if(i == 0){
                    hasNext = false;
                }else{
                    if(i == 2){
                        this.resetSequenceCodeIterator();
                        this.currentSequenceCode = this.currentSequenceCodeIterator.next();
                    }else if(i == 1){
                        this.resetBirthdayIterator();
                        this.currentBirthday = this.currentBirthdayIterator.next();
                    }
                }
            }
        }

        return id;
    }
}
