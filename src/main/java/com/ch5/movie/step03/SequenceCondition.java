package com.ch5.movie.step03;

public class SequenceCondition implements DiscountCondition {
    private final int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    public boolean isSatisfiedBy(Screening screening) {
        return sequence == screening.getSequence();
    }
}
