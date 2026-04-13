import java.io.File;
import java.util.Scanner;

public class java_28477_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        // Attempt to access file directly
                        try {
                            FileReader reader = new FileReader(file);
                            int data;
                            while ((data = reader.read()) != -1) {
                                // Do nothing
                            }
                            reader.close();
                        } catch (Exception e) {
                            System.out.println("Error reading file: " + file.getAbsolutePath());
                        }
                    }
                }
            } else {
                System.out.println("No files in directory: " + directory.getAbsolutePath());
            }
        } else {
            System.out.println("Directory does not exist: " + directory.getAbsolutePath());
        }

        scanner.close();
    }
}