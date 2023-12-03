package com.ch2.movie.policy;

import com.ch2.movie.condition.DiscountCondition;
import com.ch2.movie.domain.Money;
import com.ch2.movie.domain.Screening;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {

	private final Money discountAmount;

	public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
		super(conditions);
		this.discountAmount = discountAmount;
	}

	@Override
	protected Money getDiscountAmount(Screening screening) {
		return discountAmount;
	}
}
