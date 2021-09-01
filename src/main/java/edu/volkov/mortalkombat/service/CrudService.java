package edu.volkov.mortalkombat.service;

import edu.volkov.mortalkombat.to.BaseTo;

import java.util.List;

public interface CrudService<T extends BaseTo<I>, I extends Number> {

    T get(I id);

    List<T> getAll();

    T create(T to);

    void update(I id, T to);

    void delete(I id);
}
