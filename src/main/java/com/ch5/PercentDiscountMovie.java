package com.ch5;

import java.time.Duration;

public class PercentDiscountMovie extends Movie{

	private final double perent;

	public PercentDiscountMovie(String title, Duration runningTime, Money fee, double perent,
		DiscountCondition... discountConditions) {
		super(title, runningTime, fee, discountConditions);
		this.perent = perent;
	}

	@Override
	protected Money calculateDiscountAmount() {
		return getFee().times(perent);
	}
}
