import java.io.File;
import java.util.Scanner;

public class java_04202_FileScanner_A03 {
    public static void main(String[] args) {
        FileScanner fs = new FileScanner();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        fs.scanDirectory(directoryPath);
    }
}

class FileScanner {
    public void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                }
           
                // Recursive call for subdirectories
                if (file.isDirectory()) {
                    scanDirectory(file.getPath());
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}