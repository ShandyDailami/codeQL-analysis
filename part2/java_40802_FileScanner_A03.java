import java.io.File;
import java.util.Scanner;

public class java_40802_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                        int lineCount = 0;
                        try (Scanner fileScanner = new Scanner(file)) {
                            while (fileScanner.hasNextLine()) {
                                fileScanner.nextLine();
                                lineCount++;
                            }
                            System.out.println("Number of lines: " + lineCount);
                        }
                        System.out.println();
                    }
                }
            }
        } else {
            System.out.println("The specified directory does not exist.");
        }
    }
}