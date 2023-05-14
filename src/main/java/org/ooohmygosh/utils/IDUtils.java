package org.ooohmygosh.utils;

import org.ooohmygosh.model.ID;

public class IDUtils {
    public static final byte[] weights = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
    public static final char[] checkDigitMap = {'1','0','X','9','8','7','6','5','4','3','2'};
    public static char calcCheckDigit(String IDNumber) throws Exception {
        if(IDNumber == null)
            throw new Exception("ID Number can't be null");

        if(IDNumber.length() < 17)
            throw new Exception("ID Number can't be less then 17 char");

        char[] chars = IDNumber.toCharArray();

        byte[] bits = new byte[17];

        for(int i=0;i<17;i++){
            char c = chars[i];
            if(c < 48 || c > 57)
                throw new Exception("ID Number contains illegal characters");

            bits[i] = (byte) (c - 48);
        }

        int sum = 0;
        for(int i=0;i<17;i++){
            sum += bits[i] * weights[i];
        }

        return checkDigitMap[sum % 11];
    }

    public static String formatter(ID id){
        String IDNumber = String.format(
                "%s%s%s%c",
                AddressUtils.GenerateAddressCode(id.getAddress()),
                DateUtils.formatter(id.getBirthday().toLocalDate()),
                SequenceCodeUtils.formatter(id.getSequenceCode()),
                id.getCheckDigit()
        );

        return IDNumber;
    }
}
