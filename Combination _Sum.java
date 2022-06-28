class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> subList = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(subList, ans, candidates, target, 0);
        return ans;
    }

    private void backtracking(List<Integer> subList, List<List<Integer>> ans, int[] nums, int target, int first) {
        if (target == 0) {
            ans.add(new ArrayList<>(subList));
            return;
        }
        if (first == nums.length || target < nums[first]) {
            return;
        }
        subList.add(nums[first]);
        backtracking(subList, ans, nums, target - nums[first], first);
        subList.remove(subList.size() - 1);
        backtracking(subList, ans, nums, target, first + 1);
    }
}