import java.io.File;
import java.security.Permission;
import java.security.SecurityManager;
import java.util.Arrays;
import java.util.Scanner;

public class java_16440_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.next();
        scanner.close();

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory not found!");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files in directory!");
            return;
        }

        Arrays.stream(files)
                .filter(file -> file.isFile() && file.canRead())
                .forEach(file -> {
                    try {
                        String fileContent = new String(Files.readAllBytes(file.toPath()));
                        System.out.println(fileContent);
                    } catch (Exception e) {
                        System.out.println("Error reading file: " + file.getName());
                    }
                });
    }

}