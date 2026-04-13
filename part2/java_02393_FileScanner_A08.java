import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02393_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "path_to_your_directory";
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            try {
                Scanner scanner = new Scanner(directory);
                while (scanner.hasNext()) {
                    File file = scanner.nextFile();
                    System.out.println("Found file: " + file.getName());
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Directory does not exist or is not a directory.");
            }
        } else {
            System.out.println("Provided path does not exist or is not a directory.");
        }
    }
}