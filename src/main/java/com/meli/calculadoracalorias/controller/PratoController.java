package com.meli.calculadoracalorias.controller;

import com.meli.calculadoracalorias.request.PratoRequest;
import com.meli.calculadoracalorias.response.PratoResponse;
import com.meli.calculadoracalorias.service.PratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/prato")
public class PratoController {

    @Autowired
    private PratoService pratoService;

    @GetMapping(value = "/calorie")
    public ResponseEntity<PratoResponse> buscaCalorias(@RequestBody PratoRequest pratoRequest){
        PratoResponse pratoResponse = pratoService.buscaCalorias(pratoRequest);

        return ResponseEntity.ok(pratoResponse);
    }

}
