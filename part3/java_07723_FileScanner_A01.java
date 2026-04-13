import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07723_FileScanner_A01 {

    private String directoryPath;

    public java_07723_FileScanner_A01(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void scanDirectory() {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("Cannot list files in directory!");
            return;
        }

        for (File file : files) {
            if (!file.isFile()) {
                // Ignore directories
                continue;
            }

            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error reading file: " + file.getName());
            }
        }
    }

    public static void main(String[] args) {
        SecureFileScanner scanner = new SecureFileScanner("./"); // Change directory path
        scanner.scanDirectory();
    }
}