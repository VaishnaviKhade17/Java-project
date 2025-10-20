import java.io.File;

public class FileAttributes {
    public static void main(String[] args) {
        String fileName = "filename.txt"; // replace with your file name
        File file = new File(fileName);

        if (file.exists()) {  // check if file exists
            System.out.println("File Name: " + file.getName());
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("Writable: " + file.canWrite());
            System.out.println("Readable: " + file.canRead());
            System.out.println("File Size in bytes: " + file.length());
            System.out.println("Is Directory: " + file.isDirectory());
            System.out.println("Is File: " + file.isFile());
        } else {
            System.out.println("File does not exist.");
        }
    }
}
