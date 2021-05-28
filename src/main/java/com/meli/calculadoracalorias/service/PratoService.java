package com.meli.calculadoracalorias.service;

import com.meli.calculadoracalorias.model.Ingrediente;
import com.meli.calculadoracalorias.repository.IngredienteRepository;
import com.meli.calculadoracalorias.request.IngredienteRequest;
import com.meli.calculadoracalorias.request.PratoRequest;
import com.meli.calculadoracalorias.response.PratoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PratoService {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    public PratoResponse buscaCalorias(PratoRequest pratoRequest) {
        List<String> ingredienteNomes = pratoRequest.getIngredientes()
                                            .stream()
                                            .map(IngredienteRequest::getName)
                                            .collect(Collectors.toList());


        List<Ingrediente> ingredientes = ingredienteRepository.buscaTodosIngredientePorNome(ingredienteNomes);

        int totalDeCalorias = ingredientes.stream().mapToInt(Ingrediente::getCalories).sum();

        return new PratoResponse(totalDeCalorias);
    }
}
