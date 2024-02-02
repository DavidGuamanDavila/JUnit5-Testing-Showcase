package com.mockitotutorial.happyhotel.booking;

import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;


import java.time.LocalDate;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

class Test06Matchers {

	private BookingService bookingService;
	private PaymentService paymentServiceMock;
	private RoomService roomServiceMock;
	private BookingDAO bookingDAOMock;
	private MailSender mailSenderMock;

	@BeforeEach
	void setup() {
		this.paymentServiceMock = mock(PaymentService.class);
		this.roomServiceMock = mock(RoomService.class);
		this.bookingDAOMock = mock(BookingDAO.class);
		this.mailSenderMock = mock(MailSender.class);
		this.bookingService = new BookingService(paymentServiceMock, roomServiceMock, bookingDAOMock, mailSenderMock);
	}

	@Test
	void should_NotCompleteBooking_When_PriceTooHigh() {
		// given
		BookingRequest bookingRequest = new BookingRequest("45", LocalDate.of(2020, 01, 01), LocalDate.of(2020, 01, 05),
				2, true);
		when(this.paymentServiceMock.pay(any(), anyDouble())).thenThrow(BusinessException.class);
		// when
		Executable executable = () -> bookingService.makeBooking(bookingRequest);
		// taken
		assertThrows(BusinessException.class, executable);
	}

}
