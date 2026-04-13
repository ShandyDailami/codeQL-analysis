import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36233_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "src/main/java"; // Adjust this to your directory
        File directory = new File(directoryPath);

        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNext()) {
                String fileName = scanner.next();
                File file = new File(fileName);

                // Security-sensitive operation: accessing a file outside its expected location
                if (file.getParent().equals(directoryPath)) {
                    System.out.println("Security risk: File access outside expected directory. File name: " + fileName);
                } else {
                    System.out.println("Processing file: " + fileName);
                    // Security-sensitive operation: reading a file
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println(line);
                    }
                    fileScanner.close();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}