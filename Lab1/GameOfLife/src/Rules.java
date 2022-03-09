import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Rules {
    CONWAYS(0),
    LABYRINTH(1),
    AMEBA(2),
    CITIES(3),
    CORAL(4),
    DIAMEBA(5);

    final int ruleNumber;

    Rules(int ruleNumber) {
        this.ruleNumber = ruleNumber;
    }

    public static Rules getRule(int number) {
        return Rules.values()[number];
    }

    public List<Integer> neighborsToRemainAlive() {
        List<Integer> toRemainAlive = new ArrayList<>();

        switch (this) {
            case CONWAYS -> toRemainAlive.addAll(Arrays.asList(2, 3));
            case LABYRINTH -> toRemainAlive.addAll(Arrays.asList(1, 2, 3, 4, 5));
            case AMEBA -> toRemainAlive.addAll(Arrays.asList(1, 3, 5, 8));
            case CITIES -> toRemainAlive.addAll(Arrays.asList(2, 3, 4, 5));
            case CORAL -> toRemainAlive.addAll(Arrays.asList(4, 5, 6, 7, 8));
            case DIAMEBA -> toRemainAlive.addAll(Arrays.asList(5, 6, 7, 8));
        }

        return toRemainAlive;
    }

    public List<Integer> neighborsToReborn() {
        List<Integer> toReborn = new ArrayList<>();

        switch (this) {
            case CONWAYS, LABYRINTH, CORAL -> toReborn.add(3);
            case AMEBA -> toReborn.addAll(Arrays.asList(3, 5, 7));
            case CITIES -> toReborn.addAll(Arrays.asList(4, 5, 6, 7, 8));
            case DIAMEBA -> toReborn.addAll(Arrays.asList(3, 5, 6, 7, 8));
        }

        return toReborn;
    }
}
