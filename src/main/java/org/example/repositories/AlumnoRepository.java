package org.example.repositories;

import org.example.entities.Alumno;

import java.util.List;
import java.util.Optional;

public class AlumnoRepository implements Repository<Alumno>{
    private SessionFactory sf = HibernateUtil.getSessionFactory();
    private Session s = sf.openSession();
    @Override
    public List<Alumno> findAll() {
        s.getTransaction().begin();
        List<Alumno> alumno = s.createSelectionQuery("from Alumno ", Alumno.class).list();
        s.getTransaction().commit();
        return alumno;
    }

    @Override
    public Optional<Alumno> findOneById(int id) {
        s.getTransaction().begin();
        Alumno alumno = s.get(Alumno.class, id);
        s.getTransaction().commit();
        return Optional.ofNullable(alumno);
    }

    @Override
    public Alumno save(Alumno alumno) {
        s.getTransaction().begin();
        s.persist(alumno);
        s.getTransaction().commit();
        return alumno;
    }

    @Override
    public Optional<Alumno> updateById(int id) {
        s.getTransaction().begin();
        Alumno alumno = s.get(Alumno.class, id);
        s.merge(alumno);
        s.getTransaction().commit();
        return Optional.ofNullable(alumno);
    }

    @Override
    public Optional<Alumno> deleteById(int id) {
        s.getTransaction().begin();
        Alumno alumno = s.get(Alumno.class, id);
        s.remove(alumno);
        s.getTransaction().commit();
        return Optional.ofNullable(alumno);
    }
    public void close() {
        s.close();
        sf.close();
    }
}
