package com.meli.calculadoracalorias.service;

import com.meli.calculadoracalorias.model.Ingrediente;
import com.meli.calculadoracalorias.repository.IngredienteRepository;
import com.meli.calculadoracalorias.response.IngredienteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredienteService {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    public List<IngredienteResponse> buscaTodosCaloriaDosIngredientes() {
        List<Ingrediente> ingredientes = ingredienteRepository.buscaTodosIngrediente();

        return ingredientes
                        .stream()
                        .map(i -> new IngredienteResponse(i.getName(), i.getCalories()))
                        .collect(Collectors.toList());
    }

    public IngredienteResponse buscaMaisCalorico() {
        Ingrediente ingrediente = ingredienteRepository.buscaMaisCalorico();
        return new IngredienteResponse(ingrediente.getName(), ingrediente.getCalories());
    }
}
