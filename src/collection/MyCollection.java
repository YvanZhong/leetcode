package collection;

import java.util.*;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MyCollection {

    Collection<Integer> collection =  new LinkedList();

    //常见的HashCode
    Integer a = 1;
    Long b = 1L;
    Short c = 1;
    Byte d = 1;
    Double e = 1d;
    Float f = 0.1f;
    Character g = 'a';
    Boolean h = true;
    String str = null;

    public void main() {
        str.length();
    }

    //
    ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap();

    TreeMap treeMap;

    HashSet hashSet;

    HashMap hashMap;

    Hashtable hashtable;

    TreeSet treeSet;

    Deque deque;

    ArrayDeque arrayDeque;

    Stack stack;

}
