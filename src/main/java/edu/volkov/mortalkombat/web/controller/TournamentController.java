package edu.volkov.mortalkombat.web.controller;

import edu.volkov.mortalkombat.service.CrudService;
import edu.volkov.mortalkombat.to.TournamentTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = TournamentController.REST_URL)
public class TournamentController extends AbstractCrudController<TournamentTo, Integer> {

    static final String REST_URL = "/tournaments/";

    public TournamentController(CrudService<TournamentTo, Integer> service) {
        super(service);
    }

    @GetMapping("{id}")
    public TournamentTo get(@PathVariable int id) {
        return super.get(id);
    }

    @GetMapping
    public List<TournamentTo> getAll() {
        return super.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TournamentTo> create(@RequestBody TournamentTo to) {
        return super.create(to, REST_URL);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Integer id, @RequestBody TournamentTo to) {
        super.update(id, to);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        super.delete(id);
    }
}
