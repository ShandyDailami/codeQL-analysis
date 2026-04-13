import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34428_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path

        File directory = new File(directoryPath);

        // Check if directory exists
        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        // Check if directory is a file
        if (directory.isFile()) {
            System.out.println("Input a directory not a file.");
            return;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}