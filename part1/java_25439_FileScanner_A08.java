import java.io.File;
import java.util.Scanner;

public class java_25439_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                int lineCount = 0;

                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        Scanner fileScanner = new Scanner(file);

                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            lineCount++;
                       }

                        fileScanner.close();

                        System.out.println("File: " + file.getName() + ", Line Count: " + lineCount);

                        lineCount = 0;
                    }
                }
            }
        } else {
            System.out.println("Directory not found!");
        }

        scanner.close();
    }
}