package org.ooohmygosh.model;

import org.ooohmygosh.utils.AddressUtils;
import org.ooohmygosh.utils.DateUtils;
import org.ooohmygosh.utils.IDUtils;
import org.ooohmygosh.utils.SequenceCodeUtils;

import java.net.IDN;

public class ID {
    private Address address;
    private Birthday birthday;
    private SequenceCode sequenceCode;

    private Character checkDigit;

    public static ID builder(){
        return new ID();
    }

    public Address getAddress() {
        return address;
    }

    public ID setAddress(Address address) {
        this.address = address;
        return this;
    }

    public Birthday getBirthday() {
        return birthday;
    }

    public ID setBirthday(Birthday birthday) {
        this.birthday = birthday;
        return this;
    }

    public SequenceCode getSequenceCode() {
        return sequenceCode;
    }

    public ID setSequenceCode(SequenceCode sequenceCode) {
        this.sequenceCode = sequenceCode;
        return this;
    }

    public ID calcCheckDigit(){
        try {
            String IDNumber = String.format(
                    "%s%s%s",
                    AddressUtils.GenerateAddressCode(this.getAddress()),
                    DateUtils.formatter(this.getBirthday().toLocalDate()),
                    SequenceCodeUtils.formatter(this.getSequenceCode())
            );
            this.checkDigit = IDUtils.calcCheckDigit(IDNumber);
        }catch (Exception ignored){

        }
        return this;
    }

    public Character getCheckDigit() {
        if(this.checkDigit == null){
            this.calcCheckDigit();
        }
        return checkDigit;
    }
}
