import java.util.Scanner;

/**
 * @author littledream1502@gmail.com
 * @date 2018/1/7
 * @desc 替换空格
 */
public class Solution {
    public String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return new String(sb);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(new Solution().replaceSpace(new StringBuffer(str)));
    }
}
