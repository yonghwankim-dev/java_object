package com.ch8.class02.step01.policy;

import com.ch8.class02.step01.condition.DiscountCondition;
import com.ch8.class02.step01.domain.Money;
import com.ch8.class02.step01.domain.Screening;

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
