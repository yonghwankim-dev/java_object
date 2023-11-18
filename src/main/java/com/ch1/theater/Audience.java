package com.ch1.theater;

public class Audience {
	private final Bag bag;

	public Audience(Bag bag) {
		this.bag = bag;
	}

	public Bag getBag() {
		return bag;
	}

	public Long buy(Ticket ticket) {
		return bag.hold(ticket);
	}
}
