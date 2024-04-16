package com.ch8.class02.step01.domain;

import java.time.Duration;

import com.ch8.class02.step01.condition.SequenceCondition;
import com.ch8.class02.step01.policy.AmountDiscountPolicy;
import com.ch8.class02.step01.policy.DiscountPolicy;

public class Movie {
	private final String title;
	private final Duration runningTime;
	private final Money fee;
	private DiscountPolicy discountPolicy;

	// 기본 객체를 설정하고 싶은 경우에 사용, 단점 : 결합도 상승, 장점 : 사용성 상승
	public Movie(String title, Duration runningTime, Money fee) {
		this(title, runningTime, fee,
			new AmountDiscountPolicy(
				Money.wons(800),
			new SequenceCondition(1),
				new SequenceCondition(10)
			)
		);
	}

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
