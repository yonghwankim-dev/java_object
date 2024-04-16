package com.ch8.class01;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.ch8.class01.condition.DiscountCondition;
import com.ch8.class01.condition.PeriodCondition;
import com.ch8.class01.condition.SequenceCondition;
import com.ch8.class01.domain.Customer;
import com.ch8.class01.domain.Money;
import com.ch8.class01.domain.Movie;
import com.ch8.class01.domain.Reservation;
import com.ch8.class01.domain.Screening;
import com.ch8.class01.policy.AmountDiscountPolicy;
import com.ch8.class01.policy.DiscountPolicy;
import com.ch8.class01.policy.PercentDiscountPolicy;

public class Main {
	public static void main(String[] args) {
		DiscountCondition sequenceDiscountCondition1 = new SequenceCondition(1);
		DiscountCondition sequenceDiscountCondition2 = new SequenceCondition(10);
		DiscountCondition periodDiscountCondition1 = new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0),
			LocalTime.of(11, 59));
		DiscountCondition periodDiscountCondition2 = new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(18, 0),
			LocalTime.of(21, 0));

		DiscountPolicy amountDiscountPolicy = new AmountDiscountPolicy(Money.wons(800),
			sequenceDiscountCondition1, sequenceDiscountCondition2);
		Movie movie = new Movie(
			"아바타",
			Duration.ofHours(2L),
			Money.wons(10000L),
			amountDiscountPolicy
		);

		Screening screening = new Screening(movie, 1, LocalDateTime.of(2024, 4, 15, 10, 0, 0));

		Customer customer = new Customer("김용환", "yonghwan1234");

		int audienceCount = 1;

		Reservation reserve = screening.reserve(customer, audienceCount);
		System.out.println(reserve);

		DiscountPolicy percentDiscountPolicy = new PercentDiscountPolicy(0.1,
			periodDiscountCondition1, periodDiscountCondition2);
		// setter 메서드를 이용하여 할인 정책 변경
		movie.changeDiscountPolicy(percentDiscountPolicy);
		reserve = screening.reserve(customer, audienceCount);
		System.out.println(reserve);
	}
}
