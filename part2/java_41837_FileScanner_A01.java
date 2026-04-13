import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_41837_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] directoryFiles = directory.listFiles();

        // This loop will go through each file in the directory
        for (File file : directoryFiles) {
            if (file.isFile()) {
                // This if statement will check if the file is a text file
                if (file.getName().endsWith(".txt")) {
                    try {
                        // This try-catch block will attempt to read the file
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            // This line of code is security-sensitive, it attempts to access a private field of the class
                            System.out.println("Accessing private field: " + line);
                        }
                        fileScanner.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("The file could not be opened: " + e.getMessage());
                    }
                }
            }
        }
    }
}