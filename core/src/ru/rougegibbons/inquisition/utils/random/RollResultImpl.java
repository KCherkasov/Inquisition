package ru.rougegibbons.inquisition.utils.random;

import org.jetbrains.annotations.NotNull;
import ru.rougegibbons.inquisition.constants.Generic;
import ru.rougegibbons.inquisition.utils.random.interfaces.RollResult;

import java.util.ArrayList;
import java.util.List;

public class RollResultImpl implements RollResult {
    private final List<Integer> rolls = new ArrayList<>();
    private Integer diceType;

    public RollResultImpl(@NotNull Integer diceType) {
        this.diceType = diceType;
    }

    public RollResultImpl(@NotNull List<Integer> rolls,
                          @NotNull Integer diceType) {
        this.rolls.addAll(rolls);
        this.diceType = diceType;
    }

    @Override
    @NotNull
    public final List<Integer> getRolls() {
        return rolls;
    }

    @Override
    @NotNull
    public Integer getRollsCount() {
        return rolls.size();
    }

    @Override
    public void addRoll(@NotNull Integer roll) {
        rolls.add(roll);
    }

    @Override
    @NotNull
    public Integer getTotalRoll() {
        int result = Generic.ZERO_INT;
        for (Integer roll : rolls) {
            result += roll;
        }
        return result;
    }

    @Override
    @NotNull
    public Integer getDiceType() {
        return diceType;
    }

    @Override
    public void setDiceType(@NotNull Integer diceType) {
        this.diceType = diceType;
    }
}
