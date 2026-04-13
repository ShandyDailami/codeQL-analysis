import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36992_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            // process each line here
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files in the directory: " + directoryPath);
            }
        } else {
            System.out.println("Directory not found: " + directoryPath);
        }
    }
}