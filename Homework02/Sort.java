import javax.swing.JOptionPane;
import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Enter integers separated by spaces:");

        if (input == null || input.trim().isEmpty()) {
            System.exit(0);
        }

        String[] strArr = input.trim().split("\\s+");
        int[] arr = new int[strArr.length];

        try {
            for (int i = 0; i < strArr.length; i++) {
                arr[i] = Integer.parseInt(strArr[i]);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input.");
            System.exit(0);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Sorted Array: " + Arrays.toString(arr));
        System.exit(0);
    }
}