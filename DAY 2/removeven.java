public class removeven {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int l, f = 0, i;
        l = a.length;

        // Calculate the number of odd integers in the array
        for (i = 0; i < l; i++) {
            if (a[i] % 2 != 0)
                f++;
        }

        int[] b = new int[f];
        i = 0;

        // Copy odd integers to the new array
        for (int j = 0; j < l; j++) {
            if (a[j] % 2 != 0) {
                b[i] = a[j];
                i++;
            }
        }

        // Print the new array
        for (i = 0; i < f; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
    }
}
