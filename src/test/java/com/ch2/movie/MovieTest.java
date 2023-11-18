package com.ch2.movie;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MovieTest {

	@DisplayName("상영 시간에 따라 표값을 계산한다")
	@Test
	void calculateMovieFee(){
	    // given
		Movie avatar = new Movie("아바타",
			Duration.ofMinutes(120),
			Money.wons(10000),
			new AmountDiscountPolicy(Money.wons(800),
				new SequenceCondition(1),
				new SequenceCondition(10),
				new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
				new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))));
		Screening screening = new Screening(avatar, 1, LocalDateTime.of(2023, 11, 20, 10, 0, 0));

		Movie titanic = new Movie("타이타닉",
			Duration.ofMinutes(180),
			Money.wons(11000),
			new PercentDiscountPolicy(0.1,
				new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
				new SequenceCondition(2),
				new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))));
		Screening screening2 = new Screening(titanic, 1, LocalDateTime.of(2023, 11, 21, 14, 0, 0));
		// when
		Money money = avatar.calculateMovieFee(screening);
		Money money2 = titanic.calculateMovieFee(screening2);
		// then
		Assertions.assertThat(money).extracting("amount").isEqualTo(BigDecimal.valueOf(9200));
		Assertions.assertThat(money2).extracting("amount").isEqualTo(BigDecimal.valueOf(9900.0));
	}

}
