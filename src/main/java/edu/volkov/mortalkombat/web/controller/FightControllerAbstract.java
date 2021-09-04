package edu.volkov.mortalkombat.web.controller;

import edu.volkov.mortalkombat.service.CrudService;
import edu.volkov.mortalkombat.to.FightTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = FightControllerAbstract.REST_URL)
public class FightControllerAbstract extends AbstractCrudController<FightTo, Integer> {

    static final String REST_URL = "/fights/";

    public FightControllerAbstract(CrudService<FightTo, Integer> service) {
        super(service);
    }

    @GetMapping("{id}")
    public FightTo get(@PathVariable int id) {
        return super.get(id);
    }

    @GetMapping
    public List<FightTo> getAll() {
        return super.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<FightTo> create(@RequestBody FightTo to) {
        return super.create(to, REST_URL);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Integer id, @RequestBody FightTo to) {
        super.update(id, to);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        super.delete(id);
    }
}
