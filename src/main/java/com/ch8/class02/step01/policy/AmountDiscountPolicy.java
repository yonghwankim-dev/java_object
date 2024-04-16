package com.ch8.class02.step01.policy;

import com.ch8.class02.step01.condition.DiscountCondition;
import com.ch8.class02.step01.domain.Money;
import com.ch8.class02.step01.domain.Screening;

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
