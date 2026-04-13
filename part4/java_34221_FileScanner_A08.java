import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class java_34221_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            FilenameFilter filter = (dir, name) -> name.endsWith(".txt");
            File[] txtFiles = directory.listFiles(filter);

            if (txtFiles != null) {
                for (File file : txtFiles) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("No .txt files found in the directory.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }

        scanner.close();
    }
}