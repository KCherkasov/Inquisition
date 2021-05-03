package ru.rougegibbons.inquisition.core;

import org.jetbrains.annotations.NotNull;
import ru.rougegibbons.inquisition.constants.Generic;

public interface Printable extends GameObject {
    @NotNull String text(@NotNull Integer indent);

    default @NotNull String getIndent(@NotNull Integer indent) {
        final StringBuilder result = new StringBuilder();
        for (int i = Generic.ZERO_INT; i < indent; ++i) {
            result.append(Generic.TAB);
        }
        return result.toString();
    }
}
