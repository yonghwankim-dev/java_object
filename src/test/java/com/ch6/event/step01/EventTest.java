package com.ch6.event.step01;

import static org.assertj.core.api.Assertions.*;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ch6.class01.step01.Event;
import com.ch6.class01.step01.RecurringSchedule;

class EventTest {

	@DisplayName("반복일정이 이벤트를 만족하는지 검사")
	@Test
	void isSatisfiedBy(){
	    // given
		RecurringSchedule schedule = new RecurringSchedule("회의", DayOfWeek.WEDNESDAY, LocalTime.of(10, 30),
			Duration.ofMinutes(30));
		Event event = new Event("회의", LocalDateTime.of(2019, 5, 8, 10, 30), Duration.ofMinutes(30));

		RecurringSchedule schedule2 = new RecurringSchedule("회의", DayOfWeek.WEDNESDAY, LocalTime.of(10, 30),
			Duration.ofMinutes(30));
		Event event2 = new Event("회의", LocalDateTime.of(2019, 5, 9, 10, 30), Duration.ofMinutes(30));
		// when
		boolean result = event.isSatisfiedBy(schedule);
		boolean result2 = event2.isSatisfiedBy(schedule2);
		// then
		assertThat(result).isTrue();
		assertThat(result2).isFalse();
	}
}
