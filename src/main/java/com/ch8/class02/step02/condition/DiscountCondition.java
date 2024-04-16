package com.ch8.class02.step02.condition;

import com.ch8.class02.step02.domain.Screening;

public interface DiscountCondition {
	boolean isSatisfiedBy(Screening screening);
}
