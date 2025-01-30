package com.example.flightbooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FlightService flightService;

    public Booking createBooking(Long flightId, String firstName, String lastName, String email) {
        Flight flight = flightService.getFlightById(flightId);
        
        if (flight != null) {
            Booking booking = new Booking();
            booking.setFlight(flight);
            booking.setFirstName(firstName);
            booking.setLastName(lastName);
            booking.setEmail(email);
            booking.setBookingDate(new Date());
            return bookingRepository.save(booking);
        }
        return null; // Flight not found
    }
}
