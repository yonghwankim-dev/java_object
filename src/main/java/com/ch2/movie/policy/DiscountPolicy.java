package com.ch2.movie.policy;

import com.ch2.movie.domain.Money;
import com.ch2.movie.domain.Screening;

public interface DiscountPolicy {
	Money calculateDiscountAmount(Screening screening);
}
