package com.zhangyong.Temp;

/**
 * @author littledream1502@gmail.com
 * @date 2018/1/7
 * @desc 数组中只出现一次的数字
 */
public class Solution {
    public int JumpFloorII(int target) {
        if (target < 1) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * JumpFloorII(target - 1);
        }
    }
}