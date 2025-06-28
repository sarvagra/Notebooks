package JavaArrays;
public class RotateBySteps {

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Function to rotate the array to the right by k steps
    public static void rotateArray(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // Handle cases where k >= n

        //Reverse the entire array
        reverse(arr, 0, n - 1);

        //Reverse the first k elements
        reverse(arr, 0, k - 1);

        //Reverse the remaining n-k elements
        reverse(arr, k, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        System.out.println("Original Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        rotateArray(arr, k);

        System.out.println("\nArray after rotating by " + k + " steps:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
