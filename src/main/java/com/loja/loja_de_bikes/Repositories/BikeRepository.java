package com.loja.loja_de_bikes.Repositories;

import com.loja.loja_de_bikes.Model.Bike;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long>{
    
}
