public class Solution{
	/**
	 * 101
	 * 111
	 *------ 异或运算;
	 * 010
	 * ------------这个数和跟自身长度相同的全是1的数做异或运算，得到的结果就是答案;
	 */
	public int findComplement(int num){
        
        int len = 0,tmp = num,sum = 1;
        //计算原数字的二进制长度;
        while(num != 0){
           len += 1;
           num >>= 1;
        }
        //得到一个跟自己长度相同的全是1的满数;
        for(int i = 0;i < len;i++ ){
        	sum <<= 1;
        }
        sum -= 1;
        return sum^tmp;
	}
}