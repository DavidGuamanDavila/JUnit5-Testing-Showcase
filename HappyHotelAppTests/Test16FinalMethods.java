package com.mockitotutorial.happyhotel.booking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.*;

class Test03ReturningCustomValues {

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
	void should_CountAvailablePlaces_When_OneRoomAvailable() {
		// given
		when(this.roomServiceMock.getAvailableRooms())
				.thenReturn(Collections.singletonList(new Room("Room 1", 5)));
		int expected = 5;
		// when
		int actual = bookingService.getAvailablePlaceCount();
		// then
		assertEquals(expected, actual);
	}
}
