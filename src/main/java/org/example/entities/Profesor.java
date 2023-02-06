package org.example.entities;

import lombok.*;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Profesor {
    private ObjectId id;
    @NonNull
    private String nombre;
    @NonNull
    private String primerApellido;
    @NonNull
    private String segundoApellido;
    @NonNull
    private int numeroTelefono;
    @NonNull
    private Direccion direccion;
    @ToString.Exclude
    private List<Modulo> modulo = new ArrayList<>();
}
