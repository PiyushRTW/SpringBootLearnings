package com.learning.RailwayCrud.repository;

import com.learning.RailwayCrud.entity.Trains;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainsRepository extends JpaRepository<Trains, Long> {
}
