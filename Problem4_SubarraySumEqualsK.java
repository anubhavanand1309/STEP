import java.util.HashMap;
import java.util.Map;

public class Problem4_SubarraySumEqualsK {

    static int subarraySum(int[] nums, int k) {
        // Frequency of each prefix sum seen so far. The empty prefix (sum 0)
        // must be seeded with count 1 so a subarray starting at index 0 counts correctly.
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;

            // If (currentSum - k) has been seen before, each occurrence marks
            // the start of a subarray ending here that sums to exactly k.
            int needed = currentSum - k;
            count += prefixSumCount.getOrDefault(needed, 0);

            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2)); // 2
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0)); // 3
    }
}