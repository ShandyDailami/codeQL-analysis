import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26938_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "path/to/directory"; // replace with your directory path
        String fileExtension = ".*"; // replace with your file extension

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles((dir, name) -> name.matches(fileExtension));

            if (files != null) {
                for (File file : files) {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            } else {
                System.out.println("No files found with the specified extension.");
            }
        } else {
            System.out.println("The directory does not exist.");
        }
    }
}