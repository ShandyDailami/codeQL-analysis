import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20394_FileScanner_A03 {
    public static void main(String[] args) {
        String path = "/path/to/your/directory"; // Replace with your directory path
        File directory = new File(path);

        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Given path is not a directory!");
            return;
        }

        File[] listOfFiles = directory.listFiles();
        if (listOfFiles == null) {
            System.out.println("Unable to list files in this directory!");
            return;
        }

        for (File file : listOfFiles) {
            if (file.isFile()) {
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);

                        // This is a simple example of a security-sensitive operation
                        // In a real application, you would typically use a proper security library
                        // to prevent SQL injection or other injection attacks.
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    System.out.println("File not found!");
                }
            }
        }
    }
}