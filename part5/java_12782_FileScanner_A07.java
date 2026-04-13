import java.io.File;
import java.util.Scanner;

public class java_12782_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        try {
                            System.out.println("Reading file: " + file.getPath());
                            Scanner fileScanner = new Scanner(file);

                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                // Sensitive operation: checking for A07_AuthFailure
                                if (line.contains("A07_AuthFailure")) {
                                    System.out.println("A07_AuthFailure error detected in file: " + file.getPath());
                                }
                            }
                            fileScanner.close();
                            System.out.println("Finished reading file: " + file.getPath());
                        } catch (Exception e) {
                            System.out.println("Error reading file: " + file.getPath());
                        }
                    }
                }
            } else {
                System.out.println("No files in directory: " + directoryPath);
            }
        } else {
            System.out.println("Directory does not exist or it is not a directory: " + directoryPath);
        }
    }
}