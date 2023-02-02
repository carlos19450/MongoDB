package org.example.entities;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
    private ObjectId id;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private int numeroTelefono;
    private List<Direccion> direccion = new ArrayList<>();
}
