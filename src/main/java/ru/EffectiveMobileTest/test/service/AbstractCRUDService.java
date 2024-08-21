package ru.EffectiveMobileTest.test.service;


import org.springframework.data.repository.CrudRepository;
import ru.EffectiveMobileTest.test.service.interf.CRUDService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractCRUDService<E, K> implements CRUDService<E, K> {

    public abstract CrudRepository<E, K> getRepository();


    @Override
    public void create(E object) {
        getRepository().save(object);
    }


    @Override
    public E findById(K id) {
        return getRepository().findById(id).orElse(null);
    }


    @Override
    public List<E> findAll() {
        List<E> objects = new ArrayList<>();
        getRepository().findAll().forEach(objects::add);
        Collections.reverse(objects);
        return objects;
    }


    @Override
    public E update(E object) {
        getRepository().save(object);
        return object;
    }

    @Override
    public void deleteById(K id) {
        getRepository().deleteById(id);
    }

    @Override
    public void delete(E object) {
        getRepository().delete(object);
    }

    @Override
    public void deleteAll() {
        getRepository().deleteAll();
    }

    @Override

    public List<E> saveAll(List<E> l) {
        List<E> objects = new ArrayList<>();
        getRepository().saveAll(l).forEach(objects::add);
        Collections.reverse(objects);
        return objects;
    }
}