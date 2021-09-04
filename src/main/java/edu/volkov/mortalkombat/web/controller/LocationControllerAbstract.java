package edu.volkov.mortalkombat.web.controller;

import edu.volkov.mortalkombat.service.CrudService;
import edu.volkov.mortalkombat.to.LocationTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = LocationControllerAbstract.REST_URL)
public class LocationControllerAbstract extends AbstractCrudController<LocationTo, Integer> {

    static final String REST_URL = "/locations/";

    public LocationControllerAbstract(CrudService<LocationTo, Integer> service) {
        super(service);
    }

    @GetMapping("{id}")
    public LocationTo get(@PathVariable int id) {
        return super.get(id);
    }

    @GetMapping
    public List<LocationTo> getAll() {
        return super.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<LocationTo> create(@RequestBody LocationTo to) {
        return super.create(to, REST_URL);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Integer id, @RequestBody LocationTo to) {
        super.update(id, to);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        super.delete(id);
    }
}
