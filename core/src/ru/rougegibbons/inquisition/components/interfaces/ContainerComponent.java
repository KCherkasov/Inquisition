package ru.rougegibbons.inquisition.components.interfaces;

import com.badlogic.ashley.core.Component;
import org.jetbrains.annotations.Nullable;


public interface ContainerComponent<T> extends Component {
    @Nullable T getValue();

    void setValue(@Nullable T value);

}

