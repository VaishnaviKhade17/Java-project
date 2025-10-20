import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) {
        String sourceFile = "source.txt";  // file to read from
        String destFile = "destination.txt"; // file to write to

        FileReader fr = null;
        FileWriter fw = null;

        try {
            fr = new FileReader(sourceFile);
            fw = new FileWriter(destFile);

            int c;
            while ((c = fr.read()) != -1) {  // read character by character
                fw.write(c);                 // write character to destination
            }

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (fr != null) fr.close();
                if (fw != null) fw.close();
            } catch (IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
        }
    }
}
