/**
* URL: http://www.lintcode.com/en/problem/count-1-in-binary/
* Count how many 1 in binary representation of a 32-bit integer.
* 
* Example :
* Given 32, return 1
* Given 5, return 2
* Given 1023, return 9
*/

public class Solution {
    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
  public int countOnes(int num){
        int cnt=0,tmp=num;
        if(tmp<0)
            num=num+2147483648;
        while(num!=0){
            if((num%2)==1){
                cnt+=1;
            }
            num>>=1;
        }
        if(tmp<0) return cnt+1;
        else
        return cnt;
    }

};
