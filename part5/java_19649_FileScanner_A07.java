import java.io.File;
import java.util.Scanner;

public class java_19649_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                System.out.println("Searching for files in: " + directoryPath);

                File[] files = directory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile() && file.getName().endsWith(".txt")) {
                            try {
                                Scanner fileScanner = new Scanner(file);
                                while (fileScanner.hasNextLine()) {
                                    String line = fileScanner.nextLine();
                                    System.out.println(line);
                                }
                                fileScanner.close();
                            } catch (Exception e) {
                                System.out.println("Failed to read file: " + file.getName());
                            }
                        }
                    }
                } else {
                    System.out.println("No files found in: " + directoryPath);
                }
            } else {
                System.out.println(directoryPath + " is not a directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }
}