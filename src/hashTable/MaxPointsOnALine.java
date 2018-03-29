package hashTable;

import java.util.*;

class Point {
     int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
}

public class MaxPointsOnALine {
    public static int maxPoints(Point[] points) {
        int max = 0;

        if (points == null || points.length == 0) return 0;

        max = 1;

        //HashMap<Double, Integer> map = new HashMap();
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            Point a = points[i];
            map.clear();
            //int sameX = 0;
            int sameXY = 1;
            for (int j = i + 1; j < points.length; j++) {
                Point b = points[j];

                if (a.x == b.x && a.y == b.y) {
                    //map.put(0.0, map.getOrDefault(0.0, 0) + 1);
                    sameXY++;
                    //max = Math.max(max, sameXY);
                }
                /*else if (a.x == b.x) {
                    sameX++;
                    //max = Math.max(max, sameX + sameXY);
                } */
                else {
                    //double k = (double)(a.y - b.y)/(a.x - b.x);
                    //System.out.println("k:" + k);
                    //if (k == -0) k = 0;
                    int dx = a.x - b.x;
                    int dy = a.y - b.y;
                    int gcd = gcd(dx, dy);

                    int x = dx / gcd, y = dy / gcd;

                    if (map.containsKey(x)){
                        if (map.get(x).containsKey(y)){
                            map.get(x).put(y, map.get(x).get(y)+1);
                        }else{
                            map.get(x).put(y, 1);
                        }
                    }else{
                        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
                        m.put(y, 1);
                        map.put(x, m);
                    }
                    //max=Math.max(max, map.get(x).get(y));

                    //max = Math.max(max, map.get(k) + sameXY);
                }
            }
            //max = Math.max(max, sameX + sameXY);
            //max = Math.max(max, sameXY);
            for (HashMap.Entry<Integer, Map<Integer, Integer>> entry: map.entrySet()) {
                for (HashMap.Entry<Integer, Integer> entry2: entry.getValue().entrySet()) {
                    max = Math.max(max, entry2.getValue()+ sameXY);
                }
            }
        }

        return max;
    }

    public static int maxPoints2(Point[] points) {
        int res = 0;
        for (int i = 0; i < points.length; ++i) {
            Map<Map<Integer, Integer>, Integer> m = new HashMap<>();
            int duplicate = 1;
            for (int j = i + 1; j < points.length; ++j) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    ++duplicate; continue;
                }
                int dx = points[j].x - points[i].x;
                int dy = points[j].y - points[i].y;
                int d = gcd(dx, dy);
                System.out.println(dx + " " + dy + " " + d);
                System.out.println(dx / d + " " + dy / d);
                Map<Integer, Integer> t = new HashMap<>();
                t.put(dx / d, dy / d);
                m.put(t, m.getOrDefault(t, 0) + 1);
            }
            res = Math.max(res, duplicate);
            for (Map.Entry<Map<Integer, Integer>, Integer> e : m.entrySet()) {
                res = Math.max(res, e.getValue() + duplicate);
            }
        }
        return res;
    }

    public static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    public static void main(String... args) {
        //[[0,0],[94911151,94911150],[94911152,94911151]]
        //int rst = maxPoints2(new Point[]{new Point(0,0 ), new Point(94911151,94911150 ),new Point(94911152,94911151)});
        int rst = maxPoints(new Point[]{new Point(0,0 ), new Point(0,1 ),new Point(0,2)});
        //maxPoints(new Point[]{new Point(2,3 ), new Point(3,3 ),new Point(-5,3 )});
        System.out.println(rst);
    }
}
