package com.ch2.movie.condition;

import com.ch2.movie.domain.Screening;

public interface DiscountCondition {
	boolean isSatisfiedBy(Screening screening);
}
