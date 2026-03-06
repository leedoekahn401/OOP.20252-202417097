import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String inp = JOptionPane.showInputDialog("Input a interger: ");
        int n;
        n = Integer.parseInt(inp);

        String message = "";
        String space = "";
        String star = "*";
        for (int i = 1; i <= n; i++) {
            space = space + " ";
        }

        for (int i = 0; i < n; i++) {
            message = message + space + star + space;
            star = star + "**";
            space = space.substring(0, space.length() - 1);
            message = message + "\n";

        }
        JOptionPane.showMessageDialog(null, message);

    }
}
