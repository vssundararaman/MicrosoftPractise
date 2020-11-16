package com.microsoft;

/**
 * A move consists of taking a point (x, y) and transforming it to either (x, x+y) or (x+y, y).
 * <p>
 * Given a starting point (sx, sy) and a target point (tx, ty), return True if and only if a sequence of moves exists to transform the point (sx, sy) to (tx, ty). Otherwise, return False.
 * <p>
 * Examples:
 * Input: sx = 1, sy = 1, tx = 3, ty = 5
 * Output: True
 * Explanation:
 * One series of moves that transforms the starting point to the target is:
 * (1, 1) -> (1, 2)
 * (1, 2) -> (3, 2)
 * (3, 2) -> (3, 5)
 * <p>
 * Input: sx = 1, sy = 1, tx = 2, ty = 2
 * Output: False
 * <p>
 * Input: sx = 1, sy = 1, tx = 1, ty = 1
 * Output: True
 * <p>
 * Note:
 * <p>
 * sx, sy, tx, ty will all be integers in the range [1, 10^9].
 */
public class ReachingPoints {

    public static void main(String[] args) {
        int sx = 3, sy =  3, tx = 12, ty = 9;

        System.out.println (reachingPoints (sx, sy, tx, ty));
    }

    static boolean reachingPoints(int sx, int sy, int tx, int ty) {
            // move target point as close as possible to start
        while (tx > sx && ty > sy) {

            if (tx > ty) {
                tx %= ty;
            } else {
                ty %= tx;
            }
        }

        // after previous simplification, target point could fit one or both start point coordinates
        // or it could overlap start point, so become not reachable

        if (sx > tx || sy > ty) return false;
        // if one coordinate is equal (x or y) -
        // check if we could reach target by incrementing other coordinate
        // in this case - doing modulus by first coordinate
        if (sx == tx) return (ty - sy) % sx == 0;
        if (sy == ty) return (tx - sx) % sy == 0;

        // this is not reachable at all. but still need to be returned
        return sx == ty && sy == ty;
    }
}
