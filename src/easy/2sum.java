package easy;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                res[0] = i;
                res[1] = map.get(nums[i]);
            }
            if (map.containsKey(target - nums[i])) {
                continue;
            } else {
                map.put(target- nums[i], i);
            }
        }
        return res;
    }
}
