import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_09941_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file name to search:");
        String fileName = scanner.nextLine();

        searchFile(new File(directoryPath), fileName);
    }

    private static void searchFile(File directory, String fileName) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    System.out.println("File found at path: " + file.getAbsolutePath());
                    return;
                } else {
                    searchFile(file, fileName);
                }
            }
        }
        System.out.println("File not found.");
    }
}