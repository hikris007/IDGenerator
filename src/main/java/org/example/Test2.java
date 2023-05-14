package org.example;

import org.ooohmygosh.model.SequenceCode;
import org.ooohmygosh.utils.SequenceCodeIterator;
import org.ooohmygosh.utils.SequenceCodeUtils;

import java.util.Arrays;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        SequenceCode sequenceCode1 = SequenceCode.builder()
                .setSequenceCode(0)
                .setGenderCode(2);

        SequenceCode sequenceCode2 = SequenceCode.builder()
                .setSequenceCode(1)
                .setGenderCode(2);

        SequenceCode sequenceCode3 = SequenceCode.builder()
                .setSequenceCode(2)
                .setGenderCode(2);

        List<SequenceCode> sequenceCodeList = Arrays.asList(
                sequenceCode1,
                sequenceCode2,
                sequenceCode3
        );

        SequenceCodeIterator sequenceCodeIterator = new SequenceCodeIterator(sequenceCodeList);
        SequenceCodeIterator sequenceCodeIterator1 = sequenceCodeIterator.clone();
        while (sequenceCodeIterator.hasNext()){
            System.out.println("While 1:"+SequenceCodeUtils.formatter(sequenceCodeIterator.next()));
        }

        while (sequenceCodeIterator1.hasNext()){
            System.out.println("While 2:"+SequenceCodeUtils.formatter(sequenceCodeIterator1.next()));
        }
    }
}
