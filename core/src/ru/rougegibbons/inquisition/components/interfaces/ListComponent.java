package ru.rougegibbons.inquisition.components.interfaces;

import com.badlogic.ashley.core.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;

public interface ListComponent<T> extends Component {
    @NotNull List<T> getValues();

    default @Nullable T get(@NotNull Integer index) {
        return getValues().get(index);
    }

    default void add(@Nullable T value) {
        getValues().add(value);
    }

    default void addAll(@NotNull Collection<T> values) {
        getValues().addAll(values);
    }

    default void clear() {
        getValues().clear();
    }

    default @NotNull Boolean isEmpty() {
        return getValues().isEmpty();
    }
}
