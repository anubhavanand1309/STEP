import java.util.LinkedHashMap;
import java.util.Map;

public class Problem4_FirstNonRepeatingChar {

    // Sentinel '\0' signals "not found" since the return type must stay char.
    static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> frequency = new LinkedHashMap<>();

        for (char c : text.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        for (char c : text.toCharArray()) {
            if (frequency.get(c) == 1) {
                return c;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        printResult("swiss"); // First Non-Repeating Character: 'w'
        printResult("aabbcc"); // No Non-Repeating Character Found
    }

    private static void printResult(String text) {
        char result = findFirstNonRepeatingChar(text);
        if (result == '\0') {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        }
    }
}