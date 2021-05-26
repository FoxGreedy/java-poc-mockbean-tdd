package com.example.tdd;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.tdd.models.BookingModel;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void bookingTestGetAll() throws Exception {
		mockMvc.perform(get("/bookings")).andExpect(status().isOk());
	}

	@Test
	public void bookingTestSave() throws Exception {
		LocalDate checkIn = LocalDate.parse("2020-11-10");
		LocalDate checkOut = LocalDate.parse("2020-11-20");

		BookingModel bookingModel = new BookingModel("1", "Michelli", checkIn, checkOut, 2);

		mockMvc.perform(post("/bookings").contentType("application/json")
				.content(objectMapper.writeValueAsString(bookingModel))).andExpect(status().isOk());
	}
}
