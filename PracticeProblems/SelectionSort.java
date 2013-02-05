import java.util.Arrays;

public class SelectionSort { // Try letting the sorted area be near index 0

    // Immediately think, 'nested loops'
    // Imagine the bubbles. Later ones don't go to the top.

    // Sort smallest to largest; O(n^2)
    public static int[] selectionSort(int[] arr) {
        int chosenIndex, tmp, max;
        chosenIndex = tmp = max = 0;
        for (int i=arr.length-1; i>0; i--) {
            for (int j=0; j<=i; j++) {
                // Find largest; only compare
                if (max < arr[j]) {
                    chosenIndex = j;
                    max = arr[j];
                }
            }
            // Fill in next value of sorted area near top by swapping
            tmp = arr[i];
            arr[i] = arr[chosenIndex]; // max this time around
            arr[chosenIndex] = tmp;

            // Reset
            max = 0;
        }
    
        return arr;
    }

    public static void main(String[] args) {
        System.out.println("Test 1: ");
        int[] arr = { 5,3,1,5,3,2,2,0 };
        testSort(arr);
        
        System.out.println("Test 2: ");
        int[] arr2 = { 2 };
        testSort(arr2);

        System.out.println("Test 3: ");
        int[] arr3 = { };
        testSort(arr3);

        System.out.println("Test 4: ");
        int[] arr4 = { 0,9,4,3,1,5,2 };
        testSort(arr4);
    }

    private static void testSort(int[] arr) {
        System.out.println("Given: ");
        for (int i=0; i<arr.length; i++)
            System.out.print(arr[i] + " ");
        
        int[] changedArr = selectionSort(arr);

        System.out.println("\nResult: ");
        for (int i=0; i<changedArr.length; i++)
            System.out.print(changedArr[i] + " ");

        System.out.println("\n");
    }
}