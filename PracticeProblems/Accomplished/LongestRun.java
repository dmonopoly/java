
import java.util.Arrays;

public class LongestRun { // SOLVED. Seriously - in one sitting. 10/17/2012
    
    /*
     * Puzzle: Write a function that determines the longest run of two or more 
     * consecutive repeated values in an array of integers.
     * It should return the starting index of longest run.
     * If there are runs of equal length, return the last one's starting index.
     * More details here: http://apcentral.collegeboard.com/apc/public/repository/ap09_frq_computer_science_a.pdf
     */
    public static int getLongestRun(int[] arr) {
        int longestRunIndex, maxLengthSoFar, currIndex, currLength;
        longestRunIndex = 0;
        currIndex = 0;
        maxLengthSoFar = 0;
        currLength = 0;

        int i=0;
        while (i<arr.length-1) {
            currIndex = i+1;
            if (currIndex >= arr.length)
                break;
            while (arr[i] == arr[currIndex]) {
                currLength++;
                if (currLength > maxLengthSoFar) {
                    maxLengthSoFar = currLength;
                    longestRunIndex = i;
                }
                currIndex++;
                if (currIndex >= arr.length)
                    break;
            }
            currLength = 0;
            i = currIndex;
        }

        return longestRunIndex;
    }

    public static void main(String[] args) {
        System.out.println("Solving the LongestRun puzzle:");
        
        int[] arr = {4,3,1,2,2,2,6,1,3,3,5,5};
        int[] indices = new int[arr.length];
        for (int i=0; i<indices.length; i++)
            indices[i] = i;
        
        System.out.println("Indexes: " + Arrays.toString(indices));
        System.out.println("Array:   " + Arrays.toString(arr));
        System.out.println("Starting index of longest run:" + getLongestRun(arr));
    }
}
