public class Problem4_MatchDayGridAnalyzer {

    // Does nothing but compute one row's average and return it.
    private static double rowAverage(int[] row) {
        int sum = 0;
        for (int over : row) {
            sum += over;
        }
        return (double) sum / row.length;
    }

    // The only place that decides Power Surge vs. Normal.
    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]); // reused, not recomputed inline
            String label = (avg >= threshold) ? "Power Surge" : "Normal";

            if (i > 0) {
                result.append(" | ");
            }
            result.append("Match ").append(i).append(": ").append(label);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] runsPerOver = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };

        System.out.println(classifyMatches(runsPerOver, 8));
        // Match 0: Normal | Match 1: Power Surge | Match 2: Normal
    }
}