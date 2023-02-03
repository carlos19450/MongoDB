package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.example.entities.Movie;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
public class App
{
    public static void main( String[] args )
    {
        String uri = "mongodb://carlos:qwerty@ec2-52-90-109-81.compute-1.amazonaws.com:27017/pelis";

        // Paso 1: Query a base de datos
        // Por defecto, intentará conectar al puerto 27017
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("pelis");
            MongoCollection<Document> collection = database.getCollection("movies");
        }
    }
}
