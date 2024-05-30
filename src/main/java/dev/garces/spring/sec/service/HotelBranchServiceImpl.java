package dev.garces.spring.sec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.garces.spring.sec.model.HotelBranch;
import dev.garces.spring.sec.repository.HotelBranchRepository;

@Service
public class HotelBranchServiceImpl implements IHotelBranchService {

	@Autowired
	private HotelBranchRepository hotelBranchRepository;

	@Override
	public List<HotelBranch> listAll() {
		return (List<HotelBranch>) hotelBranchRepository.findAll();
	}

	@Override
	public void save(HotelBranch branch) {
		hotelBranchRepository.save(branch);

	}

	@Override
	public HotelBranch SearchHotelBranch(Long id) {
	
		return hotelBranchRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteHotelBranch(Long id) {
		hotelBranchRepository.deleteById(id);

	}

}
