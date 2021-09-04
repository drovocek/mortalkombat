package edu.volkov.mortalkombat.service;

import edu.volkov.mortalkombat.model.AbstractBaseEntity;
import edu.volkov.mortalkombat.to.BaseTo;
import edu.volkov.mortalkombat.to.util.DOConverter;
import edu.volkov.mortalkombat.util.exception.NoSuchEntityException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.Assert;

import java.util.List;

@Slf4j
public abstract class AbstractCrudService<T extends BaseTo<I>, M extends AbstractBaseEntity, I extends Number> implements CrudService<T, I> {

    protected final JpaRepository<M, I> repository;
    protected final DOConverter<T, M> converter;

    protected AbstractCrudService(JpaRepository<M, I> repository, DOConverter<T, M> converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public T get(I id) {
        log.info("get by id: {}", id);
        Assert.notNull(id, "Id must be not null");
        return repository.findById(id)
                .map(converter::asTo)
                .orElseThrow(() -> new NoSuchEntityException(String.format("Entity with id: %s doesn't exist", id)));
    }

    public List<T> getAll() {
        log.info("getAll");
        return converter.asTos(repository.findAll());
    }

    public T create(T to) {
        log.info("create from to: {}", to);
        Assert.notNull(to, "Entity must be not null");
        Assert.isTrue(to.isNew(), "Created entity must have id == null");
        M model = converter.asModel(to);
        return converter.asTo(repository.save(model));
    }

    public void update(I id, T to) {
        log.info("update by id: {} from to: {} ", id, to);
        Assert.notNull(to, "Entity must be not null");
        M updated = converter.asModel(get(id));
        M forSave = converter.updateFromTo(updated, to);
        converter.asTo(repository.save(forSave));
    }

    public void delete(I id) {
        log.info("delete by id: {}", id);
        Assert.notNull(id, "Id must be not null");
        M deleted = converter.asModel(get(id));
        repository.delete(deleted);
    }
}
