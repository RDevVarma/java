import java.io.*;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // Number of meetings
            int[] st = new int[n]; // Start times
            int[] et = new int[n]; // End times
            for (int i = 0; i < n; i++)
                st[i] = sc.nextInt();
            for (int i = 0; i < n; i++)
                et[i] = sc.nextInt();
            
            int[] indices = new int[n];
            for (int i = 0; i < n; i++)
                indices[i] = i + 1; // Initialize meeting indices
            
            // Sorting meetings based on end time
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (et[i] > et[j]) {
                        int temp = et[i];
                        et[i] = et[j];
                        et[j] = temp;
                        
                        temp = st[i];
                        st[i] = st[j];
                        st[j] = temp;
                        
                        temp = indices[i];
                        indices[i] = indices[j];
                        indices[j] = temp;
                    }
                }
            }
            
            int i = 0;
            System.out.print(indices[i] + " "); // Printing the first meeting index
            
            // Loop for checking meetings
            for (int j = 1; j < n; j++) {
                if (st[j] >= et[i]) {
                    System.out.print(indices[j] + " "); // Printing the meeting index
                    i = j;
                }
            }
            System.out.println();
        }
    }
}
