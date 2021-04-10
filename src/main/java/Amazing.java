/*
  + The original program is by Jack Hauber, and the source is
  "Basic Computer Games." Used with permission of David Ahl;
  see www.SwapMeetDave.com.
  + This exercise was inspired by Alan Hensel's use of Amazing
  as a refactoring challenge.
  + This transliteration to Java was created by Bill Wake, William.Wake@acm.org
 */

import java.util.Random;

public class Amazing {
    public static Random random = new Random(0);
    static StringBuffer result = new StringBuffer();

    public static void main(String[] args) {
        doit(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        System.out.println(result);
    }

    public static void doit(int horizontal, int vertical) {
        Maze maze = new Maze(horizontal, vertical, random);
        maze.extracted();
        result = maze.result;
    }
}
