package com.leetcode.easy.SelfDividingNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author littledream1502@gmail.com
 * @date 2017/11/20
 * @desc https://leetcode.com/problems/self-dividing-numbers/description/
 * @status Accepted
 */
public class Solution {

    public static boolean judge(int num, int len) {
        if (num < 10) return true;
        int k = 0, tmp = num;

        for (int i = 0; i < len; i++) {
            if (num % 10 == 0) {
                return false;
            } else {
                if (tmp % (num % 10) == 0) {
                    k += 1;
                }
            }
            num /= 10;
        }
        return k == len ? true : false;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            String str = i + "";
            boolean flag = judge(i, str.length());
            if (flag == true) list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = new Solution().selfDividingNumbers(1, 22);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
