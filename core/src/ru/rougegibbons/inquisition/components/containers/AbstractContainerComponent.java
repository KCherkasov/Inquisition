package ru.rougegibbons.inquisition.components.containers;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.rougegibbons.inquisition.components.interfaces.ContainerComponent;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractContainerComponent<T> implements ContainerComponent<T> {
    protected abstract @NotNull AtomicInteger getInstanceCounter();

    private final Integer id;
    private T value = null;

    public AbstractContainerComponent() {
        id = getInstanceCounter().getAndIncrement();
    }

    public AbstractContainerComponent(@NotNull Integer id,
                                      @Nullable T value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public @Nullable
    T getValue() {
        return value;
    }

    @Override
    public void setValue(@Nullable T value) {
        this.value = value;
    }
}
