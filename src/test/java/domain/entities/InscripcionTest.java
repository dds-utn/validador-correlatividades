package domain.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InscripcionTest {
    private Alumno john;
    private Materia algoritmos;
    private Materia paradigmas;
    private Materia disenio;
    private Materia analisisDeSistemas;

    @BeforeEach
    public void init() {
       john = new Alumno();
       john.setNombre("John");
       john.setApellido("Doe");

       algoritmos = new Materia("Algoritmos", "1000");
       paradigmas = new Materia("Paradigmas", "2000");
       analisisDeSistemas = new Materia("Análisis de Sistemas", "2001");
       disenio = new Materia("Diseño", "3000");

       analisisDeSistemas.agregarCorrelativa(algoritmos);
       paradigmas.agregarCorrelativa(algoritmos);
       disenio.agregarCorrelativa(paradigmas, analisisDeSistemas);
    }

    @Test
    @DisplayName("La inscripción está aceptada por cumplir con correlativas")
    public void inscripcionEstaAceptadaTest() {
        john.agregarMateriaAprobada(algoritmos);

        Inscripcion unaInscripcion = new Inscripcion();
        unaInscripcion.setAlumno(john);
        unaInscripcion.anotarseA(analisisDeSistemas, paradigmas);

        Assertions.assertTrue(unaInscripcion.estaAprobada());
    }

    @Test
    @DisplayName("La inscripción no se acepta por no tener todas las correlativas")
    public void laInscripcionNoEstaAprobadaTest() {
        john.agregarMateriaAprobada(paradigmas);

        Inscripcion unaInscripcion = new Inscripcion();
        unaInscripcion.setAlumno(john);
        unaInscripcion.anotarseA(disenio);

        Assertions.assertFalse(unaInscripcion.estaAprobada());
    }
}
