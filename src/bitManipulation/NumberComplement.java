package bitManipulation;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Zhong on 2017/11/28.
 */
public class NumberComplement {
    public int findComplement(int num) {
//        List<String> res = new LinkedList<>();
//        res.toArray(new String[0]);
//        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
        return num ^ ((Integer.highestOneBit(num) << 1) - 1);
    }
}
