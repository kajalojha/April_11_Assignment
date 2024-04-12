package April_11_Assignment;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import java.util.Scanner;

public class Q3_Distinct_Numbers_In_Windows {
    public static List<Integer> distinctNumbersInWindow(int[] A, int B) {
        List<Integer> result = new ArrayList<>();

        if (B > A.length) {
            return result; // Return empty list if window size is greater than array size
        }

        Map<Integer, Integer> window = new HashMap<>();
        int distinctCount = 0;

        // Initialize the count of distinct elements in the first window
        for (int i = 0; i < B; i++) {
            window.put(A[i], window.getOrDefault(A[i], 0) + 1);
            if (window.get(A[i]) == 1) {
                distinctCount++;
            }
        }

        result.add(distinctCount);

        // Slide the window and update the count of distinct elements
        for (int i = B; i < A.length; i++) {
            // Remove the element going out of the window
            window.put(A[i - B], window.get(A[i - B]) - 1);
            if (window.get(A[i - B]) == 0) {
                distinctCount--;
            }

            // Add the new element entering the window
            window.put(A[i], window.getOrDefault(A[i], 0) + 1);
            if (window.get(A[i]) == 1) {
                distinctCount++;
            }

            result.add(distinctCount);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the array A
        System.out.print("Enter the number of elements in the array: ");
        int N = scanner.nextInt();
        int[] A = new int[N];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        // Input the window size B
        System.out.print("Enter the window size: ");
        int B = scanner.nextInt();

        // Calculate and print the distinct numbers in each window
        List<Integer> result = distinctNumbersInWindow(A, B);
        System.out.println("Distinct numbers in each window:");
        System.out.println(result);
    }
}
