package com.ch5;

import java.time.Duration;
import java.util.List;

public class Movie {
	private String title;
	private Duration runningTime;
	private Money fee;
	private List<DiscountCondition> discountConditions;
	private MovieType movieType;
	private Money discountAmount;
	private double discountPercent;

	public Movie(String title, Duration runningTime, Money fee, List<DiscountCondition> discountConditions,
		MovieType movieType, Money discountAmount, double discountPercent) {
		this.title = title;
		this.runningTime = runningTime;
		this.fee = fee;
		this.discountConditions = discountConditions;
		this.movieType = movieType;
		this.discountAmount = discountAmount;
		this.discountPercent = discountPercent;
	}

	public String getTitle() {
		return title;
	}

	public Duration getRunningTime() {
		return runningTime;
	}

	public Money getFee() {
		return fee;
	}

	public List<DiscountCondition> getDiscountConditions() {
		return discountConditions;
	}

	public MovieType getMovieType() {
		return movieType;
	}

	public Money getDiscountAmount() {
		return discountAmount;
	}

	public double getDiscountPercent() {
		return discountPercent;
	}
}
