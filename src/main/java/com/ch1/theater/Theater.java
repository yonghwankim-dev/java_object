package com.ch1.theater;

public class Theater {
	private final TicketSeller ticketSeller;

	public Theater(TicketSeller ticketSeller) {
		this.ticketSeller = ticketSeller;
	}

	public void enter(Audience audience){
		ticketSeller.sellTo(audience);
	}
}
