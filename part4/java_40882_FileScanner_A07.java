import java.io.File;
import java.util.Scanner;

public class java_40882_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File directory = new File(dirPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && (file.getName().endsWith(".txt") || file.getName().endsWith(".log"))) {
                        try {
                            Scanner fileScanner = new Scanner(file);
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                if (line.contains("AuthFailure") && !line.contains("A07_AuthFailure")) {
                                    System.out.println("File: " + file.getPath());
                                    System.out.println("Line: " + line);
                                }
                           }
                            fileScanner.close();

                        } catch (Exception e) {
                            System.out.println("Error processing file: " + file.getPath());
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory not found!");
        }
    }
}