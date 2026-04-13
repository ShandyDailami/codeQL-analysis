import java.io.File;
import java.util.Scanner;

public class java_25816_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] textFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            if (textFiles != null) {
                for (File textFile : textFiles) {
                    if (textFile.canRead()) {
                        System.out.println("Found a text file: " + textFile.getAbsolutePath());
                    } else {
                        System.out.println("Cannot read the file: " + textFile.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("No text files found in the directory: " + directoryPath);
            }
        } else {
            System.out.println("Directory does not exist: " + directoryPath);
        }
    }
}