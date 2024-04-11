package com.ch4.class01.step01;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

/**
 * 데이터 중심 애플리케이션 설계
 */
public class ReservationAgency {
	public Reservation reserve(Screening screening, Customer customer, int audienceCount){
		Movie movie = screening.getMovie();

		boolean discountable = false;
		for (DiscountCondition condition : movie.getDiscountConditions()){
			if (condition.getType() == DiscountConditionType.PERIOD){
				discountable = screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek()) &&
					condition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
					condition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
			}else{
				discountable = condition.getSequence() == screening.getSequence();
			}

			if (discountable){
				break;
			}
		}

		Money fee;
		if (discountable){
			Money discountAmount = Money.ZERO;
			switch (movie.getMovieType()){
				case AMOUNT_DISCOUNT:
					discountAmount = movie.getDiscountAmount();
					break;
				case PERCENT_DISCOUNT:
					discountAmount = movie.getFee().times(movie.getDiscountPercent());
					break;
				case NONE_DISCOUNT:
					discountAmount = Money.ZERO;
					break;
			}

			fee = movie.getFee().minus(discountAmount).times(audienceCount);
		}else{
			fee = movie.getFee();
		}

		return new Reservation(customer, screening, fee, audienceCount);
	}

	public static void main(String[] args) {
		ReservationAgency agency = new ReservationAgency();
		Screening screening = new Screening();

		DiscountCondition sequenceDiscountCondition1 = new DiscountCondition();
		sequenceDiscountCondition1.setType(DiscountConditionType.SEQUENCE);
		sequenceDiscountCondition1.setSequence(1);

		DiscountCondition sequenceDiscountCondition2 = new DiscountCondition();
		sequenceDiscountCondition2.setType(DiscountConditionType.SEQUENCE);
		sequenceDiscountCondition2.setSequence(10);

		DiscountCondition periodDiscountCondition1 = new DiscountCondition();
		periodDiscountCondition1.setType(DiscountConditionType.PERIOD);
		periodDiscountCondition1.setDayOfWeek(DayOfWeek.MONDAY);
		periodDiscountCondition1.setStartTime(LocalTime.of(10, 0));
		periodDiscountCondition1.setEndTime(LocalTime.of(11, 59));

		DiscountCondition periodDiscountCondition2 = new DiscountCondition();
		periodDiscountCondition2.setType(DiscountConditionType.PERIOD);
		periodDiscountCondition2.setDayOfWeek(DayOfWeek.THURSDAY);
		periodDiscountCondition2.setStartTime(LocalTime.of(18, 0));
		periodDiscountCondition2.setEndTime(LocalTime.of(21, 0));

		screening.setMovie(new Movie(
			"아바타",
			Duration.ofHours(2L),
			Money.wons(10000L),
			List.of(sequenceDiscountCondition1, sequenceDiscountCondition2, periodDiscountCondition1, periodDiscountCondition2),
			MovieType.AMOUNT_DISCOUNT,
			Money.wons(800),
			0
			)
		);
		screening.setSequence(1);
		screening.setWhenScreened(LocalTime.of(6, 0).atDate(LocalDate.now()));

		Customer customer = new Customer("김용환", "yonghwan1234");

		int audienceCount = 1;

		Reservation reserve = agency.reserve(screening, customer, audienceCount);

		assert reserve.getCustomer() == customer;
		assert reserve.getScreening() == screening;
		assert reserve.getFee().getAmount().equals(9200L);
		assert reserve.getAudienceCount() == audienceCount;
		System.out.println("ok");
	}
}
