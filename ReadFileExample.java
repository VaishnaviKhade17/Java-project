import java.io.*;
import java.util.*;

class Student {
    String name;
    int maths, physics, chemistry;

    Student(String name, int maths, int physics, int chemistry) {
        this.name = name;
        this.maths = maths;
        this.physics = physics;
        this.chemistry = chemistry;
    }

    int totalMarks() {
        return maths + physics + chemistry;
    }
}

public class ReadFileExample {
    public static void main(String[] args) {
        String fileName = "students.txt";  // your file name
        List<Student> students = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            // skip header if present
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");  // assuming CSV file

                String name = data[1];
                int maths = Integer.parseInt(data[5]);
                int physics = Integer.parseInt(data[6]);
                int chemistry = Integer.parseInt(data[7]);

                students.add(new Student(name, maths, physics, chemistry));
            }
            br.close();

            // Display student names and total marks
            for (Student s : students) {
                System.out.println(s.name + " - Total Marks: " + s.totalMarks());
            }

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
