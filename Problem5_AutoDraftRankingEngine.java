import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5_AutoDraftRankingEngine {

    static class Player implements Comparable<Player> {
        private final String name;
        private final int matchesPlayed;
        private final double battingAverage; // used as the fantasy-points ranking metric
        private final boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        String getName() {
            return name;
        }

        int getMatchesPlayed() {
            return matchesPlayed;
        }

        boolean isInjured() {
            return injured;
        }

        // Ranks draftable players by fantasy points, descending — Arrays.sort does the rest.
        @Override
        public int compareTo(Player other) {
            return Double.compare(other.battingAverage, this.battingAverage);
        }
    }

    // Experience-only rule: a long track record qualifies on its own, fitness irrelevant.
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Combined rule for everyone else: reasonably experienced AND currently fit.
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    static String draftAndRank(Player[] players) {
        List<Player> draftable = new ArrayList<>();

        for (Player p : players) {
            if (isDraftable(p.getMatchesPlayed()) || isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                draftable.add(p);
            }
        }

        Player[] draftableArray = draftable.toArray(new Player[0]);
        Arrays.sort(draftableArray); // relies entirely on Player.compareTo

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append(i + 1).append(". ").append(draftableArray[i].getName());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players)); // 1. Rahul | 2. Virat | 3. Dev
    }
}