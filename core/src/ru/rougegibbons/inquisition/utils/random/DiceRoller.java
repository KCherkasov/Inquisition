package ru.rougegibbons.inquisition.utils.random;

import org.jetbrains.annotations.NotNull;
import ru.rougegibbons.inquisition.constants.DiceRolling;
import ru.rougegibbons.inquisition.constants.Generic;
import ru.rougegibbons.inquisition.core.GameObject;

import java.util.Random;

public final class DiceRoller implements GameObject {
    private DiceRoller() {
    }

    public static final Random generator = new Random(System.currentTimeMillis());

    public static void reseed() {
        generator.setSeed(System.currentTimeMillis());
    }

    @NotNull
    public static Integer roll(@NotNull Integer diceType,
                               @NotNull Integer diceCount) {
        int result = Generic.ZERO_INT;
        for (int i = Generic.ZERO_INT; i < diceCount; ++i) {
            result += (generator.nextInt() % diceType);
            ++result;
        }
        return result;
    }

    @NotNull
    public static Integer roll(@NotNull Integer diceType) {
        return roll(diceType, Generic.ONE_INT);
    }

    @NotNull
    public static Integer rollD10(@NotNull Integer diceCount) {
        return roll(DiceRolling.DT_D10, diceCount);
    }

    @NotNull
    public static Integer rollD10() {
        return rollD10(Generic.ONE_INT);
    }

    @NotNull
    public static Integer rollD100(@NotNull Integer dice_count) {
        return roll(DiceRolling.DT_D100, dice_count);
    }

    @NotNull
    public static Integer rollD100() {
        return rollD100(Generic.ONE_INT);
    }

    @NotNull
    public static Integer rollD6(@NotNull Integer dice_count) {
        return roll(DiceRolling.DT_D6, dice_count);
    }

    @NotNull
    public static Integer rollD6() {
        return rollD6(Generic.ONE_INT);
    }

    @NotNull
    public static Integer rollD5(@NotNull Integer dice_count) {
        return roll(DiceRolling.DT_D5, dice_count);
    }

    @NotNull
    public static Integer rollD5() {
        return rollD5(Generic.ONE_INT);
    }
}
