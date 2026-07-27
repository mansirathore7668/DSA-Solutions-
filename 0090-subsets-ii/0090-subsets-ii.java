class Solution {
    List<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       Arrays.sort(nums);
       helper(nums,0,new ArrayList<>());
       return ans;

}
private void helper(int[] nums,int index,List<Integer>curr){
    ans.add(new ArrayList<>(curr));

    for(int i=index;i<nums.length;i++){
        if(i>index && nums[i]==nums[i-1]){
            continue;
        }
        curr.add(nums[i]);
        helper(nums,i+1,curr);
        curr.remove(curr.size()-1);
    }
}
}