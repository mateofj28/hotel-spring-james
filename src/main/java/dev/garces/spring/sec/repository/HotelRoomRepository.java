package dev.garces.spring.sec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.garces.spring.sec.model.HotelRoom;


@Repository
public interface HotelRoomRepository extends JpaRepository<HotelRoom, Long>{

}