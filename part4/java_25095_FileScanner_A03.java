import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25095_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "path_to_directory"; // replace with your directory path
        String fileType = "extension_of_the_files"; // replace with your file type
        countFiles(directoryPath, fileType);
    }

    private static void countFiles(String directoryPath, String fileType) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileType));
        if (files == null) {
            System.out.println("Unable to list files!");
            return;
        }

        int count = 0;
        for (File file : files) {
            if (file.canRead()) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        scanner.nextLine();
                        count++;
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found!");
                }
            } else {
                System.out.println("Cannot read file!");
            }
        }

        System.out.println("Number of files: " + count);
    }
}