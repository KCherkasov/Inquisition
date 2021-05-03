package ru.rougegibbons.inquisition.utils.random.interfaces;

import org.jetbrains.annotations.NotNull;
import ru.rougegibbons.inquisition.constants.Generic;
import ru.rougegibbons.inquisition.core.Printable;

import java.util.List;

public interface RollResult extends Printable {
    @NotNull List<Integer> getRolls();

    @NotNull Integer getRollsCount();

    void addRoll(@NotNull Integer roll);

    @NotNull Integer getTotalRoll();

    @NotNull Integer getDiceType();

    void setDiceType(@NotNull Integer diceType);

    @Override
    default @NotNull String text(@NotNull Integer indent) {
        final StringBuilder result = new StringBuilder(getIndent(indent));
        result.append("Rolls data:");
        result.append(Generic.ENDL);
        result.append(getIndent(indent + Generic.ONE_INT));
        result.append("Dice type: d");
        result.append(getDiceType());
        result.append(Generic.ENDL);
        result.append(getIndent(indent + Generic.ONE_INT));
        result.append("Rolls: ");
        for (Integer roll : getRolls()) {
            result.append(roll.toString());
            result.append(Generic.SPACE);
        }
        if (result.length() > Generic.ZERO_INT) {
            result.setLength(result.length() - Generic.ONE_INT);
        }
        result.append(Generic.ENDL);
        result.append(getIndent(indent + Generic.ONE_INT));
        result.append("Total: ");
        result.append(getTotalRoll());
        result.append(Generic.ENDL);
        result.append(indent + Generic.ONE_INT);
        return result.toString();
    }
}
