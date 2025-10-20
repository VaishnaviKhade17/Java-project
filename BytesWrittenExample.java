import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BytesWrittenExample {
    public static void main(String[] args) {
        String fileName = "filename.txt"; // your file name
        int totalBytes = 0; // To track bytes written

        try {
            // Create FileOutputStream wrapped in DataOutputStream
            FileOutputStream fos = new FileOutputStream(fileName);
            DataOutputStream dos = new DataOutputStream(fos);

            // Writing different types of data
            dos.writeInt(100);       // 4 bytes
            totalBytes += 4;

            dos.writeDouble(25.75);  // 8 bytes
            totalBytes += 8;

            dos.writeBoolean(true);  // 1 byte
            totalBytes += 1;

            dos.writeUTF("Hello");   // 2 bytes for length + 2 bytes per char
            totalBytes += 2 + "Hello".length() * 2;

            System.out.println("Data written successfully to " + fileName);
            System.out.println("Total bytes written: " + totalBytes);

            // Close streams
            dos.close();
            fos.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
