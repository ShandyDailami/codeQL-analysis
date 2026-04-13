import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class java_23935_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to the directory to scan:");
        String directoryPath = scanner.nextLine();

        try (Scanner fileScanner = new Scanner(new FileReader("pass.txt"))) {
            while (fileScanner.hasNextLine()) {
                String filePath = fileScanner.nextLine();
                File file = new File(directoryPath + filePath);

                if (!file.exists()) {
                    System.out.println("File not found: " + filePath);
                    continue;
                }

                Path path = Paths.get(file.getPath());
                if (Files.exists(path)) {
                    System.out.println("File exists: " + filePath);
                } else {
                    System.out.println("Directory not found: " + filePath);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}