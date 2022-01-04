package com.loja.loja_de_bikes.View.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BikeRequest {
   
    private Integer aro;
    private Integer marchas;
    private String marca;
    private String cor;
    private String modelo;
    private String modeloFreio;
}
