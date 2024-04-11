package com.ch4.class01.step01;

import java.time.LocalDateTime;

public class Screening {
	private Movie movie;
	private int sequence;
	private LocalDateTime whenScreened;

	public Movie getMovie() {
		return movie;
	}

	public int getSequence() {
		return sequence;
	}

	public LocalDateTime getWhenScreened() {
		return whenScreened;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public void setWhenScreened(LocalDateTime whenScreened) {
		this.whenScreened = whenScreened;
	}
}
