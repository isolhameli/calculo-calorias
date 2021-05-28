package com.meli.calculadoracalorias.request;

import java.util.List;

public class PratoRequest {

    private String nome;

    private List<IngredienteRequest> ingredientes;

    public PratoRequest() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<IngredienteRequest> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteRequest> ingredienteRequests) {
        this.ingredientes = ingredienteRequests;
    }
}
