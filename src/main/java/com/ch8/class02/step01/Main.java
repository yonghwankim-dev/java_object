package com.ch8.class02.step01;

import java.time.Duration;
import java.time.LocalDateTime;

import com.ch8.class02.step01.domain.Customer;
import com.ch8.class02.step01.domain.Money;
import com.ch8.class02.step01.domain.Movie;
import com.ch8.class02.step01.domain.Reservation;
import com.ch8.class02.step01.domain.Screening;

public class Main {
	public static void main(String[] args) {
		// Movie 인스턴스 생성시 별도의 할인 정책을 전달하지 않으면 기본 정책인 금액 할인 정책(AmountDiscountPolicy)를 내부적으로 생성한다
		Movie movie = new Movie(
			"아바타",
			Duration.ofHours(2L),
			Money.wons(10000L)
		);

		Screening screening = new Screening(movie, 1, LocalDateTime.of(2024, 4, 15, 10, 0, 0));

		Customer customer = new Customer("김용환", "yonghwan1234");

		int audienceCount = 1;

		Reservation reserve = screening.reserve(customer, audienceCount);
		System.out.println(reserve);
	}
}
