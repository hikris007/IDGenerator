package org.ooohmygosh.utils;

import org.ooohmygosh.model.SequenceCode;

public class SequenceCodeUtils {
    public static String formatter(SequenceCode sequenceCode){
        String seqCode = "";
        if(sequenceCode.getSequenceCode() < 10)
            seqCode += "0";

        return seqCode + sequenceCode.getSequenceCode() + sequenceCode.getGenderCode();
    }
}
