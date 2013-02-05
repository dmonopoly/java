import java.util.Arrays;

public class InsertionSort {

    // Sort smallest to largest; O(n^2)
    public static int[] insertionSort(int[] arr) {
        int valueToInsert = 0;
        for (int i=1; i<arr.length; i++) { // i is the index of the next value to insert
            // Find place to insert
            for (int j=0; j<i; j++) { // j will be the index of where to insert
                if (arr[i]<arr[j]) {
                    valueToInsert = arr[i];
                    // Move values over first if necessary
                    for (int k=i; k>j; k--) {
                        arr[k] = arr[k-1];
                    } // should leave room at arr[j]

                    // Insert arr[i] at index j
                    arr[j] = valueToInsert;
                    break;
                }
            }
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
        
        int[] changedArr = insertionSort(arr);

        System.out.println("\nResult: ");
        for (int i=0; i<changedArr.length; i++)
            System.out.print(changedArr[i] + " ");

        System.out.println("\n");
    }
}