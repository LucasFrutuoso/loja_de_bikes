package com.loja.loja_de_bikes.View.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.loja.loja_de_bikes.Services.BikeServices;
import com.loja.loja_de_bikes.Shared.BikeDto;
import com.loja.loja_de_bikes.View.Model.BikeRequest;
import com.loja.loja_de_bikes.View.Model.BikeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bike")
public class BikeController {

    @Autowired
    private BikeServices serviceBike;

    @GetMapping
    public ResponseEntity<List<BikeResponse>> consultarTodos() {

        List<BikeDto> bikes = serviceBike.consultarTodos();
        ModelMapper mapper = new ModelMapper();

        List<BikeResponse> response = bikes.stream()
                .map(bikeDto -> mapper.map(bikeDto, BikeResponse.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<BikeResponse>> consultarPorId(@PathVariable Long id) {

        Optional<BikeDto> dto = serviceBike.porId(id);

        BikeResponse bike = new ModelMapper()
                .map(dto.get(), BikeResponse.class);
        return new ResponseEntity<>(Optional.of(bike), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<BikeResponse> adicionar(@RequestBody BikeRequest request) {

        ModelMapper mapper = new ModelMapper();

        BikeDto dto = mapper.map(request, BikeDto.class);
        dto = serviceBike.adicionar(dto);
        return new ResponseEntity<>(mapper
                .map(dto, BikeResponse.class), HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {

        serviceBike.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BikeResponse> atualizar(@RequestBody BikeRequest request, @PathVariable Long id) {

        ModelMapper mapper = new ModelMapper();

        BikeDto bike = mapper.map(request, BikeDto.class);
        serviceBike.atualizar(id, bike);
        return new ResponseEntity<>(mapper
                .map(bike, BikeResponse.class), HttpStatus.OK);

    }

}
