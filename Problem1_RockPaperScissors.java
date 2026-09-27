import java.util.Random;

public class Problem1_RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        boolean playerWins =
                (playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
                (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
                (playerMove.equals("Scissors") && computerMove.equals("Paper"));

        return playerWins ? "Player Wins" : "Computer Wins";
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        // Predefined player moves for a repeatable live demo.
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};

        Random random = new Random();
        int wins = 0, losses = 0, draws = 0;

        System.out.println("Round | Player Move | Computer Move | Result");
        System.out.println("------------------------------------------");

        for (int round = 1; round <= playerMoves.length; round++) {
            String playerMove = playerMoves[round - 1];
            String computerMove = moves[random.nextInt(moves.length)];

            String result = playRound(playerMove, computerMove);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println(round + "     | " + playerMove + "       | " + computerMove + "       | " + result);
        }

        double winPercentage = (wins * 100.0) / playerMoves.length;

        System.out.println();
        System.out.printf("Final Summary: Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercentage);
        // Note: the computer's move is randomized each run, so exact results will
        // vary between runs — only the table/summary format is fixed.
    }
}