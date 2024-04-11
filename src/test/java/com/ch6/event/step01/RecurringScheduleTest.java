package com.ch6.event.step01;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ch6.class01.step01.RecurringSchedule;

class RecurringScheduleTest {

	@DisplayName("매주 수요일 10시 30분부터 30분동안 회의를 하는 반복일정을 생성한다")
	@Test
	void recurringSchedule(){
	    // given

	    // when
		RecurringSchedule schedule = new RecurringSchedule("회의", DayOfWeek.WEDNESDAY, LocalTime.of(10, 30),
			Duration.ofMinutes(30));
		// then
	}

}
