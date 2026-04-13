import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08265_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Ask user for a directory
        System.out.println("Please enter a directory:");
        Scanner scanner = new Scanner(System.in);
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        // List all files in the directory
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    }
                }
            }
        } else {
            System.out.println("The directory does not exist");
        }
    }
}