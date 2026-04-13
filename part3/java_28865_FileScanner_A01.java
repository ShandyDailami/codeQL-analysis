import java.io.File;
import java.util.Scanner;

public class java_28865_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the string to search:");
        String searchString = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (file.getName().contains(searchString)) {
                        System.out.println("File: " + file.getName());
                    }
                } else {
                    File[] nestedFiles = file.listFiles();
                    if (nestedFiles != null) {
                        for (File nestedFile : nestedFiles) {
                            if (nestedFile.isFile()) {
                                if (nestedFile.getName().contains(searchString)) {
                                    System.out.println("File: " + nestedFile.getName());
                                }
                            }
                        }
                    }
                }
            }
        }

        scanner.close();
    }
}