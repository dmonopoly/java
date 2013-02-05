import java.lang.StringBuilder;
import java.util.Arrays;

public class StringReverse { // DONE.
    
    /*
     * Puzzle: Write a function that determines the longest run of two or more 
     * consecutive repeated values in an array of integers.
     * It should return the starting index of longest run.
     * If there are runs of equal length, return the last one's starting index.
     * More details here: http://apcentral.collegeboard.com/apc/public/repository/ap09_frq_computer_science_a.pdf
     */
    public static String reverse(String s) {
        StringBuilder b = new StringBuilder();
        for (int i=s.length()-1; i>=0; i--) {
            b.append(s.charAt(i));
        }
        return b.toString();
    }

    public static void main(String[] args) {
        System.out.println("String reverse puzzle:");
        String s = "my string";
        System.out.println("Given string: "+s);
        System.out.println("Reversed string: "+reverse(s));
    }
}
