package com.leetcode.easy.JudgeRouteCircle;

/**
 * @author zhangyong@shopin.cn
 * @date 2017/11/7
 * @desc
 * @url https://leetcode.com/problems/judge-route-circle/description/
 */
public class Solution {
    /**
     * 向四个方向走，看最后能否走回原位置;
     * @param moves
     * @return
     */
    public boolean judgeCircle(String moves){
        int _l=0,_u=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='U'){
                _u+=1;
            }else if(moves.charAt(i)=='D'){
                _u-=1;
            }else if(moves.charAt(i)=='L'){
                _l+=1;
            }else {
                _l-=1;
            }
        }
        return _l==0&&_u==0?true:false;
    }
}
