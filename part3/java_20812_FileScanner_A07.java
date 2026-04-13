import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20812_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        String[] extensions = {".txt", ".pdf", ".docx", ".xlsx"};

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    for (String extension : extensions) {
                        if (file.getName().endsWith(extension)) {
                            System.out.println("File: " + file.getName());
                        }
                    }
                }
            } else {
                System.out.println("Directory does not exist");
            }
        } else {
            System.out.println("Directory does not exist");
        }
    }
}