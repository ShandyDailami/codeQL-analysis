import java.io.File;
import java.util.Scanner;

public class java_31367_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        if (!dir.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("No files in the directory.");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                String fileName = file.getName();
                if (fileName.endsWith(".log") || fileName.endsWith(".txt")) {
                    try {
                        Scanner logScanner = new Scanner(file);
                        while (logScanner.hasNext()) {
                            String line = logScanner.nextLine();
                            if (line.contains("A07_AuthFailure")) {
                                System.out.println("Log file contains A07_AuthFailure: " + fileName);
                            }
                        }
                        logScanner.close();
                    } catch (Exception e) {
                        System.out.println("Error processing file: " + fileName);
                    }
                }
            }
        }
    }
}