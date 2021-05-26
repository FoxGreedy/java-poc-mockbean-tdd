package com.example.tdd;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.tdd.services.BookingService;

@RunWith(SpringRunner.class)
public class BookingServiceTest {

	@TestConfiguration
	static class BookingServiceTestConfiguration {
		
		@Bean
		public BookingService bookingService() {
			return new BookingService();
		}
	}

	@Autowired
	BookingService bookingService;

	@Test
	public void bookingServiceDaysCalculator() {
		String name = "Michelli";
		int days = bookingService.daysCalculatorWithDatabase(name);

		Assertions.assertEquals(days, 10);
	}

}
