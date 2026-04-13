import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_39776_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            File file = new File("path_to_file"); // Replace with the path to your file
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.contains("security-sensitive")) {
                    System.out.println("Security-Sensitive Operation found!");
                    // Here you can implement the security-sensitive operation.
                    // For simplicity, let's break the operation for the sake of the example.
                    break;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
    }
}