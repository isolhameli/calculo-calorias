package com.meli.calculadoracalorias.controller;

import com.meli.calculadoracalorias.response.IngredienteResponse;
import com.meli.calculadoracalorias.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/ingrediente")
public class IngredienteController {

    @Autowired
    private IngredienteService ingredienteService;

    @GetMapping(value = "/todas/caloria" )
    public ResponseEntity<List<IngredienteResponse>> buscaTodosCaloriaDosIngredientes(){
        List<IngredienteResponse> responses = ingredienteService.buscaTodosCaloriaDosIngredientes();

        return ResponseEntity.ok(responses);
    }

    @GetMapping(value = "/maiscalorico" )
    public ResponseEntity<IngredienteResponse> buscaMaisCalorico(){
        IngredienteResponse response = ingredienteService.buscaMaisCalorico();

        return ResponseEntity.ok(response);
    }

}