package edu.volkov.mortalkombat.to;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Persistable;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class BaseTo<I> implements Persistable<I>, Serializable {

    protected I id;

    @Getter
    @Setter
    protected String name;

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
