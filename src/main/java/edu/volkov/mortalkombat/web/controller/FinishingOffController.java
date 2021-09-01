package edu.volkov.mortalkombat.web.controller;

import edu.volkov.mortalkombat.service.CrudService;
import edu.volkov.mortalkombat.to.FinishingOffTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = FinishingOffController.REST_URL)
public class FinishingOffController extends CrudController<FinishingOffTo, Integer> {

    static final String REST_URL = "/finishing-off";

    public FinishingOffController(CrudService<FinishingOffTo, Integer> service) {
        super(service);
    }

    @GetMapping("/{id}")
    public FinishingOffTo get(@PathVariable int id) {
        return super.get(id);
    }

    @GetMapping
    public List<FinishingOffTo> getAll() {
        return super.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<FinishingOffTo> create(@RequestBody FinishingOffTo to) {
        return super.create(to, REST_URL);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody FinishingOffTo to) {
        super.update(id, to);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        super.delete(id);
    }
}
