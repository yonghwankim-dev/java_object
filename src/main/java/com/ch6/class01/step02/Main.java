package com.ch6.class01.step02;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class Main {
	public static void main(String[] args) {
		Event meeting = new Event("회의", LocalDateTime.of(2019, 5, 9, 10, 30), Duration.ofMinutes(30));
		RecurringSchedule schedule = new RecurringSchedule("회의", DayOfWeek.WEDNESDAY, LocalTime.of(10, 30),
			Duration.ofMinutes(30));

		System.out.println(meeting.isSatisfiedBy(schedule));
		if (!meeting.isSatisfiedBy(schedule)){
			meeting.reschedule(schedule);
		}

		System.out.println(meeting.isSatisfiedBy(schedule));
	}
}
