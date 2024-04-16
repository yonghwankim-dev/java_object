package com.ch8.class02.step02.domain;

import java.time.Duration;

import com.ch8.class02.step02.condition.SequenceCondition;
import com.ch8.class02.step02.policy.AmountDiscountPolicy;
import com.ch8.class02.step02.policy.DiscountPolicy;

public class Movie {
	private final String title;
	private final Duration runningTime;
	private final Money fee;
	private DiscountPolicy discountPolicy;

	public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
		this.title = title;
		this.runningTime = runningTime;
		this.fee = fee;
		this.discountPolicy = discountPolicy;
	}

	public Money getFee() {
		return fee;
	}

	public Money calculateMovieFee(Screening screening) {
		return fee.minus(discountPolicy.calculateDiscountAmount(screening));
	}

	public void changeDiscountPolicy(DiscountPolicy discountPolicy){
		this.discountPolicy = discountPolicy;
	}
}
