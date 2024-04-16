package com.ch8.class02.step02.policy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ch8.class02.step02.condition.DiscountCondition;
import com.ch8.class02.step02.domain.Money;
import com.ch8.class02.step02.domain.Screening;

public abstract class DefaultDiscountPolicy extends DiscountPolicy {

	private final List<DiscountCondition> conditions;

	public DefaultDiscountPolicy(DiscountCondition... conditions) {
		this.conditions = Arrays.asList(conditions);
	}

	@Override
	public Money calculateDiscountAmount(Screening screening) {
		for (DiscountCondition condition : conditions){
			if (condition.isSatisfiedBy(screening)){
				return getDiscountAmount(screening);
			}
		}
		return Money.ZERO;
	}

	protected abstract Money getDiscountAmount(Screening screening);
}
