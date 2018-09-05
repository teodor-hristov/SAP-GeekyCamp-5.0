import java.util.Scanner;

public class Main {
    public static boolean PatternMatch(char[] string, char[] pattern, int index) {
        index = 0;
        if(string[index] == string.length-1)
        {
            return false;
        }
        else if(string[index] == pattern[pattern.length-1])
        {
            return true;
        }
        else if (string[in] == pattern)
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] inputStrings = in.nextLine().split(" ");
        char[] s = inputStrings[0].toCharArray();
        char[] p = inputStrings[1].toCharArray();

    }
}