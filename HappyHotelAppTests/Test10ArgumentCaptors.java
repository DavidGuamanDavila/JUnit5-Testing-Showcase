package com.mockitotutorial.happyhotel.booking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.*;

import org.junit.jupiter.api.*;
import org.mockito.ArgumentCaptor;

class Test07VeryfyingBehaviour {

	private BookingService bookingService;
	private PaymentService paymentServiceMock;
	private RoomService roomServiceMock;
	private BookingDAO bookingDAOMock;
	private MailSender mailSenderMock;
  private ArgumentCaptor<Double> doubleCaptor;

	@BeforeEach
	void setup() {
		this.paymentServiceMock = mock(PaymentService.class);
		this.roomServiceMock = mock(RoomService.class);
		this.bookingDAOMock = mock(BookingDAO.class);
		this.mailSenderMock = mock(MailSender.class);
		this.bookingService = new BookingService(paymentServiceMock, roomServiceMock, bookingDAOMock, mailSenderMock);
    this.doubleCaptor = ArgumentCaptor.forClass(Double.class);
	}
	
	@Test
	void should_PayCorrectPrice_When_InputOK() {
		// given
		BookingRequest bookingRquest = new BookingRequest("1", LocalDate.of(2020, 01, 01),
			LocalDate.of(2020, 01, 05), 2, true);
		// when
		bookingService.makeBooking(bookingRequest);
		// taken
		verify(paymentServiceMock, times(1)).pay(eq(bookingRequest), doubleCaptor.capture());
    double capturedArgument = doubleCaptor.getValue();
    System.out.println(capturedArgument);

    assertEquals(400.0, capturedArgument);
	}

  	@Test
	void should_PayCorrectPrices_When_MultipleCalls() {
		// given
		BookingRequest bookingRquest = new BookingRequest("1", LocalDate.of(2020, 01, 01),
			LocalDate.of(2020, 01, 05), 2, true);
    BookingRequest bookingRquest2 = new BookingRequest("1", LocalDate.of(2020, 01, 01),
			LocalDate.of(2020, 01, 05), 2, true);
    List<Double> expectedValues = Arrays.asList(400.0, 100.0);
    
		// when
		bookingService.makeBooking(bookingRequest);
    bookingService.makeBooking(bookingRequest2);
		// taken
		verify(paymentServiceMock, times(2)).pay(any(), doubleCaptor.capture());
    List<double> capturedArguments = doubleCaptor.getAllValues();
    System.out.println(capturedArguments);

    assertEquals(400.0, capturedArguments);
	}
}
