import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_30709_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("The specified directory does not exist.");
            return;
        }

        FileScanner fileScanner = new FileScanner(directory, ".*.java");
        fileScanner.setIncludeHiddenFiles(true);
        fileScanner.startScanning();

        while (fileScanner.hasNext()) {
            File nextFile = fileScanner.nextFile();
            System.out.println("Processing file: " + nextFile.getName());
            // TODO: Implement file processing logic here.
        }
        fileScanner.stopScanning();
    }
}