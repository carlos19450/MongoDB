package org.example.entities;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Modulo {
    private ObjectId id;
    private String nombre;
    private int curso;
    private int horasSemanales;
    private Profesor profesor;
    private List<Alumno> alumnos  = new ArrayList<>();
}
