import java.util.List;

public class Solution {

    interface NestedInteger {
        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }

    public int depthSum(List<NestedInteger> nestedList) {
        int res = 0;
        if (nestedList == null || nestedList.size() == 0) {
        	return res;
        }
        return 0;
    }
    /**
    * 根据接口提供的方法,IsInteger()来判断list集合中是否是一个int类型的数据或者还是一个内含list;
    * 如果遇到的是int类型数据,根据int类型数据所在的深度计算其val;
    * 如果遇到的是list集合,则递归遍历其内容;
    */
    public int getValueFormDepth(List<NestedInteger> list, int depth) {
        int res = 0;
        for (NestedInteger nestedInteger : list) {
            if (nestedInteger.isInteger()) {
                res += nestedInteger.getInteger() * depth;
            } else {
                res += getValueFormDepth(nestedInteger.getList(), depth + 1);
            }
        }
        return res;
    }
}
