package com.ch8.class02.step02;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.ch8.class02.step02.condition.DiscountCondition;
import com.ch8.class02.step02.condition.PeriodCondition;
import com.ch8.class02.step02.condition.SequenceCondition;
import com.ch8.class02.step02.domain.Customer;
import com.ch8.class02.step02.domain.Money;
import com.ch8.class02.step02.domain.Movie;
import com.ch8.class02.step02.domain.Reservation;
import com.ch8.class02.step02.domain.Screening;
import com.ch8.class02.step02.policy.AmountDiscountPolicy;
import com.ch8.class02.step02.policy.DiscountPolicy;
import com.ch8.class02.step02.policy.OverlappedDiscountPolicy;
import com.ch8.class02.step02.policy.PercentDiscountPolicy;

public class Main {
	public static void main(String[] args) {
		// Movie 인스턴스 생성시 별도의 할인 정책을 전달하지 않으면 기본 정책인 금액 할인 정책(AmountDiscountPolicy)를 내부적으로 생성한다
		DiscountCondition sequenceDiscountCondition1 = new SequenceCondition(1);
		DiscountCondition sequenceDiscountCondition2 = new SequenceCondition(10);
		DiscountCondition periodDiscountCondition1 = new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0),
			LocalTime.of(11, 59));
		DiscountCondition periodDiscountCondition2 = new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(18, 0),
			LocalTime.of(21, 0));

		DiscountPolicy amountDiscountPolicy = new AmountDiscountPolicy(Money.wons(800),
			sequenceDiscountCondition1, sequenceDiscountCondition2);
		DiscountPolicy percentDiscountPolicy = new PercentDiscountPolicy(0.1,
			periodDiscountCondition1, periodDiscountCondition2);

		DiscountPolicy overlappedDiscountPolicy = new OverlappedDiscountPolicy(amountDiscountPolicy,
			percentDiscountPolicy);
		Movie movie = new Movie(
			"아바타",
			Duration.ofHours(2L),
			Money.wons(10000L),
			overlappedDiscountPolicy
		);

		Screening screening = new Screening(movie, 1, LocalDateTime.of(2024, 4, 15, 10, 0, 0));

		Customer customer = new Customer("김용환", "yonghwan1234");

		int audienceCount = 1;

		// (800 + 1000)원 할인
		Reservation reserve = screening.reserve(customer, audienceCount);
		System.out.println(reserve);
	}
}
