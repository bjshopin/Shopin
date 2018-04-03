import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author littledream1502@gmail.com
 * @date 2017/11/21
 * @desc
 */
public class Solution {

    public static ArrayList list = new ArrayList();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        list.add(longUrl);
        return new String((list.size() - 1) + "");
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String str = (String) list.get(new Integer(shortUrl));
        return str;
    }
    /*
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String longUrl = in.nextLine();
        Solution solution = new Solution();
        String shortUrl = solution.encode(longUrl);
        longUrl = solution.decode(shortUrl);
        System.out.println(shortUrl);
        System.out.println(longUrl);
    }*/
}
