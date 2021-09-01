package edu.volkov.mortalkombat.to.util;

import java.util.List;
import java.util.stream.Collectors;

public interface DOConverter<T, M> {

    T asTo(M model);

    M asModel(T to);

    default List<M> asModels(List<T> tos) {
        return tos.stream().map(this::asModel).collect(Collectors.toList());
    }

    default List<T> asTos(List<M> models) {
        return models.stream().map(this::asTo).collect(Collectors.toList());
    }

    M updateFromTo(M updated, T to);
}
