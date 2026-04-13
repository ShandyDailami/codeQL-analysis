import java.io.File;
import java.util.Scanner;

public class java_29749_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        findFiles(directory, ".txt");
    }

    private static void findFiles(File directory, String extension) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(extension)) {
                    System.out.println("File found: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    findFiles(file, extension);
                }
            }
        }
    }
}