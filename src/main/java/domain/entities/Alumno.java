package domain.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Alumno {
    @Setter
    private String nombre;

    @Setter
    private String apellido;

    @Setter
    private String legajo;

    private List<Materia> materiasAprobadas;

    public Alumno() {
        this.materiasAprobadas = new ArrayList<>();
    }

    public void agregarMateriaAprobada(Materia ... materias) {
        Collections.addAll(this.materiasAprobadas, materias);
    }

    public boolean tenesAprobada(Materia unaMateria) {
        return this.materiasAprobadas.contains(unaMateria);
    }

    public boolean cumplisCorrelativasParaCursar(Materia unaMateria) {
        return unaMateria.getCorrelativas().stream().allMatch(this::tenesAprobada);
    }
}
