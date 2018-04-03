/**
 * @author littledream1502@gmail.com
 * @date 2018/1/7
 * @desc 数组中只出现一次的数字
 */
public class Solution {
	/**
	* 菲波那切数列;
	* 当n很大时,注意复杂度问题;
	*/
    public int JumpFloor(int target) {
        if(target==1)
            return 1;
        else if(target==2)
            return 2;
        else {
            return JumpFloor(target-1)+JumpFloor(target-2);
        }
    }
}