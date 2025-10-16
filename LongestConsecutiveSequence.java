import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int longest = 0;

        for (int num : set) {
            // Only start counting when it's the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int streak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    streak++;
                }

                longest = Math.max(longest, streak);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        System.out.println("Input: [100, 4, 200, 1, 3, 2]");
        System.out.println("Output: " + longestConsecutive(nums1));

        System.out.println("\nInput: [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]");
        System.out.println("Output: " + longestConsecutive(nums2));
    }
}
