package dev.garces.spring.sec.service;

import java.util.List;

import dev.garces.spring.sec.model.HotelBranch;

public interface IHotelBranchService {

	
	
	public List<HotelBranch> listAll();
	public void save(HotelBranch branch);
	public HotelBranch SearchHotelBranch(Long id);
	public void deleteHotelBranch(Long id);
	 
	
}
