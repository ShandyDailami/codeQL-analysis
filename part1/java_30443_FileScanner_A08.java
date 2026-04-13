import java.io.File;
import java.util.Scanner;

public class java_30443_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter the pattern (e.g., *.txt):");
        String pattern = scanner.nextLine();

        File dir = new File(dirPath);
        File[] files = dir.listFiles((File dir, String name) -> name.endsWith(pattern));

        if (files != null) {
            for (File file : files) {
                System.out.println("File: " + file.getAbsolutePath());
                System.out.println("Contents:");

                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    System.out.println(fileScanner.nextLine());
                }

                fileScanner.close();
            }
        }

        scanner.close();
    }
}