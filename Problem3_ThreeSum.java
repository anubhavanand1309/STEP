import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3_ThreeSum {

    static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        List<int[]> triplets = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate values for the first position so the same triplet
            // never gets built starting from two different, equal, i's.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    triplets.add(new int[]{nums[i], nums[left], nums[right]});

                    // Skip duplicates for both pointers before moving on.
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // sum too small, move left pointer up
                } else {
                    right--; // sum too big, move right pointer down
                }
            }
        }

        return triplets.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] result1 = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (int[] triplet : result1) {
            System.out.println(Arrays.toString(triplet));
        }
        // [-1, -1, 2]
        // [-1, 0, 1]

        System.out.println();

        int[][] result2 = threeSum(new int[]{0, 0, 0});
        for (int[] triplet : result2) {
            System.out.println(Arrays.toString(triplet));
        }
        // [0, 0, 0]
    }
}