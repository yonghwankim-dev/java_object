package com.ch8.class01.condition;

import com.ch8.class01.domain.Screening;

public interface DiscountCondition {
	boolean isSatisfiedBy(Screening screening);
}
