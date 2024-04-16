package com.ch8.class02.step01.condition;

import com.ch8.class02.step01.domain.Screening;

public interface DiscountCondition {
	boolean isSatisfiedBy(Screening screening);
}
