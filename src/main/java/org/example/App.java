package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;
import org.example.entities.*;
import org.example.repositories.AlumnoRepository;
import org.example.repositories.ModuloRepository;
import org.example.repositories.ProfesorRepository;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
public class App
{
    public static void main( String[] args )
    {
        //Crear alumno
        Alumno al1 = new Alumno("Pepe", "Ramon", "Floco", 65748347, 123456789);
        al1.setId(new ObjectId());
        Alumno al2 = new Alumno("Romo", "Grano", "Tran", 58745634, 987654321);
        al2.setId(new ObjectId());
        Alumno al3 = new Alumno("Paco", "Rodri", "Pleno", 56349053, 245801114);
        al3.setId(new ObjectId());
        //Crear direccion
        Direccion d1 = new Direccion("Pepon", 2, "Castellon", "Castellon");
        d1.setId(new ObjectId());
        //Crear profesor
        Profesor p1 = new Profesor("Paco", "Perez", "Cacho", 675648321, d1);
        p1.setId(new ObjectId());
        Profesor p2 = new Profesor("Ramon", "Romo", "Rama", 675648321, new Direccion("Ploton", 24, "Castellon", "Castellon"));
        p2.setId(new ObjectId());
        //Crear modulos
        Modulo m1 = new Modulo("Matematicas", "4", 16, p1, );
        m1.setId(new ObjectId());
        Modulo m2 = new Modulo("Ingles", "2", 8, p1, );
        m2.setId(new ObjectId());
        Modulo m3 = new Modulo("Programacion", "3", 9, p2, );
        m3.setId(new ObjectId());

        String uri = "mongodb://ec2-54-197-146-80.compute-1.amazonaws.com:27017";

        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("instituto").withCodecRegistry(pojoCodecRegistry);
            AlumnoRepository alumnos = new AlumnoRepository(database);
            ModuloRepository modulos = new ModuloRepository(database);
            ProfesorRepository profesores = new ProfesorRepository(database);
            database.drop();
            //Guardar modulos
            modulos.save(m1);
            modulos.save(m2);
            modulos.save(m3);

            //Mostrar todos los modulos
            System.out.println("Mostrar todos los modulos:");
            modulos.findAll().forEach(System.out::println);
            System.out.println();
            //Guardar alumnos
            alumnos.save(al1);
            alumnos.save(al2);
            alumnos.save(al3);

            //Mostrar todos los alumnos
            System.out.println("Mostrar todos los alumnos:");
            alumnos.findAll().forEach(System.out::println);

            System.out.println();

            //Actualizar modulo
            System.out.println("Actualizar las horas semanales del alumno m1:");
            m1.setHorasSemanales(6);
            modulos.updateById(m1);
            System.out.println(modulos.findOneById(m1.getId()));

            //Guardar profesores
            profesores.save(p1);
            profesores.save(p2);

            System.out.println();

            //Mostrar todos los profesores
            System.out.println("Mostrar todos los profesores:");
            profesores.findAll().forEach(System.out::println);

            System.out.println();

            //Borrar alumno por id
            System.out.println("Borrar alumno por id (al1):\n BORRANDO...");
            alumnos.deleteById(al1.getId());

            System.out.println();

            System.out.println("Ver si se ha borrado bien el alumno al1:");
            alumnos.findAll().forEach(System.out::println);
        }
    }
}
