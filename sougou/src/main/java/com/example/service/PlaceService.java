package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.Place;
import com.example.repository.PlaceRepository;

@Service
public class PlaceService {

	@Autowired
	public PlaceRepository placeRepository;

	public List<Place> findAll() {
		return placeRepository.findAll();
	}
}
