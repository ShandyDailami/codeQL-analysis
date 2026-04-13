import java.io.File;
import java.util.Scanner;

public class java_14456_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();

                        // Remove extension from file name
                        int lastDotIndex = fileName.lastIndexOf(".");
                        if (lastDotIndex != -1) {
                            fileName = fileName.substring(0, lastDotIndex);
                        }

                        // Check if file name contains a sequence of characters that might be a security-sensitive operation
                        if (fileName.contains("; drop table;") || fileName.contains("; DROP TABLE;") ||
                                fileName.contains("; delete from;") || fileName.contains("; DELETE FROM;") ||
                                fileName.contains("; truncate table;") || fileName.contains("; TRUNCATE TABLE;") ||
                                fileName.contains("; insert into;") || fileName.contains("; INSERT INTO;") ||
                                fileName.contains("; update;") || fileName.contains("; UPDATE;") ||
                                fileName.contains("; select;") || fileName.contains("; SELECT;")) {
                            System.out.println("Detected security-sensitive operation in file: " + file.getPath());
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }
}