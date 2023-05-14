package org.ooohmygosh.model;

public class SequenceCode {
    private int sequenceCode;
    private int genderCode;

    public static SequenceCode builder() {
        return new SequenceCode();
    }

    public int getSequenceCode() {
        return sequenceCode;
    }

    public SequenceCode setSequenceCode(int sequenceCode) {
        this.sequenceCode = sequenceCode;
        return this;
    }

    public int getGenderCode() {
        return genderCode;
    }

    public SequenceCode setGenderCode(int genderCode) {
        this.genderCode = genderCode;
        return this;
    }
}
