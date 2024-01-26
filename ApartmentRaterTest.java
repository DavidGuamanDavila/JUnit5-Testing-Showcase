package com.realestateapp;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ApartmentRaterTest {

	@ParameterizedTest
	@CsvSource(value= {"72.0, 250000.0, 0", "48.0, 350000.0, 1", "30.0, 600000.0, 2", "48.0, 35000.0, 0"})
	void  should_ReturnCorrectRating_When_CorrectApartment(Double area, Double price, int rating){
		//given
		Apartment apartment = new Apartment(area, new BigDecimal(price));
		int expected = rating;
		//when
		int actual = ApartmentRater.rateApartment(apartment);
		//then
		assertEquals(expected, actual);
	}
	
	@Test
	void should_ReturnCorrectRating_When_CorrectApartment() {
		//given
		Apartment apartment = new Apartment(0.0, new BigDecimal(350000.0));
		int expected = -1;
		//when
		int actual = ApartmentRater.rateApartment(apartment);
		//then
		assertEquals(expected, actual);
		
	}
	
	@Test
	void should_CalculateAverageRating_When_CorrectApartmentList() {
		//given
		//when
		//then	
	}
	
	@Test
	void should_ThrowExeptionInCalculateAverageRating_When_EmptyApartmentList() {
		//given
		//when
		//then	
	}

}
