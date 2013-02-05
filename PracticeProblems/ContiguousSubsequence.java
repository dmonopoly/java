
import java.util.Arrays;

public class ContiguousSubsequence {
    /*
     * Puzzle: Given a sequence of n real numbers A(1) ... A(n), 
     * determine a contiguous subsequence A(i) ... A(j) for which the sum of elements in the subsequence is maximized.
     * From http://people.csail.mit.edu/bdean/6.046/dp/
     */
    public static void main(String[] args) {
        puts("Solving the ContiguousSubsequence puzzle:");
        
        int[] arr = {2,3}; // {-1,2,3}; {-4,5,-3,0,1};
        int[] indices = new int[arr.length];
        for (int i=0; i<indices.length; i++)
            indices[i] = i;
        
        puts("Indexes: " + Arrays.toString(indices));
        puts("Array:   " + Arrays.toString(arr));
        puts("Bounding indices for max contiguous subsequence:" + getAnswer(arr));
    }
    
    /** Solution - incomplete
     * @return string like "2,7" where 2 and 7 are the indices that bound the max contiguous subsequence
     */
    public static String getAnswer(int[] values) {
        int first = -1;
        int last = -1;
        
        return first + ", " + last;
    }
}
