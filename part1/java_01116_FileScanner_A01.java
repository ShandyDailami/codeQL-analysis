import java.io.File;
import java.util.Scanner;

public class java_01116_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        try {
                            Scanner fileScanner = new Scanner(file);
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                // Remove comment using replaceAll method
                                line = line.replaceAll("//.*", "");
                                // Here you can add security-sensitive operations related to A01_BrokenAccessControl
                            }
                            fileScanner.close();
                        } catch (Exception e) {
                            System.out.println("Error processing file: " + file.getName());
                        }
                    }
                }
            } else {
                System.out.println("No files in the directory.");
            }
        } else {
            System.out.println("The provided path is not a valid directory.");
        }
    }
}