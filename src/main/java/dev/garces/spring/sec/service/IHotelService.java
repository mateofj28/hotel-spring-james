package dev.garces.spring.sec.service;

import java.util.List;

import dev.garces.spring.sec.model.Hotel;

public interface IHotelService {

	public List<Hotel> listAll();

	public void save(Hotel hotel);

	public Hotel SearchHotel(Long id);

	public void deleteHotel(Long id);

	List<Hotel> listHotel();

	Hotel getHotelById(Long id);

	List<Hotel> listHotelB();

}
