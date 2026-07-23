import java.util.*;

class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        return ans;
    }

    private void helper(int[] nums, int index, List<Integer> curr) {

        // Base Case
        if (index == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        // YES Choice (Include current element)
        curr.add(nums[index]);
        helper(nums, index + 1, curr);

        // Backtrack
        curr.remove(curr.size() - 1);

        // NO Choice (Exclude current element)
        helper(nums, index + 1, curr);
    }
}