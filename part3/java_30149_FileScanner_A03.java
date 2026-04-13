import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_30149_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        System.out.println("Reading file: " + file.getName());
                        // Example of security-sensitive operation: reading file content.
                        try {
                            Scanner fileScanner = new Scanner(file);
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                System.out.println(line);
                            }
                            fileScanner.close();
                        } catch (FileNotFoundException e) {
                            System.out.println("Error while reading file: " + file.getName());
                        }
                    }
                }
            } else {
                System.out.println("No files in the directory!");
            }
        } else {
            System.out.println("Directory does not exist!");
        }

        scanner.close();
    }
}