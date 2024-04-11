package com.ch6.class01.step01;

import java.time.Duration;
import java.time.LocalDateTime;

public class Event {
	private String subject;
	private LocalDateTime from;
	private Duration duration;

	public Event(String subject, LocalDateTime from, Duration duration) {
		this.subject = subject;
		this.from = from;
		this.duration = duration;
	}

	public boolean isSatisfiedBy(RecurringSchedule schedule) {
		if (from.getDayOfWeek() != schedule.getDayOfWeek() ||
		!from.toLocalTime().equals(schedule.getFrom()) ||
		!duration.equals(schedule.getDuration())){
			reschedule(schedule);
			return false;
		}
		return true;
	}

	private void reschedule(RecurringSchedule schedule) {
		this.from = LocalDateTime.of(from.toLocalDate().plusDays(dayDistance(schedule)), schedule.getFrom());
		this.duration = schedule.getDuration();
	}

	private long dayDistance(RecurringSchedule schedule) {
		return schedule.getDayOfWeek().getValue() - from.getDayOfWeek().getValue();
	}
}
