package com.loja.loja_de_bikes.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Bike {
    
    @Id
    @GeneratedValue()
    private Long id;
    private Integer aro;
    private Integer marchas;
    private String marca;
    private String cor;
    private String modelo;
    private String modeloFreio;

   
   /**
    * COLAR NO POSTMAN

        "aro": 29,
        "marchas": 18,
        "marca": "GTSM",
        "cor": "Preto",
        "modelo": "Montain-Bike",
        "modeloFreio": "Disco"

    */
   
}
