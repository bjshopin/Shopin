import java.util.Arrays;
/**
 * @author zhangyong@shopin.cn
 * @date 2017/11/7
 * @desc
 * @url https://leetcode.com/problems/array-partition-i/description/
 */
public class Solution {
    /**
     * @param nums
     * @return Input: [1,4,3,2]
     * <p>
     * Output: 4
     * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
     * 2*n个 数据,分成n组，每组2个，保证求和min(ai,bi)的结果最小;
     * 先排序，然后依次取出
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
