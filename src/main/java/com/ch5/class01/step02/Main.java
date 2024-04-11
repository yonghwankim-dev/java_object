package com.ch5.class01.step02;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * 기존 DiscountCondition을 PeriodCondition, SequenceCondition으로 분리됨으로써
 * Movie의 결합도는 증가됨
 */
public class Main {
	public static void main(String[] args) {
		SequenceCondition sequenceDiscountCondition1 = new SequenceCondition(1);
		SequenceCondition sequenceDiscountCondition2 = new SequenceCondition(10);
		PeriodCondition periodDiscountCondition1 = new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0),
			LocalTime.of(11, 59));
		PeriodCondition periodDiscountCondition2 = new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(18, 0),
			LocalTime.of(21, 0));

		Movie movie = new Movie(
			"아바타",
			Duration.ofHours(2L),
			Money.wons(10000L),
			List.of(periodDiscountCondition1, periodDiscountCondition2),
			List.of(sequenceDiscountCondition1, sequenceDiscountCondition2),
			MovieType.AMOUNT_DISCOUNT,
			Money.wons(800),
			0
		);

		Screening screening = new Screening(movie, 1, LocalTime.of(6, 0).atDate(LocalDate.now()));

		Customer customer = new Customer("김용환", "yonghwan1234");

		int audienceCount = 1;

		Reservation reserve = screening.reserve(customer, audienceCount);
		System.out.println(reserve);
	}
}
