package com.meli.calculadoracalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.calculadoracalorias.model.Ingrediente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class IngredienteRepository {

    @Autowired
    private ObjectMapper mapper;

    public List<Ingrediente> buscaTodosIngredientePorNome(List<String> ingredienteNomes) {
        List<Ingrediente> ingredientes = buscaTodosIngrediente();

        return ingredientes.stream()
                .filter(i -> ingredienteNomes.contains(i.getName()))
                .collect(Collectors.toList());
    }

    public List<Ingrediente> buscaTodosIngrediente() {
        TypeReference<List<Ingrediente>> typeReference = new TypeReference<>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/food.json");

        try {
            return mapper.readValue(inputStream,typeReference);
        } catch (IOException e){
            throw new RuntimeException("Não foi possível encontrar o arquivo food.json");
        }
    }


    public Ingrediente buscaMaisCalorico() {
        List<Ingrediente> ingredientes = buscaTodosIngrediente();

        return ingredientes.stream()
                            .max(Comparator.comparing(Ingrediente::getCalories))
                            .orElseThrow(RuntimeException::new);
    }
}
