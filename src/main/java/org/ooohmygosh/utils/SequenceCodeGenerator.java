package org.ooohmygosh.utils;

import org.ooohmygosh.model.SequenceCode;

import java.util.ArrayList;
import java.util.List;

public class SequenceCodeGenerator {
    public static enum GENDER {
        ALL,
        MALE,
        FEMALE
    }

    private static final int[] maleCodes = new int[]{1,3,5,7,9};
    private static final int[] femaleCodes = new int[]{2,4,6,8};
    private static final int[] genderCodes = new int[]{1,2,3,4,5,6,7,8,9};

    private GENDER gender = GENDER.ALL;

    private List<SequenceCode> sequenceCodes;

    private SequenceCodeIterator sequenceCodeIterator;

    public static SequenceCodeGenerator builder(){
        SequenceCodeGenerator sequenceCodeGenerator = new SequenceCodeGenerator();
        sequenceCodeGenerator.sequenceCodes = new ArrayList<>();
        return sequenceCodeGenerator;
    }

    public static SequenceCodeGenerator ofRange(int min,int max,GENDER gender) {
        if(min < 0 || max > 99)
            throw new IllegalArgumentException("range is about 0-99");

        int[] genderCodes = getGenderCodes(gender);

        SequenceCodeGenerator sequenceCodeGenerator = SequenceCodeGenerator.builder();

        for(int i=min;i<max;i++){
            for (int genderCode : genderCodes) {
                sequenceCodeGenerator.sequenceCodes.add(
                        SequenceCode.builder()
                                .setSequenceCode(i)
                                .setGenderCode(genderCode)
                );
            }
        }

        sequenceCodeGenerator.sequenceCodeIterator = new SequenceCodeIterator(sequenceCodeGenerator.sequenceCodes);

        return sequenceCodeGenerator;
    }

    public static SequenceCodeGenerator ofCodes(int[] codes,GENDER gender) throws Exception {
        int[] genderCodes = getGenderCodes(gender);

        SequenceCodeGenerator sequenceCodeGenerator = SequenceCodeGenerator.builder();

        for (int code : codes) {
            if(code < 0 || code > 99)
                throw new Exception("range is about 0-99");

            for (int genderCode : genderCodes) {
                sequenceCodeGenerator.sequenceCodes.add(
                        SequenceCode.builder()
                                .setSequenceCode(code)
                                .setGenderCode(genderCode)
                );
            }
        }

        sequenceCodeGenerator.sequenceCodeIterator = new SequenceCodeIterator(sequenceCodeGenerator.sequenceCodes);

        return sequenceCodeGenerator;
    }

    public static int[] getGenderCodes(GENDER gender){
        return switch (gender) {
            case ALL -> SequenceCodeGenerator.genderCodes;
            case MALE -> SequenceCodeGenerator.maleCodes;
            case FEMALE -> SequenceCodeGenerator.femaleCodes;
        };
    }

    public SequenceCodeIterator iterator(){
        return this.sequenceCodeIterator;
    }

    public int[] getMaleCodes() {
        return maleCodes;
    }

    public int[] getFemaleCodes() {
        return femaleCodes;
    }

    public GENDER getGender() {
        return gender;
    }

    public List<SequenceCode> getSequenceCodes() {
        return sequenceCodes;
    }


}
