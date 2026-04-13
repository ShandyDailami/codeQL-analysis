import java.io.File;
import java.util.Scanner;

public class java_18680_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        System.out.println("File name: " + file.getName());

                        String content = "";
                        try {
                            content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        System.out.println("Content: " + content);

                        // Sensitive security operation start here
                        // e.g., check for SQL Injection attacks
                        if (content.contains(";") || content.contains("'")) {
                            System.out.println("Suspicious content detected in file: " + file.getName());
                        }
                        // Sensitive security operation end here
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}