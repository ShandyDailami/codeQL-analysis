import java.io.File;
import java.util.Scanner;

public class java_10679_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File name: " + file.getName());

                        // Add your security-sensitive operation here.
                        // For example, reading file content:
                        String content = "";
                        try {
                            content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
                        } catch (Exception e) {
                            System.out.println("Error reading file: " + file.getName());
                       
                        }
                        System.out.println("File content: " + content);
                    }
                }
            } else {
                System.out.println("No files in directory");
            }
        } else {
            System.out.println("Directory does not exist or it's not a directory");
        }

        scanner.close();
    }
}