package com.ch8.class01.condition;

import com.ch8.class01.domain.Screening;

public class SequenceCondition implements DiscountCondition {
	private final int sequence;

	public SequenceCondition(int sequence) {
		this.sequence = sequence;
	}

	@Override
	public boolean isSatisfiedBy(Screening screening) {
		return screening.isSequence(sequence);
	}
}
