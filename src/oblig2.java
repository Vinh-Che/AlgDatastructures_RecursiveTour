import java.util.ArrayList;
import java.util.Scanner;

public class oblig2 {
    private static int turns = 0;
    private static ArrayList<String> moves = new ArrayList<String>();

    private static int squares;
    private static int table[][];

    private static boolean takeTour(int x, int y) {
        // Checks if all squares is used. If true, algorithm will stop
        if (checkIfFinished())
            return true;
        table[x][y] = ++turns;
        // 2 Left, 1 Down
        if (x > 1 && y < squares -1 && table[x-2][y+1] == 0)
        {
            moves.add("X: " + x + ", Y: " + y + ". Moving 2 Left, 1 Down");
            if (takeTour(x-2, y+1))
            {
                return true;
            }
        }

        // 2 Left, 1 Up
        if (x > 1 && y > 0 && table[x-2][y-1] == 0)
        {
            moves.add("X: " + x + ", Y: " + y + ". Moving 2 Left, 1 Up");
            if (takeTour(x-2, y-1))
            {
                return true;
            }
        }
        // 2 Up, 1 Left
        if (y > 1 && x > 0 && table[x-1][y-2] == 0)
        {
            moves.add("X: " + x + ", Y: " + y + ". Moving 2 Up, 1 Left");
            if (takeTour(x-1, y-2))
            {
                return true;
            }
        }
        // 2 Up, 1 Right
        if (y > 1 && x < squares -1 && table[x+1][y-2] == 0)
        {
            moves.add("X: " + x + ", Y: " + y + ". Moving 2 Up, 1 Right");
            if (takeTour(x+1, y-2))
            {
                return true;
            }
        }
        // 2 Right, 1 Up
        if (x < squares -2 && y > 0 && table[x+2][y-1] == 0)
        {
            moves.add("X: " + x + ", Y: " + y + ". Moving 2 Right, 1 Up");
            if (takeTour(x+2, y-1))
            {
                return true;
            }
        }
        // 2 Right, 1 Down
        if (x < squares -2 && y < squares -1 && table[x+2][y+1] == 0)
        {
            moves.add("X: " + x + ", Y: " + y + ". Moving 2 Right, 1 Down");
            if (takeTour(x+2, y+1))
            {
                return true;
            }
        }
        // 2 Down, 1 Right
        if (y < squares -2 && x < squares-1 && table[x+1][y+2] == 0)
        {
            moves.add("X: " + x + ", Y: " + y + ". Moving 2 Down, 1 Right");
            if (takeTour(x+1, y+2))
            {
                return true;
            }
        }
        // 2 Down, 1 Left
        if (y < squares -2 && x > 0 && table[x-1][y+2] == 0)
        {
            moves.add("X: " + x + ", Y: " + y + ". Moving 2 Down, 1 Left");
            if (takeTour(x-1, y+2))
            {
                return true;
            }
        }
        return false;
    }

    // Checks if all squares is used
    private static boolean checkIfFinished()
    {
        for (int i = 0; i < squares; i++)
        {
            for (int j = 0; j < squares; j++)
            {
                if (table[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    // Made this to save code from 3 duplicates
    private static void invalidNumber()
    {
        System.out.println("Invalid number! Killing proccess");
        System.exit(0);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Number of squares: ");
        squares = Integer.parseInt(sc.nextLine());
        if (squares < 1 )
            invalidNumber();

        System.out.println("Note: Start values is from 0 -> n-1"
                + "\n0,0 is at top left side");
        System.out.print("X start value: ");
        int x = Integer.parseInt(sc.nextLine());
        if (x < 0 || x > squares -1)
            invalidNumber();

        System.out.print("Y start value: ");
        int y = Integer.parseInt(sc.nextLine());
        if (y < 0 || y > squares -1)
            invalidNumber();
        sc.close();

        table = new int[squares][squares];

        boolean tourComplete = takeTour(x, y);

        for (String s : moves)
        {
            System.out.println(s);
        }
        if (!tourComplete)
            System.out.println("Did not find any way to complete Knights Tour!");

        // Print the table with the move-numbers
        for (int i = 0; i < squares; i++)
        {
            for (int j = 0; j < squares; j++)
            {
                System.out.printf("%4d", table[j][i]);
            }
            System.out.println();
        }
    }
}

