package dev.garces.spring.sec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.garces.spring.sec.model.Hotel;
import dev.garces.spring.sec.repository.HotelRepository;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public List<Hotel> listAll() {
		return (List<Hotel>) hotelRepository.findAll();
	}

	@Override
	public List<Hotel> listHotelB() {
		return hotelRepository.findAll();

	}

	@Override
	public void save(Hotel hotel) {
		hotelRepository.save(hotel);

	}

	@Override
	public Hotel SearchHotel(Long id) {

		return hotelRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteHotel(Long id) {
		hotelRepository.deleteById(id);

	}

	@Override
	public List<Hotel> listHotel() {

		return (List<Hotel>) hotelRepository.findAll();
	}

	@Override
	public Hotel getHotelById(Long id) {
		return hotelRepository.findById(id).orElse(null);
	}

}
