package org.example.repositories;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;
import org.example.entities.Alumno;
import org.example.entities.Modulo;

import java.util.List;
import java.util.Optional;

import static com.mongodb.client.model.Filters.*;

public class AlumnoRepository implements Repository<Alumno> {
    private MongoCollection<Alumno> collection;

    public AlumnoRepository(MongoDatabase database) {
        collection = database.getCollection("alumnos", Alumno.class);
    }

    @Override
    public FindIterable<Alumno> findAll() {
        return collection.find();
    }

    @Override
    public Alumno findOneById(ObjectId id) {
        return collection.find(eq("_id", id)).first();
    }

    @Override
    public Alumno save(Alumno alumno) {
        collection.insertOne(alumno);
        return alumno;
    }

    @Override
    public Alumno updateById(Alumno alumno) {
        collection.replaceOne(eq("_id", alumno.getId()), alumno);
        return alumno;
    }

    @Override
    public void deleteById(ObjectId id) {
        collection.deleteOne(eq("_id", id));
    }

    public FindIterable<Alumno> findAllPendientes(MongoDatabase db) {
        return null;
    }
}
