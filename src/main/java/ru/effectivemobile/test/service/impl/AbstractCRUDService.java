package ru.effectivemobile.test.service.impl;

import org.springframework.data.repository.CrudRepository;
import ru.effectivemobile.test.service.interf.CRUDService;

import java.util.ArrayList;

import java.util.List;

public abstract class AbstractCRUDService<E, K> implements CRUDService<E, K> {

    abstract CrudRepository<E, K> getRepository();

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

    public List<E> saveAll(List<E> obj) {
        List<E> objects = new ArrayList<>();
        getRepository().saveAll(obj).forEach(objects::add);
        return objects;
    }

}
