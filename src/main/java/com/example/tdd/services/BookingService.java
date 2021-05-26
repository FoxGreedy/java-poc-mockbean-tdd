package com.example.tdd.services;

import java.time.Period;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.tdd.repositories.BookingRepository;

import models.BookingModel;

public class BookingService {

	@Autowired
	BookingRepository bookingRepository;

	public int daysCalculatorWithDatabase(String name) {
		Optional<BookingModel> bookingModelOptional = bookingRepository.findByReserveName(name);

		return Period.between(bookingModelOptional.get().getCheckIn(), bookingModelOptional.get().getCheckOut())
				.getDays();
	}

}
