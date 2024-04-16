package com.ch8.class01.policy;

import com.ch8.class01.domain.Money;
import com.ch8.class01.domain.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {
	@Override
	public Money calculateDiscountAmount(Screening screening) {
		return Money.ZERO;
	}
}
