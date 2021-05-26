package com.example.tdd.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import models.BookingModel;

public interface BookingRepository extends JpaRepository<BookingModel, String> {

	Optional<BookingModel> findByReserveName(String name);

}
