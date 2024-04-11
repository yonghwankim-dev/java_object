package com.ch1.theater.step01;

import java.time.LocalDateTime;
import java.util.Collections;

public class Main {
	public static void main(String[] args) {
		Audience audience = new Audience(new Bag(new Invitation(LocalDateTime.now()), 0L));
		Theater theater = new Theater(new TicketSeller(new TicketOffice(0L, new Ticket())));
		theater.enter(audience);

	}
}
