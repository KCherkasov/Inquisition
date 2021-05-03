package ru.rougegibbons.inquisition.constants.dh2;

import ru.rougegibbons.inquisition.constants.Generic;

public final class D100 {
    private D100() {
    }

    public static final int MIN_DIFFICULTY = Generic.ZERO_INT;
    public static final int MAX_DIFFICULTY = 100;

    public static final int AUTO_FAIL_CAP = 96;
    public static final int AUTO_PASS_CAP = 4;
}
