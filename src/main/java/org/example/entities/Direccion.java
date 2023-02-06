package org.example.entities;

import lombok.*;
import org.bson.types.ObjectId;
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Direccion {
    private ObjectId id;
    @NonNull
    private String calle;
    @NonNull
    private int numero;
    @NonNull
    private String poblacion;
    @NonNull
    private String provincia;
    @ToString.Exclude
    private Profesor profesor;
}
