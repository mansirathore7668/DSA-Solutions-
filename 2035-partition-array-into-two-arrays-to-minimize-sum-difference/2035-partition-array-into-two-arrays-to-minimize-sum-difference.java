import java.util.*;

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int total = 0;

        for (int x : nums) {
            total += x;
        }

        List<Integer>[] left = new ArrayList[n + 1];
        List<Integer>[] right = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            left[i] = new ArrayList<>();
            right[i] = new ArrayList<>();
        }

        // Generate subset sums
        for (int mask = 0; mask < (1 << n); mask++) {
            int leftSum = 0;
            int rightSum = 0;
            int count = 0;

            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) {
                    count++;
                    leftSum += nums[j];
                    rightSum += nums[j + n];
                }
            }

            left[count].add(leftSum);
            right[count].add(rightSum);
        }

        // Sort right half subset sums
        for (int i = 0; i <= n; i++) {
            Collections.sort(right[i]);
        }

        int ans = Integer.MAX_VALUE;

        // Try all combinations
        for (int cnt = 0; cnt <= n; cnt++) {

            List<Integer> leftList = left[cnt];
            List<Integer> rightList = right[n - cnt];

            for (int leftSum : leftList) {

                int target = total / 2 - leftSum;

                int idx = Collections.binarySearch(rightList, target);

                if (idx < 0) {
                    idx = -idx - 1;
                }

                // Check current position
                if (idx < rightList.size()) {
                    int selected = leftSum + rightList.get(idx);
                    ans = Math.min(ans, Math.abs(total - 2 * selected));
                }

                // Check previous position
                if (idx > 0) {
                    int selected = leftSum + rightList.get(idx - 1);
                    ans = Math.min(ans, Math.abs(total - 2 * selected));
                }
            }
        }

        return ans;
    }
}
