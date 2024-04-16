package com.ch8.class01.domain;

import java.time.Duration;

import com.ch8.class01.policy.DiscountPolicy;

public class Movie {
	private final String title;
	private final Duration runningTime;
	private final Money fee;
	private DiscountPolicy discountPolicy;

	// 생성자를 통해서 DiscountPolicy 구현체를 필수적으로 한개 받음
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

	// PercentdiscountPolicy, AmountDiscountPolicy 인스턴스 모두를 선택적으로 전달받을 수 있는 방법
	public void changeDiscountPolicy(DiscountPolicy discountPolicy){
		this.discountPolicy = discountPolicy;
	}
}
