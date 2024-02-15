package com.mockitotutorial.happyhotel.booking;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;

import org.junit.jupiter.api.*;

class Test04MultipleThenReturnCalls {

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

		this.bookingService = new BookingService(paymentServiceMock, roomServiceMock,
				bookingDAOMock, mailSenderMock);
	}

	@Test
	void should_CountAvailablePlaces_When_CalledMultipleTimes() {
		// given
		when(this.roomServiceMock.getAvailableRooms())
				.thenReturn(Collections.singletonList(new Room("Room 1", 5)))
				.thenReturn(Collections.emptyList());
		int expectedFirstCall = 5;
		int expectedSecondCall = 0;
		// when
		int actualFirst = bookingService.getAvailablePlaceCount();
		int actualSecond = bookingService.getAvailablePlaceCount();
		// then
		assertAll(() -> assertEquals(expectedFirstCall, actualFirst),
				() -> assertEquals(expectedSecondCall, actualSecond));
	}
}
