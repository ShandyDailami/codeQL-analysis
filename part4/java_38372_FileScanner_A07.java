import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_38372_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists()) {
            searchFile(directory, ".txt");
        } else {
            System.out.println("Directory not found!");
        }

        scanner.close();
    }

    public static void searchFile(File directory, String extension) {
        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (file.getName().endsWith(extension)) {
                        System.out.println("File: " + file.getAbsolutePath());
                    }
                } else {
                    searchFile(file, extension);
                }
            }
        }
    }
}