import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_09359_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists()) {
            File[] listOfFiles = directory.listFiles();

            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (file.isFile()) {
                        if (file.getName().endsWith(".txt")) {
                            System.out.println("File Found: " + file.getName());
                        }
                    } else if (file.isDirectory()) {
                        System.out.println("Directory Found: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files found in directory!");
            }
        } else {
            System.out.println("The specified directory does not exist!");
        }

        scanner.close();
    }
}