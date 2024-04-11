package com.ch5.class01.step04;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		DiscountCondition sequenceDiscountCondition1 = new SequenceCondition(1);
		DiscountCondition sequenceDiscountCondition2 = new SequenceCondition(10);
		DiscountCondition periodDiscountCondition1 = new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0),
			LocalTime.of(11, 59));
		DiscountCondition periodDiscountCondition2 = new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(18, 0),
			LocalTime.of(21, 0));

		Movie movie = new AmountDiscountMovie(
			"아바타",
			Duration.ofHours(2L),
			Money.wons(10000L),
			Money.wons(800L),
			periodDiscountCondition1, periodDiscountCondition2, sequenceDiscountCondition1, sequenceDiscountCondition2
		);

		Screening screening = new Screening(movie, 1, LocalTime.of(6, 0).atDate(LocalDate.now()));

		Customer customer = new Customer("김용환", "yonghwan1234");

		int audienceCount = 1;

		Reservation reserve = screening.reserve(customer, audienceCount);
		System.out.println(reserve);
	}
}
