package com.ch5;

import java.time.LocalDateTime;

public class Screening {
	private Movie movie;
	private int sequence;
	private LocalDateTime whenScreened;

	public int getSequence() {
		return sequence;
	}

	protected Movie getMovie() {
		return movie;
	}

	protected LocalDateTime getWhenScreened() {
		return whenScreened;
	}
}
