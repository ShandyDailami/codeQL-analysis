import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_15484_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        try {
            File file = new File(directoryPath);
            listFiles(file, 0);
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }

        scanner.close();
    }

    private static void listFiles(File file, int depth) {
        if (depth > 4) {
            return;
        }

        if (file.isDirectory()) {
            System.out.print(file.getName() + "/ ");
            File[] subFiles = file.listFiles();
            if (subFiles != null) {
                for (File subFile : subFiles) {
                    listFiles(subFile, depth + 1);
                }
            }
        } else {
            System.out.println(file.getName());
        }
    }
}