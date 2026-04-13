import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34401_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "./src"; // This should be replaced with your directory path
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files in directory.");
            return;
        }

        System.out.println("Files in directory:");
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name to search for:");
        String fileName = scanner.nextLine();

        for (File file : files) {
            if (file.getName().equals(fileName)) {
                System.out.println("File found: " + file.getAbsolutePath());
                return;
            }
        }

        System.out.println("File not found.");
    }
}