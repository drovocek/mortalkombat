package edu.volkov.mortalkombat.service;

import edu.volkov.mortalkombat.model.AbstractBaseEntity;
import edu.volkov.mortalkombat.to.BaseTo;
import edu.volkov.mortalkombat.to.util.DOConverter;
import edu.volkov.mortalkombat.util.exception.NoSuchEntityException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.Assert;

import java.util.List;

public abstract class AbstractCrudService<T extends BaseTo<I>, M extends AbstractBaseEntity, I extends Number> implements CrudService<T, I> {

    protected JpaRepository<M, I> repository;
    protected DOConverter<T, M> converter;

    public T get(I id) {
        Assert.notNull(id, "Id must be not null");
        return repository.findById(id)
                .map(model -> converter.asTo(model))
                .orElseThrow(() -> new NoSuchEntityException(String.format("Entity with id: %s doesn't exist", id)));
    }

    public List<T> getAll() {
        return converter.asTos(repository.findAll());
    }

    public T create(T to) {
        Assert.notNull(to, "Entity must be not null");
        Assert.isTrue(to.isNew(), "Created entity must have id == null");
        M model = converter.asModel(to);
        return converter.asTo(repository.save(model));
    }

    public void update(I id, T to) {
        Assert.notNull(to, "Entity must be not null");
        M updated = converter.asModel(get(id));
        M forSave = converter.updateFromTo(updated, to);
        converter.asTo(repository.save(forSave));
    }

    public void delete(I id) {
        Assert.notNull(id, "Id must be not null");
        M deleted = converter.asModel(get(id));
        repository.delete(deleted);
    }
}
