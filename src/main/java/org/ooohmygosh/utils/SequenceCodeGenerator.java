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

    List<SequenceCode> sequenceCodes;

    public static SequenceCodeGenerator builder(){
        SequenceCodeGenerator sequenceCodeGenerator = new SequenceCodeGenerator();
        sequenceCodeGenerator.sequenceCodes = new ArrayList<>();
        return sequenceCodeGenerator;
    }

    public static SequenceCodeGenerator ofRange(int min,int max,GENDER gender){
        int[] genderCodes = null;
        switch (gender){
            case ALL:
                genderCodes = SequenceCodeGenerator.genderCodes;
                break;

            case MALE:
                genderCodes = SequenceCodeGenerator.maleCodes;
                break;

            case FEMALE:
                genderCodes = SequenceCodeGenerator.femaleCodes;
        }

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

        return sequenceCodeGenerator;
    }

    public static SequenceCodeGenerator ofCodes(int[] codes,GENDER gender){
        int[] genderCodes = null;
        switch (gender){
            case ALL:
                genderCodes = SequenceCodeGenerator.genderCodes;
                break;

            case MALE:
                genderCodes = SequenceCodeGenerator.maleCodes;
                break;

            case FEMALE:
                genderCodes = SequenceCodeGenerator.femaleCodes;
        }

        SequenceCodeGenerator sequenceCodeGenerator = SequenceCodeGenerator.builder();

        for (int code : codes) {
            for (int genderCode : genderCodes) {
                sequenceCodeGenerator.sequenceCodes.add(
                        SequenceCode.builder()
                                .setSequenceCode(code)
                                .setGenderCode(genderCode)
                );
            }
        }

        return sequenceCodeGenerator;
    }

    public SequenceCodeIterator iterator(){
        return new SequenceCodeIterator(this.getSequenceCodes());
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
