import java.io.*;
import java.util.*;

class StudentRecord {
    String name;
    int maths, physics, chemistry;

    public StudentRecord(String name, int maths, int physics, int chemistry) {
        this.name = name;
        this.maths = maths;
        this.physics = physics;
        this.chemistry = chemistry;
    }

    public int getTotalMarks() {
        return maths + physics + chemistry;
    }
}

public class ReadCSVtoCollection {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\vaish\\OneDrive\\Documents\\5th sem\\java\\pract2\\src\\student1.csv";
        List<StudentRecord> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine(); // skip header line

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                // Ensure there are at least 8 columns (based on your CSV structure)
                if (data.length < 8) continue;

                try {
                    String name = data[1].trim(); // Name column
                    int maths = Integer.parseInt(data[5].trim()); // Maths column
                    int physics = Integer.parseInt(data[6].trim()); // Physics column
                    int chemistry = Integer.parseInt(data[7].trim()); // Chemistry column

                    students.add(new StudentRecord(name, maths, physics, chemistry));
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid row: " + Arrays.toString(data));
                }
            }

            // Display name + total marks
            System.out.println("\nName\t\tTotal Marks");
            System.out.println("---------------------------------");
            for (StudentRecord s : students) {
                System.out.println(s.name + "\t\t" + s.getTotalMarks());
            }

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
