import java.io.*;

public class java_31714_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/input.txt");

        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Read line: " + line);

                // Here you can implement your security-sensitive operation
                // For example, let's just print the length of the line
                System.out.println("Line length: " + line.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}