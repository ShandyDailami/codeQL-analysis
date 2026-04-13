import java.io.File;
import java.util.Scanner;

public class java_27187_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                System.out.println("Searching for .txt files...");
                File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

                if (txtFiles != null) {
                    for (File txtFile : txtFiles) {
                        if (txtFile.canRead()) {
                            System.out.println("Found a .txt file: " + txtFile.getAbsolutePath());
                        } else {
                            System.out.println("Unable to read the file: " + txtFile.getAbsolutePath());
                        }
                    }
                } else {
                    System.out.println("No .txt files found in the directory or its subdirectories.");
                }
            } else {
                System.out.println("The provided path is not a directory.");
            }
        } else {
            System.out.println("The provided directory does not exist.");
        }
    }
}