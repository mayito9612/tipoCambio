package org.bedu.java.backend.retoSesion4.service;

import org.bedu.java.backend.retoSesion4.exception.MonedaAlreadyExistsException;
import org.bedu.java.backend.retoSesion4.exception.MonedaNotFoundException;
import org.bedu.java.backend.retoSesion4.model.Moneda;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MonedaService {
    private final Map<String, Moneda> listMoneda;

    public MonedaService() {
        Moneda mxn = new Moneda("MXN", 2.30);
        Moneda uds = new Moneda("USD", 5.90);
        listMoneda = new HashMap<>();
        listMoneda.put(mxn.getMoneda(), mxn);
        listMoneda.put(uds.getMoneda(), uds);
    }
    public boolean existe(String id) {
        return listMoneda.containsKey(id);
    }

    public List<String> moneda(String id) {
        if (!existe(id))
            throw new MonedaNotFoundException(id);

        Moneda moneda = listMoneda.get(id);
        return listMoneda.values()
                .stream()
                .filter(c -> !Objects.equals(c.getMoneda(), id))
                .map(c -> c.getMoneda()
                        .concat(convertMoneda(c,moneda)))
                .collect(Collectors.toList());
    }
    public List<String> cambio(String id, double cantidad) {
        if (!existe(id))
            throw new MonedaNotFoundException(id);
        return listMoneda.values()
                .stream()
                .filter(c -> !Objects.equals(c.getMoneda(), id))
                .map(c -> c.getMoneda().concat(convertMoneda(c,cantidad)))
                .collect(Collectors.toList());
    }
    public List<String> getAll() {
        return new ArrayList<>(listMoneda.keySet());
    }


    public Moneda agregar(Moneda moneda) {
        if (existe(moneda.getMoneda())) {
            throw new MonedaAlreadyExistsException();
        }

        listMoneda.put(moneda.getMoneda().toUpperCase(), moneda);
        return moneda;
    }
    public void remove(String moneda) {
        if (!existe(moneda)) {
            throw new MonedaNotFoundException(moneda);
        }
        listMoneda.remove(moneda);
    }
    public String convertMoneda(Moneda res, Moneda ref){
        return " : ".concat(String.format("%.3f",res.getTipoCambio() / ref.getTipoCambio()));
    }
    public String convertMoneda(Moneda ref, double cantidad){
        return " : ".concat(String.format("%.3f", ref.getTipoCambio() * cantidad));
    }
}
