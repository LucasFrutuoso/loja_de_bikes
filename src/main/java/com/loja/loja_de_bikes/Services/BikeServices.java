package com.loja.loja_de_bikes.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.loja.loja_de_bikes.Model.Bike;
import com.loja.loja_de_bikes.Repositories.BikeRepository;
import com.loja.loja_de_bikes.Shared.BikeDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BikeServices {

    @Autowired
    private BikeRepository repositoryBike;

    public List<BikeDto> consultarTodos() {

        List<Bike> bikes = repositoryBike.findAll();
        return bikes.stream()
                .map(b -> new ModelMapper().map(b, BikeDto.class))
                .collect(Collectors.toList());
    }

    public Optional<BikeDto> porId(Long id) {

        Optional<Bike> bike = repositoryBike.findById(id);
        BikeDto dto = new ModelMapper()
                .map(bike.get(), BikeDto.class);

        return Optional.of(dto);

    }

    public BikeDto adicionar(BikeDto bikeDto) {

        bikeDto.setId(null);

        ModelMapper mapper = new ModelMapper();

        Bike bike = mapper.map(bikeDto, Bike.class);
        bike = repositoryBike.save(bike);
        bikeDto.setId(bike.getId());
            
            return bikeDto;

    }

    public void deletar(Long id){
        Optional<Bike> bike = repositoryBike.findById(id);

        repositoryBike.deleteById(id);
    }


    public BikeDto atualizar(Long id, BikeDto bikeDto){

        bikeDto.setId(id);
        ModelMapper mapper = new ModelMapper();

        Bike bikes = mapper.map(bikeDto, Bike.class);
        repositoryBike.save(bikes);

        return bikeDto;

    }
}
