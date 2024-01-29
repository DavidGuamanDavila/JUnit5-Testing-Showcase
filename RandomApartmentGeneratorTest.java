package com.realestateapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RandomApartmentGeneratorTest {
	private static final double MAX_MULTIPLIER = 4.0;
	
	@Nested
	class GeneratorDefaultParamsTests{
		private RandomApartmentGenerator generator;
		
		@BeforeEach
		void setup() {
			this.generator = new RandomApartmentGenerator();
		}
	}

}
