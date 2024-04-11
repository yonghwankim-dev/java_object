package com.ch4.data.domain;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ch4.class01.step01.Customer;
import com.ch4.class01.step01.DiscountCondition;
import com.ch4.class01.step01.DiscountConditionType;
import com.ch4.class01.step01.Money;
import com.ch4.class01.step01.Movie;
import com.ch4.class01.step01.MovieType;
import com.ch4.class01.step01.Reservation;
import com.ch4.class01.step01.ReservationAgency;
import com.ch4.class01.step01.Screening;

class ReservationAgencyTest {

	@DisplayName("")
	@Test
	void reserve(){
	    // given
		ReservationAgency agency = new ReservationAgency();
		Money fee = Money.wons(10000);

		DiscountCondition condition1 = new DiscountCondition();
		condition1.setType(DiscountConditionType.SEQUENCE);
		condition1.setSequence(1);
		DiscountCondition condition2 = new DiscountCondition();
		condition2.setType(DiscountConditionType.SEQUENCE);
		condition2.setSequence(2);
		DiscountCondition condition3 = new DiscountCondition();
		condition3.setType(DiscountConditionType.PERIOD);
		condition3.setDayOfWeek(DayOfWeek.MONDAY);
		condition3.setStartTime(LocalTime.of(10, 0));
		condition3.setEndTime(LocalTime.of(12, 0));
		DiscountCondition condition4 = new DiscountCondition();
		condition4.setType(DiscountConditionType.PERIOD);
		condition4.setDayOfWeek(DayOfWeek.THURSDAY);
		condition4.setStartTime(LocalTime.of(18, 0));
		condition4.setEndTime(LocalTime.of(21, 0));
		List<DiscountCondition> conditions = List.of(condition1, condition2, condition3, condition4);

		Movie avatar = new Movie("아바타", Duration.ofMinutes(120), fee, conditions, MovieType.AMOUNT_DISCOUNT,
			Money.wons(800), 0.1);
		Screening screening = new Screening();
		screening.setMovie(avatar);
		screening.setSequence(1);
		screening.setWhenScreened(LocalDateTime.of(2023, 11, 26, 10, 0, 0));

		Customer customer = new Customer("네모네모", "1");
		int audienceCount = 2;
		// when
		Reservation reserve = agency.reserve(screening, customer, audienceCount);
		// then
		Assertions.assertThat(reserve)
			.extracting("fee")
			.extracting("amount")
			.isEqualTo(BigDecimal.valueOf(18400.0));
	}

}
