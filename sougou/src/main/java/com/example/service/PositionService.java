package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.Position;
import com.example.repository.PositionRepository;

@Service
public class PositionService {

	@Autowired
	public PositionRepository positionRepository;

	public List<Position> findAll(){
		return positionRepository.findAll();
	}

}
