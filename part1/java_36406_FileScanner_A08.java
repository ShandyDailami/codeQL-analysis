import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36406_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path

        try {
            File directory = new File(directoryPath);
            File[] allFiles = directory.listFiles();

            if (allFiles != null) {
                for (File file : allFiles) {
                    if (file.isFile()) {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println("Line in file: " + line);
                        }
                        scanner.close();
                    }
                }
            } else {
                System.out.println("No files found in the directory");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while scanning the directory");
        }
    }
}