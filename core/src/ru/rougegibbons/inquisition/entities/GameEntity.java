package ru.rougegibbons.inquisition.entities;

import com.badlogic.ashley.core.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.rougegibbons.inquisition.core.Printable;

public interface GameEntity extends Printable {
    @NotNull
    ComponentHolder getComponents();

    @Nullable
    default Component getComponent(@NotNull Integer key) {
        return getComponents().getOrDefault(key, null);
    }

    default void attach(@NotNull Integer key,
                        @NotNull Component component,
                        @NotNull System.Logger logger) {
        String msg = "object: " + this.getClass().getName() + " " + this.getId() + "\n\t";
        if (getComponents().containsKey(key)) {
            msg += "Failed to add component" + component.getClass().getName() + " for key: " + key.toString() + "\n";
        } else {
            getComponents().put(key, component);
            msg += "added component " + component.getClass().getName() + "for key: " + key.toString() + "\n";
        }
        logger.log(System.Logger.Level.INFO, msg);
    }
}
