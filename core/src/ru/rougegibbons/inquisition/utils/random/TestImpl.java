package ru.rougegibbons.inquisition.utils.random;

import org.jetbrains.annotations.NotNull;
import ru.rougegibbons.inquisition.utils.random.interfaces.RollResult;
import ru.rougegibbons.inquisition.utils.random.interfaces.Test;

import java.util.ArrayList;
import java.util.List;

public class TestImpl implements Test {
    private final Integer diceType;
    private final RollResult result;
    private final Integer baseDifficulty;
    private final List<Integer> bonuses = new ArrayList<>();
    private final List<Integer> penalties = new ArrayList<>();

    public TestImpl(@NotNull Integer diceType,
                    @NotNull Integer baseDifficulty) {
        this.diceType = diceType;
        this.baseDifficulty = baseDifficulty;
        result = new RollResultImpl(this.diceType);
    }

    public TestImpl(@NotNull Integer diceType,
                    @NotNull List<Integer> result,
                    @NotNull Integer baseDifficulty,
                    @NotNull List<Integer> bonuses,
                    @NotNull List<Integer> penalties) {
        this.diceType = diceType;
        this.result = new RollResultImpl(this.diceType);
        this.result.getRolls().addAll(result);
        this.baseDifficulty = baseDifficulty;
        this.bonuses.addAll(bonuses);
        this.penalties.addAll(penalties);
    }

    @Override
    public @NotNull Integer getDiceType() {
        return diceType;
    }

    @Override
    public @NotNull RollResult getResult() {
        return result;
    }

    @Override
    public @NotNull List<Integer> getBonuses() {
        return bonuses;
    }

    @Override
    public @NotNull List<Integer> getPenalties() {
        return penalties;
    }

    @Override
    public @NotNull Integer getBaseDifficulty() {
        return baseDifficulty;
    }

    @Override
    public void resolve() {
        if (!isResolved()) {
            result.addRoll(DiceRoller.roll(diceType));
        }
    }
}
