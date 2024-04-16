package com.ch8.class01.policy;

import com.ch8.class01.domain.Money;
import com.ch8.class01.domain.Screening;

public interface DiscountPolicy {
	Money calculateDiscountAmount(Screening screening);
}
