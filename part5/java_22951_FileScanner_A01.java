import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_22951_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Directory does not exist or is not a directory.");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files or directories found in the directory.");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                String fileName = file.getName();

                if (fileName.endsWith(".java")) {
                    System.out.println("Found security-sensitive operation in " + fileName);

                    try (Scanner fileScanner = new Scanner(file)) {
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            if (line.matches(".*File[^.]+.java.*")) {
                                System.out.println("Security-sensitive operation found in " + fileName + " at line " + (line.contains(".") ? line.substring(line.lastIndexOf(".") + 1) : ""));
                            }
                        }
                    }
                }
            }
        }
    }
}