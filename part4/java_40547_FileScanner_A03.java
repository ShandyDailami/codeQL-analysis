import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class java_40547_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                System.out.println("Scanning all files in directory: " + directoryPath);
                File[] files = directory.listFiles();

                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            System.out.println("Found file: " + file.getName());
                        }
                    }
                }
            } else {
                System.out.println("The path is not a directory");
            }
        } else {
            System.out.println("The directory does not exist");
        }
    }
}