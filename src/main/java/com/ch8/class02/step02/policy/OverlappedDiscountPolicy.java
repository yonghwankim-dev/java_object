package com.ch8.class02.step02.policy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ch8.class02.step02.domain.Money;
import com.ch8.class02.step02.domain.Screening;

public class OverlappedDiscountPolicy extends DiscountPolicy{
	private final List<DiscountPolicy> discountPolicies;

	public OverlappedDiscountPolicy(DiscountPolicy... discountPolicies) {
		this.discountPolicies = Arrays.asList(discountPolicies);
	}

	@Override
	public Money calculateDiscountAmount(Screening screening) {
		Money result = Money.ZERO;
		for(DiscountPolicy each : discountPolicies){
			result = result.plus(each.calculateDiscountAmount(screening));
		}
		return result;
	}
}
