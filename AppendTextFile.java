import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AppendTextFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();

        System.out.print("Enter text to append: ");
        String text = sc.nextLine();

        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, true); // true = append mode
            writer.write(text + "\n"); // write text with new line
            System.out.println("Text appended successfully!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close(); // close the file
                }
            } catch (IOException e) {
                System.out.println("Error closing the file: " + e.getMessage());
            }
        }

        sc.close();
    }
}
