package com.example.flightbooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking bookFlight(@RequestParam Long flightId,
                              @RequestParam String firstName,
                              @RequestParam String lastName,
                              @RequestParam String email) {
        System.out.println("Received a POST request to create booking.");

        return bookingService.createBooking(flightId, firstName, lastName, email);
    }
}
