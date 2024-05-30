package dev.garces.spring.sec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import dev.garces.spring.sec.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{
	 Hotel findByHotelName(String hotelName);
}


