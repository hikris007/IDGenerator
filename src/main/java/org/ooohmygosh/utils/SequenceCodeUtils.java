package org.ooohmygosh.utils;

import org.ooohmygosh.model.SequenceCode;

public class SequenceCodeUtils {
    public static String formatter(SequenceCode sequenceCode) {
        if(
                sequenceCode.getSequenceCode() < 0||
                sequenceCode.getSequenceCode() > 99
        )
            throw new IllegalArgumentException("不合法");

        String seqCode = "";
        if(sequenceCode.getSequenceCode() < 10)
            seqCode += "0";

        return seqCode + sequenceCode.getSequenceCode() + sequenceCode.getGenderCode();
    }
}
