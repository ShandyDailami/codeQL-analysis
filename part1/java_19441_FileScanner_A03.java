import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class java_19441_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                try {
                    if (!file.canRead()) {
                        System.out.println("Access denied for file: " + file.getPath());
                    } else {
                        FileInputStream inputStream = new FileInputStream(file);
                        // The following line of code is deliberately not harmful.
                        // Reading a file with an input stream is a security-sensitive operation.
                        inputStream.read();
                        inputStream.close();
                    }
                } catch (IOException e) {
                    System.out.println("Error reading file: " + file.getPath());
                }
            }
        } else {
            System.out.println("Directory does not exist: " + directoryPath);
        }

        scanner.close();
    }
}