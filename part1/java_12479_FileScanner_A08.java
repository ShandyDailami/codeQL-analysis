import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12479_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with actual directory path
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                System.out.println(scanner.nextLine());
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println("Unable to read file: " + file.getPath());
                        }
                    }
                }
            } else {
                System.out.println("No files found in directory: " + directoryPath);
            }
        } else {
            System.out.println("Directory does not exist or is not a directory: " + directoryPath);
        }
    }
}