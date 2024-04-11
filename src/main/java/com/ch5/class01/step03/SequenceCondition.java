package com.ch5.class01.step03;

public class SequenceCondition implements DiscountCondition{
	private int sequence;

	public SequenceCondition(int sequence) {
		this.sequence = sequence;
	}

	@Override
	public boolean isSatisfiedBy(Screening screening) {
		return sequence == screening.getSequence();
	}

}
