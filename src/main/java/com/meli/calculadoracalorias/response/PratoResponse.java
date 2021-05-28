package com.meli.calculadoracalorias.response;

import java.util.List;

public class PratoResponse {

    private int caloriaTotal;

    public PratoResponse(int caloriaTotal) {
        this.caloriaTotal = caloriaTotal;
    }

    public int getCaloriaTotal() {
        return caloriaTotal;
    }

    public void setCaloriaTotal(int caloriaTotal) {
        this.caloriaTotal = caloriaTotal;
    }
}
