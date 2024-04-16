package com.ch8.class02.step01.domain;

public class Reservation {
	private final Customer customer;
	private final Screening screening;
	private final Money fee;
	private final int audienceCount;

	public Reservation(Customer customer, Screening screening, Money fee, int audienceCount) {
		this.customer = customer;
		this.screening = screening;
		this.fee = fee;
		this.audienceCount = audienceCount;
	}

	@Override
	public String toString() {
		return "Reservation{" +
			"customer=" + customer +
			", screening=" + screening +
			", fee=" + fee +
			", audienceCount=" + audienceCount +
			'}';
	}
}
