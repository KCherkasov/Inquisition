package ru.rougegibbons.inquisition.components.interfaces;

import org.jetbrains.annotations.Nullable;


public interface ContainerComponent<T> extends GameComponent {
    @Nullable T getValue();

    void setValue(@Nullable T value);

}

