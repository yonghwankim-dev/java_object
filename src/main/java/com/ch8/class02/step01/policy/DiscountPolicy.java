package com.ch8.class02.step01.policy;

import com.ch8.class02.step01.domain.Money;
import com.ch8.class02.step01.domain.Screening;

public interface DiscountPolicy {
	Money calculateDiscountAmount(Screening screening);
}
