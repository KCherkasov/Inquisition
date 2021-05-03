package ru.rougegibbons.inquisition.components;


import org.jetbrains.annotations.Nullable;
import ru.rougegibbons.inquisition.components.interfaces.ContainerComponent;

public class ContainerComponentImpl<T> implements ContainerComponent<T> {
    private T value = null;

    public ContainerComponentImpl() {
    }

    public ContainerComponentImpl(@Nullable T value) {
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
