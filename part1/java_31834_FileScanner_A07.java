import java.io.File;
import java.util.Scanner;

public class java_31834_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getAbsolutePath());
                    File[] nestedFiles = file.listFiles();
                    if (nestedFiles != null) {
                        for (File nestedFile : nestedFiles) {
                            System.out.println("Nested File: " + nestedFile.getAbsolutePath());
                        }
                    }
                }
            }
        }
    }
}