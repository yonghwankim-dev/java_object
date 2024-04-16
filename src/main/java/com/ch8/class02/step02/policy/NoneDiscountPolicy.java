package com.ch8.class02.step02.policy;

import com.ch8.class02.step02.domain.Money;
import com.ch8.class02.step02.domain.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {
	@Override
	public Money calculateDiscountAmount(Screening screening) {
		return Money.ZERO;
	}
}
