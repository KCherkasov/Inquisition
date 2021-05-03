package ru.rougegibbons.inquisition.components.interfaces;

import com.badlogic.ashley.core.Component;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Set;

public interface MapComponent<Key, Value> extends Component {
    @NotNull Map<Key, Value> getValues();

    default void clear() {
        getValues().clear();
    }

    default @NotNull Set<Key> keyset() {
        return getValues().keySet();
    }


}
