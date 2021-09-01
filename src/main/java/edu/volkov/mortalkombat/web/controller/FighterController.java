package edu.volkov.mortalkombat.web.controller;

import edu.volkov.mortalkombat.service.CrudService;
import edu.volkov.mortalkombat.to.FighterTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = FighterController.REST_URL)
public class FighterController extends CrudController<FighterTo, Integer> {

    static final String REST_URL = "/fighter";

    public FighterController(CrudService<FighterTo, Integer> service) {
        super(service);
    }

    @GetMapping("/{id}")
    public FighterTo get(@PathVariable int id) {
        return super.get(id);
    }

    @GetMapping
    public List<FighterTo> getAll() {
        return super.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<FighterTo> create(@RequestBody FighterTo to) {
        return super.create(to, REST_URL);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody FighterTo to) {
        super.update(id, to);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        super.delete(id);
    }
}
