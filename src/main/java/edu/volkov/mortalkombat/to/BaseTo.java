package edu.volkov.mortalkombat.to;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class BaseTo<I> implements Persistable<I>, Serializable {

    protected I id;

    public I getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return id == null;
    }

    public void setId(I id) {
        this.id = id;
    }
}
