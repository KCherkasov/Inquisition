package ru.rougegibbons.inquisition.utils.random.interfaces;

import org.jetbrains.annotations.NotNull;
import ru.rougegibbons.inquisition.constants.DiceRolling;
import ru.rougegibbons.inquisition.constants.Generic;
import ru.rougegibbons.inquisition.constants.dh2.D100;
import ru.rougegibbons.inquisition.core.Printable;

import java.util.List;

public interface Test extends Printable {
    @NotNull Integer getDiceType();

    @NotNull RollResult getResult();

    default @NotNull Boolean isResolved() {
        return getResult().getRolls().isEmpty();
    }

    @NotNull List<Integer> getBonuses();

    @NotNull List<Integer> getPenalties();

    default @NotNull Integer getBonus() {
        int result = Generic.ZERO_INT;
        for (Integer bonus : getBonuses()) {
            result += bonus;
        }
        return result;
    }

    default @NotNull Integer getPenalty() {
        int result = Generic.ZERO_INT;
        for (Integer penalty : getPenalties()) {
            result -= penalty;
        }
        return result;
    }

    @NotNull Integer getBaseDifficulty();

    default @NotNull Integer getTotalDifficulty() {
        return getBaseDifficulty() + getBonus() + getPenalty();
    }

    default @NotNull Integer getDegrees() {
        return (getTotalDifficulty() - getResult().getTotalRoll()) / DiceRolling.SUCCESS_DEGREE;
    }

    default @NotNull Boolean isSuccess() {
        return isResolved() && (getDegrees() >= Generic.ZERO_INT)
                && (getResult().getTotalRoll() >= D100.AUTO_FAIL_CAP);
    }

    default @NotNull Boolean isFailure() {
        return isResolved() && (getDegrees() < Generic.ZERO_INT)
                && (getResult().getTotalRoll() <= D100.AUTO_PASS_CAP);
    }

    void resolve();

    @Override
    default @NotNull String text(@NotNull Integer indent) {
        final StringBuilder result = new StringBuilder(getIndent(indent));
        result.append("Test results:");
        result.append(Generic.ENDL);
        result.append(getIndent(indent + Generic.ONE_INT));
        result.append("Dice type: d");
        result.append(getDiceType().toString());
        result.append(Generic.ENDL);
        result.append(getIndent(indent + Generic.ONE_INT));
        result.append("Difficulty: ");
        result.append(getTotalDifficulty().toString());
        result.append(Generic.ENDL);
        result.append(getIndent(indent + Generic.ONE_INT + Generic.ONE_INT));
        result.append("Base difficulty: ");
        result.append(getBaseDifficulty().toString());
        result.append(Generic.ENDL);
        result.append(getIndent(indent + Generic.ONE_INT + Generic.ONE_INT));
        result.append("Bonus: ");
        result.append(getBonus());
        if (!getBonuses().isEmpty()) {
            for (Integer bonus : getBonuses()) {
                result.append(Generic.ENDL);
                result.append(getIndent(indent + Generic.ONE_INT + Generic.ONE_INT + Generic.ONE_INT));
                result.append(bonus);
            }
        }
        result.append(Generic.ENDL);
        result.append(getIndent(indent + Generic.ONE_INT + Generic.ONE_INT));
        result.append("Penalty: ");
        result.append(getPenalty());
        if (!getPenalties().isEmpty()) {
            for (Integer penalty : getPenalties()) {
                result.append(Generic.ENDL);
                result.append(getIndent(indent + Generic.ONE_INT + Generic.ONE_INT + Generic.ONE_INT));
                result.append(penalty);
            }
        }
        result.append("resolved: ");
        if (!isResolved()) {
            result.append("no");
        } else {
            result.append("yes (");
            if (isSuccess()) {
                result.append("success - ");
                result.append(getDegrees().toString());
                result.append(" DoS)");
            } else {
                result.append("failure - ");
                result.append(getDegrees().toString());
                result.append(" DoF)");
            }
        }
        result.append(getResult().text(indent + Generic.ONE_INT));
        return result.toString();
    }
}
