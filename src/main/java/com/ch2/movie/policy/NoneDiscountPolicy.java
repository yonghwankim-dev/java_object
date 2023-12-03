package com.ch2.movie.policy;

import com.ch2.movie.domain.Money;
import com.ch2.movie.domain.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {
	@Override
	public Money calculateDiscountAmount(Screening screening) {
		return Money.ZERO;
	}
}
