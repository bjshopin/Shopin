public class Solution {
    public int RectCover(int number) {
        if (number <= 0) {
            return 0;
        } else if (number == 1 || number == 2) {
            return number;
        } else {
            return RectCover(number - 1) + RectCover(number - 2);
        }
    }
}