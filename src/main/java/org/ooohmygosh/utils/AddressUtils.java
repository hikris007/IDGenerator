package org.ooohmygosh.utils;

import org.ooohmygosh.model.Address;

public class AddressUtils {
    public static String GenerateAddressCode(Address address){
        return String.format(
                "%s%s%s",
                address.getProvince().getCode(),
                address.getCity().getCode(),
                address.getDistrict().getCode()
        );
    }
}
