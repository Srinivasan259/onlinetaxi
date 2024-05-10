package com.taxisys.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.taxisys.enity.Booking;

import jakarta.persistence.EntityManager;

@Repository
public class BookingDAOImplement implements BookingDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void addBooking(Booking booking) {

		entityManager.persist(booking);
	}

	@Override
	public List<Booking> findAllBooking() {
		return entityManager.createQuery("from Booking").getResultList();

	}

	@Override
	public Booking findBookingId(int bookingId) {
		return entityManager.find(Booking.class, bookingId);

	}

}
