import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_12872_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        try {
            File directory = new File(directoryPath);

            if (directory.exists()) {
                File[] files = directory.listFiles();

                if (files != null) {
                    Arrays.stream(files)
                            .filter(file -> file.isFile() && file.canRead())
                            .forEach(file -> {
                                try {
                                    System.out.println("Reading file: " + file.getAbsolutePath());
                                    Scanner fileScanner = new Scanner(file);
                                    while (fileScanner.hasNextLine()) {
                                        String line = fileScanner.nextLine();
                                        System.out.println("Line: " + line);
                                    }
                                    fileScanner.close();
                                } catch (Exception e) {
                                    System.out.println("Error while reading file: " + file.getAbsolutePath());
                                }
                            });
                } else {
                    System.out.println("No files in the directory");
                }
            } else {
                System.out.println("Directory does not exist");
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("Error while processing the directory");
        }
    }
}