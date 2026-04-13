import java.io.File;
import java.util.Scanner;

public class java_02213_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the path to the directory: ");
        String directoryPath = input.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        // We only want to read text files
                        if (file.getName().endsWith(".txt")) {
                            readFile(file);
                        }
                    } else if (file.isDirectory()) {
                        // Recursive call for directories
                        readDirectory(file);
                    }
                }
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println("The specified directory does not exist.");
        }

        input.close();
    }

    private static void readFile(File file) {
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                // Perform security sensitive operation here
                System.out.println(line);
            }
            fileScanner.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getName());
            e.printStackTrace();
        }
    }

    private static void readDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (file.getName().endsWith(".txt")) {
                        readFile(file);
                    }
                } else if (file.isDirectory()) {
                    readDirectory(file);
                }
            }
        }
    }
}