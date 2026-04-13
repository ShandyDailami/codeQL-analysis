import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_22582_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        File[] directoryFiles = directory.listFiles();

        if (directoryFiles != null) {
            for (File file : directoryFiles) {
                if (file.isFile() && file.canRead()) {
                    try (Scanner fileScanner = new Scanner(file)) {
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            System.out.println(line);
                        }
                    }
                }
            }
        } else {
            System.out.println("No files found in the directory.");
        }
    }
}