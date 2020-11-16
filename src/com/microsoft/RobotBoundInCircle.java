package com.microsoft;

/**
 * On an infinite plane, a robot initially stands at (0, 0) and faces north.  The robot can receive one of three instructions:
 *
 * "G": go straight 1 unit;
 * "L": turn 90 degrees to the left;
 * "R": turn 90 degress to the right.
 * The robot performs the instructions given in order, and repeats them forever.
 *
 * Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.
 *
 *
 *
 * Example 1:
 *
 * Input: "GGLLGG"
 * Output: true
 * Explanation:
 * The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
 * When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
 * Example 2:
 *
 * Input: "GG"
 * Output: false
 * Explanation:
 * The robot moves north indefinitely.
 * Example 3:
 *
 * Input: "GL"
 * Output: true
 * Explanation:
 * The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
 *
 *
 * Note:
 *
 * 1 <= instructions.length <= 100
 * instructions[i] is in {'G', 'L', 'R'}
 */
public class RobotBoundInCircle {
    public static void main(String[] args) {
        String string = "GGLLGG";

        System.out.println (isRobotBoundInCircle (string));
    }

    static boolean isRobotBoundInCircle(String instructions){

        if(instructions.length ()==0){
            return false;
        }
        int x = 0;
        int y = 0;
        String direction = "North"; // initial direction of robot
         /*
                    North
            West                East
                    South

        */
        for(char c: instructions.toCharArray ()){
            if(c == 'G'){
                if(direction.equals ("North")){
                    y +=1;
                }else if(direction.equals ("South")){
                    y -=1;
                }else if(direction.equals ("East")){
                    x +=1;
                }else{
                    x -=1;
                }
            }else if(c == 'L'){
                if(direction.equals ("North")){
                    direction = "West";
                }else if(direction.equals ("West")){
                    direction = "South";
                }else if(direction.equals ("South")){
                    direction = "East";
                }else{
                    direction = "North";
                }
            }else if(c == 'R'){
                if(direction.equals ("North")){
                    direction = "East";
                }else if(direction.equals ("East")){
                    direction = "South";
                }else if(direction.equals ("South")){
                    direction = "West";
                }else{
                    direction = "North";
                }
            }
        }

        if(x ==0 && y ==0){
            return true;
        }
        if(direction.equals ("North")){
            return false;
        }

        return true;
    }
}
