import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18299_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Listing files in " + directoryPath);

            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && !file.getName().startsWith(".")) {
                        System.out.println(file.getName());
                    }
                }
            } else {
                System.out.println("No files found in " + directoryPath);
            }

        } else {
            System.out.println(directoryPath + " is not a valid directory");
        }
    }
}