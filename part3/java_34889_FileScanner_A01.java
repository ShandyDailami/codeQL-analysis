import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_34889_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();
        File directory = new File(path);

        if (directory.exists()) {
            File[] listOfFiles = directory.listFiles();

            if (listOfFiles != null) {
                Arrays.stream(listOfFiles).forEach(file -> {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getName());
                    }
                });
            } else {
                System.out.println("No files or directories found in the specified path.");
            }
        } else {
            System.out.println("Invalid path, please try again.");
        }
    }
}