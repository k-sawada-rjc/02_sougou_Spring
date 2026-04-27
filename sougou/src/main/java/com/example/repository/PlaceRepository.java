package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bean.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, String> {

}
