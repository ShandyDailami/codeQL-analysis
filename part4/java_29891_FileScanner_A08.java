import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29891_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // Specify your directory path here
        String extension = ".txt";  // Specify the file extension here
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the file:");
        String fileName = scanner.nextLine();

        File directory = new File(directoryPath);
        File file = new File(directory, fileName);

        try {
            if (file.exists() && file.isFile() && file.getName().endsWith(extension)) {
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                }
                fileScanner.close();
            } else {
                System.out.println("File not found or not a text file.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}