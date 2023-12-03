package com.ch2.movie.policy;

import com.ch2.movie.condition.DiscountCondition;
import com.ch2.movie.domain.Money;
import com.ch2.movie.domain.Screening;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {

	private final double percent;

	public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
		super(conditions);
		this.percent = percent;
	}

	@Override
	protected Money getDiscountAmount(Screening screening) {
		return screening.getMovieFee().times(percent);
	}
}
