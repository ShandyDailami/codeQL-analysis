import java.io.File;
import java.util.Scanner;

public class java_28316_FileScanner_A03 {
    public static void main(String[] args) {
        System.out.println("Enter the directory path:");
        Scanner scanner = new Scanner(System.in);
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getAbsolutePath());
                    String fileContent = readFile(file);

                    if (fileContent.contains("DROP") || fileContent.contains("DELETE") || fileContent.contains("TRUNCATE")) {
                        System.out.println("Security warning: Possible SQL injection attack detected. Please verify the code.");
                    }
                }
            }
        } else {
            System.out.println("Directory not found.");
        }
    }

    private static String readFile(File file) {
        StringBuilder contentBuilder = new StringBuilder();

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                contentBuilder.append(fileScanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Failed to read file: " + file.getAbsolutePath());
        }

        return contentBuilder.toString();
    }
}