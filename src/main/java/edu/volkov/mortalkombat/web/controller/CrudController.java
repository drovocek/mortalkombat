package edu.volkov.mortalkombat.web.controller;

import edu.volkov.mortalkombat.service.CrudService;
import edu.volkov.mortalkombat.to.BaseTo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
public abstract class CrudController<T extends BaseTo<I>, I extends Number> {

    private final CrudService<T, I> service;

    public T get(I id) {
        return service.get(id);
    }

    public List<T> getAll() {
        return service.getAll();
    }

    public ResponseEntity<T> create(T to, String controllerMainUrl) {
        T created = service.create(to);
        URI uriOfNEwResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(controllerMainUrl).build().toUri();
        return ResponseEntity.created(uriOfNEwResource).body(created);
    }

    public void update(I id, T to) {
        service.update(id, to);
    }

    public void delete(I id) {
        service.delete(id);
    }
}
