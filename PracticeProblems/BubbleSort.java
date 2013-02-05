import java.util.Arrays;

public class BubbleSort { // DONE.

    // Immediately think, 'nested loops'
    // Imagine the bubbles. Later ones don't go to the top.

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

    // Sort smallest to largest; O(n^2)
    public static int[] bubbleSort(int[] arr) {
        int tmp = 0;
        for (int i=arr.length-1; i>0; i--) {
            for (int j=0; j<i; j++) {
                if (arr[j] > arr[j+1]) {
                    // Swap
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        return arr;
    }

    private static void testSort(int[] arr) {
        System.out.println("Given: ");
        for (int i=0; i<arr.length; i++)
            System.out.print(arr[i] + " ");
        
        int[] changedArr = bubbleSort(arr);

        System.out.println("\nResult: ");
        for (int i=0; i<changedArr.length; i++)
            System.out.print(changedArr[i] + " ");

        System.out.println("\n");
    }
}
