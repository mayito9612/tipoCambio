package org.bedu.java.backend.retoSesion4.model;

public class Moneda {

    private String moneda;
    private double tipoCambio;

    public Moneda(String moneda, double v) {
        this.moneda = moneda;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String tipoMoneda) {
        this.moneda = tipoMoneda;
    }
    public Double getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(Double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }


}
