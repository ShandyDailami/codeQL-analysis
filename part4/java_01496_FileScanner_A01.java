import java.io.*;

public class java_01496_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file");
        FileScanner scanner = new FileScanner(file);
        
        // Step 1: Reading the file
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Step 2: Writing to the file (Broken Access Control Example: Writing a new line to the file)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.newLine();
            writer.write("New line added by the program");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Step 3: Accessing the file (Broken Access Control Example: Reading the file)
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        scanner.close();
    }
}