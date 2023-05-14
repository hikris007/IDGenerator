package org.ooohmygosh.utils;

public class SequenceCodeGenerator {
    public static enum GENDER {
        ALL,
        MALE,
        FEMALE
    }

    private int[] maleCodes = new int[]{1,3,5,7,9};
    private int[] femaleCodes = new int[]{2,4,6,8};

    private GENDER gender = GENDER.ALL;

    public static SequenceCodeGenerator of(){
        return null;
    }
}
