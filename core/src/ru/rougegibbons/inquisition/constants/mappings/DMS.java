package ru.rougegibbons.inquisition.constants.mappings;

public final class DMS {
    private DMS() {

    }

    public static final int POSITIVE_CAP = 100;
    public static final int NEGATIVE_CAP = -100;

    public static final class Affections {
        private Affections() {
        }

        public static final int DECEIVE = 0;
        public static final int VIOLENCE = 1;
        public static final int MURDER = 2;
        public static final int SOCIAL = 3;
        public static final int ILLEGAL = 4;
        public static final int SCIENCE = 5;
        public static final int CRAFT = 6;
        public static final int STEALTH = 7;
    }

    public static final class Background {
        private Background() {
        }

        public static final int HOMEWORLD = 0;
        public static final int AFFILIATION = 1;
        public static final int ARCHETYPE = 2;
        public static final int RELIGION = 3;
        public static final int TRAITS = 4;
    }

    public static final class Social {
        private Social() {

        }

        public static final int GROUP = 0;
        public static final int SUBGROUP = 1;
        public static final int STATUS = 2;
    }

    public static final class Religion {
        private Religion() {

        }

        public static final int RELIGION = 0;
        public static final int BRANCH = 1;
    }

    public static final class Approvals {
        private Approvals() {
        }

        public static final int GENDER = 0;
        public static final int BACKGROUND = 1;
        public static final int RELIGION = 2;
        public static final int SOCIAL = 3;
        public static final int STATS = 4;
        public static final int AFFECTIONS = 5;
    }

    public static final class Psychology {
        private Psychology() {

        }

        public static final int DILIGENCE = 0;
        public static final int IDENTITY = 1;
        public static final int PRINCIPALITY = 2;
        public static final int MORAL = 3;
        public static final int CONSCIENCE = 4;
        public static final int EDUCABILITY = 5;
        public static final int INDEPENDENCE = 6;
        public static final int AUTHORITY = 7;
    }
}
