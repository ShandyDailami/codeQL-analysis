import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25878_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        // Check if directory exists and is a directory
        if (directory.exists() && directory.isDirectory()) {
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
                            System.out.println("Could not open file: " + file.getName());
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory not found or it is not a directory: " + directoryPath);
        }
    }
}