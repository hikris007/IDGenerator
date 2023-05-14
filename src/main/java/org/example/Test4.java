package org.example;

import org.ooohmygosh.utils.SequenceCodeGenerator;
import org.ooohmygosh.utils.SequenceCodeUtils;

public class Test4 {
    public static void main(String[] args) throws Exception {
//        SequenceCodeGenerator sequenceCodeGenerator = SequenceCodeGenerator.ofRange(0,10, SequenceCodeGenerator.GENDER.MALE);
        SequenceCodeGenerator sequenceCodeGenerator = SequenceCodeGenerator.ofCodes(new int[]{1,2}, SequenceCodeGenerator.GENDER.MALE);
        while (sequenceCodeGenerator.iterator().hasNext()){
            System.out.println(SequenceCodeUtils.formatter(sequenceCodeGenerator.iterator().next()));
        }
    }
}
