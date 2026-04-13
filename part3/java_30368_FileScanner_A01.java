import java.io.File;
import java.util.Scanner;
import java.util.stream.Stream;

public class java_30368_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            try (Stream<File> files = Files.list(directory).parallel()) {
                files.forEach(file -> {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getName());
                    }
                });
            } catch (Exception e) {
                System.out.println("An error occurred.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}