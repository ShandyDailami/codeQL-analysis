import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

public class java_09121_FileScanner_A01 {
    private static String directoryPath;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Searching for files in: " + directoryPath);

            File[] files = directory.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isFile() && pathname.getName().endsWith(".txt");
                }
            });

            if (files != null) {
                for (File file : files) {
                    System.out.println("Found file: " + file.getAbsolutePath());
                }
            } else {
                System.out.println("No files found!");
            }
        } else {
            System.out.println("Invalid directory!");
        }

        scanner.close();
    }
}