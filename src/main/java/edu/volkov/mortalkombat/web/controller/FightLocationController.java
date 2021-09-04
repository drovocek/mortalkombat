package edu.volkov.mortalkombat.web.controller;

import edu.volkov.mortalkombat.service.CrudService;
import edu.volkov.mortalkombat.to.FightLocationTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = FightLocationController.REST_URL)
public class FightLocationController extends AbstractCrudController<FightLocationTo, Integer> {

    static final String REST_URL = "/fight-locations/";

    public FightLocationController(CrudService<FightLocationTo, Integer> service) {
        super(service);
    }

    @GetMapping("{id}")
    public FightLocationTo get(@PathVariable int id) {
        return super.get(id);
    }

    @GetMapping
    public List<FightLocationTo> getAll() {
        return super.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<FightLocationTo> create(@RequestBody FightLocationTo to) {
        return super.create(to, REST_URL);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Integer id, @RequestBody FightLocationTo to) {
        super.update(id, to);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        super.delete(id);
    }
}
