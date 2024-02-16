package com.mockitotutorial.happyhotel.booking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class Test11Annotations{

	@InjectMocks
	private BookingService bookingService;
	
	@Mock
	private PaymentService paymentServiceMock;
	
	@Mock
	private RoomService roomServiceMock;
	
	@Spy
	private BookingDAO bookingDAOMock;
	
	@Mock
	private MailSender mailSenderMock;
	
	@Captor
	private ArgumentCaptor<Double> doubleCaptor;
	
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
