package com.ch8.class02.step02.policy;

import com.ch8.class02.step02.condition.DiscountCondition;
import com.ch8.class02.step02.domain.Money;
import com.ch8.class02.step02.domain.Screening;

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
