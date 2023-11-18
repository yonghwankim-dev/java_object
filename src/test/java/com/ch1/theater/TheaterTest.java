package com.ch1.theater;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TheaterTest {

	@DisplayName("소극장은 관객에게 현금을 받고 티켓을 판매한다")
	@Test
	void enter(){
	    // given
		TicketOffice ticketOffice = new TicketOffice(0L, new Ticket(10000L));
		TicketSeller ticketSeller = new TicketSeller(ticketOffice);
		Theater theater = new Theater(ticketSeller);
		Audience audience = new Audience(new Bag(10000L));
		// when
	    theater.enter(audience);
	    // then
		assertThat(audience.getBag()).extracting("amount").isEqualTo(0L);
		assertThat(ticketOffice).extracting("amount").isEqualTo(10000L);
	}

}
