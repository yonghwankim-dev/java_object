package com.ch8.class01.policy;

import com.ch8.class01.condition.DiscountCondition;
import com.ch8.class01.domain.Money;
import com.ch8.class01.domain.Screening;

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
