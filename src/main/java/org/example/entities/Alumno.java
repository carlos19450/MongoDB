package org.example.entities;

import lombok.ToString;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class Alumno  {
    private ObjectId id;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private int nia;
    private int numeroTelefono;
    @ToString.Exclude
    private List<Modulo> modulos = new ArrayList<>();
}
