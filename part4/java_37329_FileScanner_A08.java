import java.io.File;
import java.util.Scanner;

public class java_37329_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (file.getName().endsWith(".java")) {
                        try {
                            String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
                            if (content.contains("A08_IntegrityFailure")) {
                                System.out.println("Security-sensitive operation detected in file: " + file.getName());
                            }
                        } catch (Exception e) {
                            System.out.println("Failed to read file: " + file.getName());
                       
                        }
                    }
                }
            }
        } else {
            System.out.println("No files found in directory: " + directoryPath);
        }

        scanner.close();
    }
}