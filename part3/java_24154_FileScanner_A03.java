import java.io.File;
import java.util.Scanner;

public class java_24154_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                System.out.println("Scanning files in directory: " + directoryPath);
                File[] files = directory.listFiles();

                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            System.out.println("File: " + file.getName());
                        }
                    }
                }
            } else {
                System.out.println("The path provided is not a directory.");
            }
        } else {
            System.out.println("The directory provided does not exist.");
        }

        scanner.close();
    }
}