class Solution {
    public int[] secondGreaterElement(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];

        Arrays.fill(answer, -1);

        Stack<Integer> first = new Stack<>();
        Stack<Integer> second = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!second.isEmpty() && nums[second.peek()] < nums[i]) {

                int index = second.pop();
                answer[index] = nums[i];
            }

            Stack<Integer> temp = new Stack<>();

            while (!first.isEmpty() && nums[first.peek()] < nums[i]) {

                temp.push(first.pop());
            }

            while (!temp.isEmpty()) {

                second.push(temp.pop());
            }

            first.push(i);
        }

        return answer;
    }
}