package domain.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Materia {
    @Setter
    @Getter
    private String nombre;

    @Setter
    @Getter
    private String codigo;

    @Getter
    private List<Materia> correlativas;

    public Materia(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.correlativas = new ArrayList<>();
    }

    public void agregarCorrelativa(Materia ... correlativas) {
        Collections.addAll(this.correlativas, correlativas);
    }
}
