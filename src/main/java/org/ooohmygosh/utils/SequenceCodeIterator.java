package org.ooohmygosh.utils;

import org.ooohmygosh.model.SequenceCode;

import java.util.Iterator;
import java.util.List;

public class SequenceCodeIterator implements Iterator<SequenceCode>,Cloneable {
    List<SequenceCode> sequenceCodes;
    int currentIndex;

    public SequenceCodeIterator(List<SequenceCode> sequenceCodes){
        this.sequenceCodes = sequenceCodes;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        if(this.sequenceCodes == null)
            return false;

        return this.currentIndex < this.sequenceCodes.size();
    }

    @Override
    public SequenceCode next() {
        if(!this.hasNext())
            return null;

        SequenceCode sequenceCode = this.sequenceCodes.get(this.currentIndex);
        this.currentIndex++;
        return sequenceCode;
    }

    @Override
    public SequenceCodeIterator clone() {
        return new SequenceCodeIterator(this.sequenceCodes);
    }
}
