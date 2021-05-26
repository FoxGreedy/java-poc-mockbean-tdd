package com.example.tdd;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.tdd.models.BookingModel;
import com.example.tdd.repositories.BookingRepository;
import com.example.tdd.services.BookingService;

@RunWith(SpringRunner.class)
public class BookingServiceTest {

	@Autowired
	BookingService bookingService;

	@MockBean
	BookingRepository bookingRepository;

	@Before
	public void setup() {
		LocalDate checkIn = LocalDate.parse("2020-11-10");
		LocalDate checkOut = LocalDate.parse("2020-11-20");

		BookingModel bookingModel = new BookingModel("1", "Michelli", checkIn, checkOut, 2);

		Mockito.when(bookingRepository.findByReserveName(bookingModel.getReserveName()))
				.thenReturn(Optional.of(bookingModel));
	}

	@TestConfiguration
	static class BookingServiceTestConfiguration {

		@Bean
		public BookingService bookingService() {
			return new BookingService();
		}
	}

	@Test
	public void bookingServiceDaysCalculator() {
		String name = "Michelli";
		int days = bookingService.daysCalculatorWithDatabase(name);

		Assertions.assertEquals(days, 10);
	}

}
