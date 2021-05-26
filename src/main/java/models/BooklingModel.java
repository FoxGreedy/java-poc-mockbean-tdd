package models;

import java.time.LocalDate;

public class BooklingModel {

	private String id;
	private String reserveName;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private int numberGuest;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReserveName() {
		return reserveName;
	}

	public void setReserveName(String reserveName) {
		this.reserveName = reserveName;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public int getNumberGuest() {
		return numberGuest;
	}

	public void setNumberGuest(int numberGuest) {
		this.numberGuest = numberGuest;
	}

	public BooklingModel(String id, String reserveName, LocalDate checkIn, LocalDate checkOut, int numberGuest) {
		super();
		this.id = id;
		this.reserveName = reserveName;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.numberGuest = numberGuest;
	}

}
