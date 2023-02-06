package org.example.entities;

import lombok.*;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Modulo {
    private ObjectId id;
    @NonNull
    private String nombre;
    @NonNull
    private String curso;
    @NonNull
    private int horasSemanales;
    @NonNull
    private Profesor profesor;
    @ToString.Exclude
    private List<Alumno> alumnos  = new ArrayList<>();

    public void addAlumnos(Alumno alumno) {
        this.alumnos.add(alumno);
    }
}
